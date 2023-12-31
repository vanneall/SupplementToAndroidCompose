package com.example.fakepopfit.di

import android.content.Context
import androidx.room.Room
import com.example.fakepopfit.storage.ExerciseDao
import com.example.fakepopfit.storage.ExerciseDatabase
import com.example.fakepopfit.storage.FruitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ExerciseDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = ExerciseDatabase::class.java,
            name = "exercise_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideExerciseDao(database: ExerciseDatabase): ExerciseDao {
        return database.createExerciseDao()
    }

    @Provides
    @Singleton
    fun provideFruitDao(database: ExerciseDatabase): FruitDao {
        return database.createFruitDao()
    }
}