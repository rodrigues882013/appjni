//
// Created by felipe on 7/15/17.
//

#include "native-lib.h"

JNIEXPORT jdouble JNICALL
Java_com_felipe_app_services_NativeClient_callbackToNative(JNIEnv *env, jobject obj, jdouble num1)
{
    //Simple survey operation, convert dollar (US) to real (BRL)
    return num1*3.5;
}
