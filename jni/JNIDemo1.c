#include <jni.h>
#include<stdio.h>
#include "cn_youngqq_testjni_JNIDemo1.h"

JNIEXPORT void JNICALL Java_cn_youngqq_testjni_JNIDemo1_sayHello(JNIEnv *env, jobject thisObj) {
   printf("Hello JNI!\n");
   return;
}


