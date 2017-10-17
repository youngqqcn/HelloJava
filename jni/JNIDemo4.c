

#include <jni.h>
#include <stdio.h>
#include "cn_youngqq_testjni_JNIDemo4.h"

JNIEXPORT jobjectArray JNICALL
Java_cn_youngqq_testjni_JNIDemo4_initInt2DArray(JNIEnv * env, jclass cls, jint size )
 {

    jobjectArray result ;

    int i = 0;
    jclass intArrCls = (*env)->FindClass(env, "[I");
    if(NULL == intArrCls)
    {
        printf("FindClass() error");
        return NULL;
    }

    result = (*env)->NewObjectArray(env, size, intArrCls, NULL);

    if(NULL == result)
    {
        printf("NewObjectArray() Error");
        return NULL; //error occured
    }

    for(i = 0 ; i < size; i++)
    {
        jint temp[256];
        int j  = 0;
        jintArray iarr = (*env)->NewIntArray(env, size);
        if(NULL == iarr)
        {
            printf("NewIntArray() error");
            return NULL; //error occur
        }
        for(j = 0 ; j < size; j++ )
        {
            temp[j] = i * 3 + j * 5 + i * j *7;
        }

        (*env)->SetIntArrayRegion(env, iarr, 0, size, temp);
        (*env)->SetObjectArrayElement(env, result, i, iarr);
        (*env)->DeleteLocalRef(env, iarr);
    }

    return result;
 }