//
// Created by felipe on 7/15/17.
//

#include "native-lib.h"

double DOLLAR_VALUE = 3.5;

JNIEXPORT void JNICALL
Java_com_felipe_app_services_NativeAPI_asyncConvertToReal(JNIEnv *env, jobject obj, jdouble num1, jint pos)
{
    //Simple currency operation, convert dollar (US) to real (BRL)
    jclass clazz = env->FindClass("com/felipe/app/services/NativeAPI");
    jmethodID native_callBack = env->GetMethodID(clazz, "nativeCallBack", "(D)V");
    jmethodID set_current_position = env->GetMethodID(clazz, "setCurrentPosition", "(I)V");

    env->CallVoidMethod(obj, set_current_position, pos);
    env->CallVoidMethod(obj, native_callBack, num1*DOLLAR_VALUE);

//    return num1*DOLLAR_VALUE;
}
