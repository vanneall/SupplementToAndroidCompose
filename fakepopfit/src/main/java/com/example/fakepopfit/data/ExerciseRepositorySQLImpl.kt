package com.example.fakepopfit.data

import androidx.lifecycle.LiveData
import com.example.fakepopfit.storage.ExerciseDao
import javax.inject.Inject

class ExerciseRepositorySQLImpl @Inject constructor(private val exerciseDao: ExerciseDao) :
    ExerciseRepository {
    override fun getAllExercise(): LiveData<List<Exercise>> = exerciseDao.getAllExercise()
    override fun getById(id: Int): Exercise = exerciseDao.getById(id)
    override suspend fun insert(exercise: Exercise) = exerciseDao.insertExercise(exercise)
    override suspend fun update(exercise: Exercise) = exerciseDao.updateExercise(exercise)
    override suspend fun delete(exercise: Exercise) = exerciseDao.deleteExercise(exercise)
}