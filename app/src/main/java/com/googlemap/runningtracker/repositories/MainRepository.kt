package com.googlemap.runningtracker.repositories

import com.googlemap.runningtracker.db.Run
import com.googlemap.runningtracker.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(private val runDAO: RunDAO) {

    suspend fun insertRun(run: Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run: Run) = runDAO.deleteRun(run)

    fun getRunsByDate() = runDAO.getRunsByDate()

    fun getRunsByTimeInMillis() = runDAO.getRunsByTimeInMillis()

    fun getRunsByCaloriesBurned() = runDAO.getRunsByCaloriesBurned()

    fun getRunsByAvgSpeed() = runDAO.getRunsByAvgSpeed()

    fun getRunsByDistance() = runDAO.getRunsByDistance()

    fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()

    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()
}