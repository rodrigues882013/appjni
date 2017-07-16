# MUXI Challenger  #

MUXI Android App

### Tools ###

* Android Studio
* Git
* VS Code
* Vim
* Gradle
* CMake

### Enviroment ###

* Deepin 15.04 (Base debian version)

### For Build Process ###

* [Android SDK] (https://developer.android.com/studio/index.html?hl=pt-br)
* [Gradle 4.0.1] (https://gradle.org/install/)
* [CMake 3.6.4111459] (https://cmake.org/download/)
* [Android NDK] (https://developer.android.com/ndk/guides/setup.html?hl=pt-br)

### Build and Installation ###

* In command line execute

Clone this repository

    git clone https://github.com/rodrigues882013/appmuxi.git

To debug mode

    ./gradlew assembleDebug

    or

    gradle build

Install with follow commands

In android emulator

    adb install app/build/outputs/apk/app-debug.apk

In your android device

    adb -d install app/build/outputs/apk/app-debug.apk

** Or alternatively you can execute all steps above in Android Studio**
