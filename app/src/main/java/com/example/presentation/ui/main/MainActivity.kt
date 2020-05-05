package com.example.presentation.ui.main

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.domain.Error
import com.example.domain.Load
import com.example.domain.Success
import com.example.domain.entity.PhotoEntity
import com.example.newtechnology.R
import com.example.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay

class MainActivity : BaseActivity() {

    val vm: TestViewModel by viewModels{TestViewModel.Factory(kodein)}

    val data by lazy { vm.getData() }

    override val layout = R.layout.activity_main

    override fun onViewPrepare() {
        data.observe(this, Observer {
            when(it){
                is Success<*> -> {
                    (it.result as? List<PhotoEntity>)?.let {pe ->
                        text.text = "Загрузка завершена"
                        if(pe.isNotEmpty()) {
                            Glide.with(this)
                                .load(pe.first().webImage)
                                .into(image)
                        }
                    }
                }
                is Error -> {}
                is Load -> {
                    text.text = "Загружается"
                }
            }

        })


        button.setOnClickListener {
            vm.requestChanged(editText.text.toString())
        }
    }

    suspend fun doSomething(): Int {
        delay(2000)
        return 44
    }


}
