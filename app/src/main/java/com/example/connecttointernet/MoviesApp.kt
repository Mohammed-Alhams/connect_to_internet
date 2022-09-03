package com.example.connecttointernet

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//All apps that use Hilt must contain an Application class that is annotated with @HiltAndroidApp.
@HiltAndroidApp
class MoviesApp : Application() {
}