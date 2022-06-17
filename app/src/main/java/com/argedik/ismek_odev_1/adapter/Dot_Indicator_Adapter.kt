package com.argedik.ismek_odev_1.adapter

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter

class Dot_Indicator_Adapter (private val context: Context, private var imageList: ArrayList<String>): PagerAdapter(){
    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }
}