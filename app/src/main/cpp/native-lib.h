#include <jni.h>

//
// Created by felipe on 7/15/17.
//

extern "C" {

#ifndef APP_NATIVE_LIB_H
#define APP_NATIVE_LIB_H

JNIEXPORT void JNICALL
Java_com_felipe_app_services_NativeClient_asyncConvertToReal(JNIEnv *, jobject, jdouble);

#endif //APP_NATIVE_LIB_H

}
