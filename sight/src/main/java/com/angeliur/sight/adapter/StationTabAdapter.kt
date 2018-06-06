package com.angeliur.sight.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2018/5/28 0028.
 */
class StationTabAdapter(var fm: FragmentManager, var fragmentList: ArrayList<android.support.v4.app.Fragment>): FragmentPagerAdapter(fm){

    private val TAB_TITLES = arrayOf("蜜桃社", "尤蜜荟", "尤物馆", "御女郎", "爱蜜社", "推女郎", "美媛馆 ", "尤果网", "嗲囡囡")

    override fun getPageTitle(position: Int): CharSequence = TAB_TITLES[position]

    override fun getItem(position: Int): android.support.v4.app.Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

}