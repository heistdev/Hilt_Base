package com.jadhavrupesh22.hilt_base.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.jadhavrupesh22.hilt_base.R
import com.jadhavrupesh22.hilt_base.model.BlogCacheEntity
import com.jadhavrupesh22.hilt_base.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    // Obtain ViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var blogCacheEntity = BlogCacheEntity(1, "Akshay", "This is Blog", "ABCD", "Self")

        CoroutineScope(IO).launch {
            viewModel.insertBlog(blogCacheEntity)
        }



        CoroutineScope(Main).launch {
            viewModel.blogs.observe(this@MainActivity, Observer { blogs ->
                blogs.forEach { blogCacheEntity ->
                    textView.text = " ${blogCacheEntity.title}"
                    Log.e(TAG, "onCreate: ${blogCacheEntity.toString()}")
                }
            })
        }



//        mainViewModel.users.observe(this, { myUser ->
//            myUser.forEach {
//                Log.e(TAG, "onCreate: ${it.name}")
//            }
//        })

//        viewModel.users.observe(this, Observer {
//            Log.e(TAG, "onCreate: $it" )
//        })


    }
}