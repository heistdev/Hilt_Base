package com.jadhavrupesh22.hilt_base.repo

import com.jadhavrupesh22.hilt_base.model.BlogCacheEntity
import com.jadhavrupesh22.hilt_base.room.BlogDao
import kotlinx.coroutines.delay

class MainRepository
constructor(
    private val blogDao: BlogDao,
) {

    suspend fun getAllBlogs(): List<BlogCacheEntity> {
        return blogDao.get()
    }


//    var users = liveData(Dispatchers.IO) {
//        emit(mainRepo.getUsers())
//    }

    suspend fun insertBlog(blogEntity: BlogCacheEntity) {
        delay(1000)
        blogDao.insert(blogEntity)
    }


}