package com.example.presentation.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.domain.entity.PhotoEntity
import com.example.newtechnology.R
import kotlinx.android.synthetic.main.photos_pager_layout.view.*


class ImagesPagerAdapter : PagerAdapter() {


    var photos: List<PhotoEntity> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val layout = inflater.inflate(R.layout.photos_pager_layout, container, false)
        Glide.with(container.context)
            .load(photos[position].webImage)
            .into(layout.photo)
        layout.tagg.text = photos[position].tags
        container.addView(layout)

        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return photos.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }


}
