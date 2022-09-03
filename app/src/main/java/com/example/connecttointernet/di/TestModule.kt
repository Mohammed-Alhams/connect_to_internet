package com.example.connecttointernet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

//Hilt can provide dependencies to other Android classes that have the @AndroidEntryPoint annotation
@Module
@InstallIn(ActivityComponent::class)
object TestModule {

    @Provides
    fun provideString() : String = "Hello i am injected"

}