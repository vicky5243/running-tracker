package com.googlemap.runningtracker.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Run::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class RunningDB : RoomDatabase() {
    abstract fun getRunDAO(): RunDAO
}