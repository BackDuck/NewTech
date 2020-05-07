package com.example.presentation.ui.main

import com.bumptech.glide.Glide
import com.example.domain.entity.PhotoEntity
import com.example.newtechnology.R
import com.example.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    val vm: TestViewModel by viewModel()

    override val layout = R.layout.activity_main

    val adapter = get<ImagesPagerAdapter>()

    override fun onViewPrepare() {

        pager.adapter = adapter

        button.setOnClickListener {
            followLiveData<List<PhotoEntity>>(vm.requestChanged(editText.text.toString())){
                if(it.isNotEmpty()) {
                    adapter.photos = it
                    pager.setCurrentItem(0, false)
                }
            }
        }
    }

}
