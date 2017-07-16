//
// Created by felipe on 7/15/17.
//

#include "native-lib.h"

double DOLLAR_VALUE = 3.5;

JNIEXPORT void JNICALL
Java_com_felipe_app_services_NativeClient_asyncConvertToReal(JNIEnv *env, jobject obj, jdouble num1)
{
    //Simple currency operation, convert dollar (US) to real (BRL)
    jclass clazz = env->FindClass("com/felipe/app/services/NativeClient");
    jmethodID nativeCallBack = env->GetMethodID(clazz, "nativeCallBack", "(D)V");
    env->CallVoidMethod(obj, nativeCallBack, num1*DOLLAR_VALUE);

//    return num1*DOLLAR_VALUE;
}
