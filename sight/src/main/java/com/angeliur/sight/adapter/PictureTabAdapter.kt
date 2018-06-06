package com.angeliur.sight.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2018/5/28 0028.
 */
class PictureTabAdapter(var fm: FragmentManager, var fragmentList: ArrayList<android.support.v4.app.Fragment>): FragmentPagerAdapter(fm){

    private val TAB_TITLES = arrayOf("性感", "养眼", "诱惑", "美腿", "黑丝", "清新", "内衣", "治愈系", "清纯", "气质",
            "冷艳", "野性", "骨感", "女神", "制服", "人间胸器", "比基尼", "萌系", "极品", "娇小萝莉", "波涛胸涌", "童颜巨乳"
            , "肉感", "白嫩", "小麦色", "尤物", "足球宝贝", "角色扮演", "大尺度", "湿身", "校服", "护士", "女仆", "少妇")

    override fun getPageTitle(position: Int): CharSequence = TAB_TITLES[position]

    override fun getItem(position: Int): android.support.v4.app.Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

}