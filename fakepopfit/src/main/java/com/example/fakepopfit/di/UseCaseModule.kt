package com.example.fakepopfit.di

import com.example.fakepopfit.data.ExerciseRepositorySQLImpl
import com.example.fakepopfit.domain.DeleteAllFruitsUseCase
import com.example.fakepopfit.domain.DeleteUseCase
import com.example.fakepopfit.domain.GetAllExerciseUseCase
import com.example.fakepopfit.domain.GetAllFruitsFromDbUseCase
import com.example.fakepopfit.domain.GetByIdUseCase
import com.example.fakepopfit.domain.InsertUseCase
import com.example.fakepopfit.domain.UpdateUseCase
import com.example.fakepopfit.domain.WriteAllFruitsToDbUseCase
import com.example.fakepopfit.storage.FruitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetAllExerciseUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        GetAllExerciseUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideInsertUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        InsertUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideUpdateUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        UpdateUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideDeleteUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        DeleteUseCase(exerciseRepositorySQLImpl)

    @Provides
    @ViewModelScoped
    fun provideDeleteAllFruitsUseCase(fruitDao: FruitDao) =
        DeleteAllFruitsUseCase(fruitDao)

    @Provides
    @ViewModelScoped
    fun provideWriteAllFruitsToDbUseCase(fruitDao: FruitDao) =
        WriteAllFruitsToDbUseCase(fruitDao)

    @Provides
    @ViewModelScoped
    fun provideGetAllFruitsFromDbUseCase(fruitDao: FruitDao) =
        GetAllFruitsFromDbUseCase(fruitDao)

    @Provides
    @ViewModelScoped
    fun provideGetByIdUseCase(exerciseRepositorySQLImpl: ExerciseRepositorySQLImpl) =
        GetByIdUseCase(exerciseRepositorySQLImpl)
}