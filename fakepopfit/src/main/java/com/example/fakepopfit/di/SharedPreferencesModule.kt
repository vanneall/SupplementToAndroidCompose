package com.example.fakepopfit.di

import android.content.Context
import com.example.fakepopfit.data.ImageSharedPrefRepImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesForImage(@ApplicationContext context: Context) =
        ImageSharedPrefRepImpl(context)

}