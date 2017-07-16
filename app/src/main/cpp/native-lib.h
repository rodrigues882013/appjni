#include <jni.h>

//
// Created by felipe on 7/15/17.
//

extern "C" {

#ifndef APP_NATIVE_LIB_H
#define APP_NATIVE_LIB_H

JNIEXPORT void JNICALL
Java_com_felipe_app_services_NativeAPI_asyncConvertToReal(JNIEnv *, jobject, jdouble, jint);

#endif //APP_NATIVE_LIB_H

}
