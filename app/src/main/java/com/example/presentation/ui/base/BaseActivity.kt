package com.example.presentation.ui.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.newtechnology.R
import com.example.utils.Error
import com.example.utils.Load
import com.example.utils.State
import com.example.utils.Success

abstract class BaseActivity : AppCompatActivity(){

    abstract val layout: Int

    val mainLoader: View? by lazy {
        findViewById<View>(R.id.main_loader)
    }

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        onViewPrepare()
    }

    open fun onViewPrepare(){

    }

    fun <T> followLiveData(liveData: MutableLiveData<State>, successAction: (T) -> Unit){
        liveData.observe(this, Observer {
            when(it){
                is Load -> {
                    showLoad()
                }
               is Success<*> -> {
                   hideLoad()
                   (it.result as? T)?.let(successAction)
               }
               is Error -> {
                   hideLoad()
                   showError(it.error)
               }
            }
        })
    }

    open fun showLoad(){
        mainLoader?.visibility = View.VISIBLE
    }

    open fun hideLoad(){
        mainLoader?.visibility = View.GONE
    }

    open fun showError(e: Exception){
        Toast.makeText(this, "Произошла Ошибка!", Toast.LENGTH_SHORT).show()
    }
}