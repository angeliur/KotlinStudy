package com.angeliur.sight.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.angeliur.sight.R
import com.angeliur.sight.adapter.DigTabAdapter
import com.xfhy.deeplibrary.basekit.BaseFragment
import kotlinx.android.synthetic.main.fragment_area.*

/**
 * Created by Administrator on 2018/5/22 0022.
 */

class DigMainFragment : BaseFragment(){

    companion object {
        fun newInstance(): DigMainFragment{
            val args = Bundle()
            val fragment = DigMainFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun getLayoutResId(): Int = R.layout.fragment_area

    override fun initView() {
        val tabAdapter = DigTabAdapter(childFragmentManager, getTabData())
        viewPager.adapter = tabAdapter
        tabLayout.setupWithViewPager(viewPager)
        //可滑动
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
    }


    override fun initData() {

    }

    /**
     * 获取tab数据
     */
    private fun getTabData(): ArrayList<Fragment> {
        val fragmentList = ArrayList<Fragment>()

        val rqstar = CommonMainFragment.newInstance("http://www.msgao.com/rbtt/rqstar/")
        fragmentList.add(rqstar)

        val yswebtt = CommonMainFragment.newInstance("http://www.msgao.com/rbtt/yswebtt/")
        fragmentList.add(yswebtt)

        val dgctt = CommonMainFragment.newInstance("http://www.msgao.com/rbtt/dgctt/")
        fragmentList.add(dgctt)

        val bomb = CommonMainFragment.newInstance("http://www.msgao.com/rbtt/bomb.tv/")
        fragmentList.add(bomb)

        val misty = CommonMainFragment.newInstance("http://www.msgao.com/rbtt/misty/")
        fragmentList.add(misty)

        val sabra = CommonMainFragment.newInstance("http://www.msgao.com/rbtt/sabra.net/")
        fragmentList.add(sabra)

        val kstar = CommonMainFragment.newInstance("http://www.msgao.com/rbtt/4kstar/")
        fragmentList.add(kstar)

        return fragmentList
    }

}