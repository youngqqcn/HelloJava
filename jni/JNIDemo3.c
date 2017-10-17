
#include <jni.h>
#include <stdio.h>
#include "cn_youngqq_testjni_JNIDemo3.h"



JNIEXPORT jint JNICALL Java_cn_youngqq_testjni_JNIDemo3_GetSum
  (JNIEnv *env, jobject obj, jintArray arr)
{
    jint  buf[10];
    jint *pArr;
    jint i, sum = 0;

    /*
    Get/Release<Type>ArrayElements //JVM返回的指针是原始的基本类型数组的拷贝(副本)的地址
    */

    //(*env)->GetIntArrayRegion(env, arr, 0, 10, buf);
    pArr = (*env)->GetIntArrayElements(env, arr, NULL); //获取指向数组的指针
    if(NULL == pArr)
    {
        return 0;
    }

    for(i = 0; i < 10; i++)
    {
        //sum += buf[i];
        sum += pArr[i];
    }

    (*env)->ReleaseIntArrayElements(env, arr, pArr, 0); //释放指针

    return sum;
}