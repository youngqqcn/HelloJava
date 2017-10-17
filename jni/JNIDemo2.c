#include<jni.h>
#include <stdio.h>
#include "cn_youngqq_testjni_JNIDemo2.h"

JNIEXPORT jstring JNICALL Java_cn_youngqq_testjni_JNIDemo2_sayHello
  (JNIEnv *env, jobject thisObj, jstring name){
   char buf[128];
  const jbyte *str;
  str = (*env)->GetStringUTFChars(env, name, NULL);
  if (str == NULL) {
    return NULL; /* OutOfMemoryError already thrown */
  }
  printf("Hello %s", str);
  (*env)->ReleaseStringUTFChars(env, name, str);
  /* 假设输入字符不超过127个 */
  scanf("%s", buf);
  return (*env)->NewStringUTF(env, buf);
}