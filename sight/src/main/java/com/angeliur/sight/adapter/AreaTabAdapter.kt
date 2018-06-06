package com.angeliur.sight.adapter

import android.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2018/5/28 0028.
 */
class AreaTabAdapter(var fm: FragmentManager,var fragmentList: ArrayList<android.support.v4.app.Fragment>): FragmentPagerAdapter(fm){

    private val TAB_TITLES = arrayOf("中国内地", "台湾", "香港", "日本", "韩国", "马来西亚", "泰国", "欧美", "混血")

    override fun getPageTitle(position: Int): CharSequence = TAB_TITLES[position]

    override fun getItem(position: Int): android.support.v4.app.Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

}