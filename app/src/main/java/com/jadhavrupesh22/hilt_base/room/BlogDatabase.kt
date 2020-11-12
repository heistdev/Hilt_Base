package com.jadhavrupesh22.hilt_base.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jadhavrupesh22.hilt_base.model.BlogCacheEntity


@Database(entities = [BlogCacheEntity::class ], version = 1)
abstract class BlogDatabase: RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME: String = "blog_db"
    }


}