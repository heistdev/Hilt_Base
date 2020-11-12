package com.jadhavrupesh22.hilt_base.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Update
import com.jadhavrupesh22.hilt_base.R
import com.jadhavrupesh22.hilt_base.model.BlogCacheEntity
import com.jadhavrupesh22.hilt_base.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    var update: Boolean = true
    val scope = CoroutineScope(Main) + Job()

    // Obtain ViewModel
    private val viewModel: MainViewModel by viewModels()
    lateinit var deferred: Deferred<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var blogCacheEntity = BlogCacheEntity(10,"RJ", "This is Blog", "ABCD", "Self")

        scope.launch(IO) {
            deferred = async {
                viewModel.insertBlog(blogCacheEntity)
                return@async true
            }

        }
        scope.launch {
            deferred.await()
            viewModel.blogs.observe(this@MainActivity, Observer { blogs ->
                blogs.forEach {blog ->
                    Log.e(TAG, "BlogList   ${blog.title}")
                }
                textView.text = " ${blogs.get(0).title}"
            })
        }


    }
}
