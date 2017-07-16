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

* [Android SDK](https://developer.android.com/studio/index.html?hl=pt-br)
* [Gradle 4.0.1](https://gradle.org/install/)
* [CMake 3.6.4111459](https://cmake.org/download/)
* [Android NDK](https://developer.android.com/ndk/guides/setup.html?hl=pt-br)

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


If you can't build application, [download](https://drive.google.com/open?id=0BzG_Ts3_SqdeLWNBdDNuQ0YwX2s) apk 

### Considerations ###

For building app I chosen a popular android toolchain, I used the libraries below:
 
* Retrofit2 for http call
* Picasso for handling with image download
* Dagger2 for dependency injection
* ReactiveX (with RxAndroid extension) for handle with asynchronous code.

Unfortunately I don't made unit tests neither instrumental tests because I don't had nothing previous experience with android tests and I couldn't produce satisfactory results in time.  



** Or alternatively you can execute all steps above in Android Studio**
