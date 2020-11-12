package com.jadhavrupesh22.hilt_base.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jadhavrupesh22.hilt_base.model.BlogCacheEntity
import com.jadhavrupesh22.hilt_base.repo.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import java.util.*

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject constructor(private val mainRepository: MainRepository) : ViewModel() {


    var blogs = liveData(Dispatchers.IO) {
        emit(mainRepository.getAllBlogs())
    }

    suspend fun insertBlog(blogCacheEntity: BlogCacheEntity) {
        delay(500)  // Simulate long operation
        mainRepository.insertBlog(blogCacheEntity)
    }


}