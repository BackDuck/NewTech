package com.example.presentation.ui.main

import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.domain.entity.PhotoEntity
import com.example.newtechnology.R
import com.example.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    val vm: TestViewModel by viewModel()

    override val layout = R.layout.activity_main

    override fun onViewPrepare() {

        button.setOnClickListener {
            followLiveData<List<PhotoEntity>>(vm.requestChanged(editText.text.toString())){
                if(it.isNotEmpty()) {
                    Glide.with(this)
                        .load(it.first().webImage)
                        .into(image)
                }
            }
        }
    }

}
