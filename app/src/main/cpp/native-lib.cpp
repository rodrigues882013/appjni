//
// Created by felipe on 7/15/17.
//

#include "native-lib.h"

double DOLLAR_VALUE = 3.5;

JNIEXPORT jdouble JNICALL
Java_com_felipe_app_services_NativeClient_callbackToNative(JNIEnv *env, jobject obj, jdouble num1)
{
    //Simple currency operation, convert dollar (US) to real (BRL)
    return num1*DOLLAR_VALUE;
}
