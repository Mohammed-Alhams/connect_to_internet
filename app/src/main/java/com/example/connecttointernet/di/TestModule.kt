package com.example.connecttointernet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

//Hilt can provide dependencies to other Android classes that have the @AndroidEntryPoint annotation
@Module
@InstallIn(ActivityComponent::class)
object TestModule {

    @Provides
    @Named("first")
    fun provideString() : String = "Hello i am injected"

    @Provides
    @Named("second")
    fun provideSecondString() : String = "im am second injected string"

}