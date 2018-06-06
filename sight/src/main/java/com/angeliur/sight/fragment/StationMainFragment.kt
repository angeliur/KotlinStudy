package com.angeliur.sight.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.angeliur.sight.R
import com.angeliur.sight.adapter.StationTabAdapter
import com.xfhy.deeplibrary.basekit.BaseFragment
import kotlinx.android.synthetic.main.fragment_area.*

/**
 * Created by Administrator on 2018/5/22 0022.
 */

class StationMainFragment : BaseFragment(){
    companion object {
        fun newInstance(): StationMainFragment{
            val args = Bundle()
            val fragment = StationMainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_area

    override fun initView() {
        val tabAdapter = StationTabAdapter(childFragmentManager, getTabData())
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

        val mts = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/mts/")
        fragmentList.add(mts)

        val ymh = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/ymh/")
        fragmentList.add(ymh)

        val ywg = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/ywg/")
        fragmentList.add(ywg)

        val ynl = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/ynl/")
        fragmentList.add(ynl)

        val ams = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/ams/")
        fragmentList.add(ams)

        val tnl = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/tnl/")
        fragmentList.add(tnl)

        val myg = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/myg/")
        fragmentList.add(myg)

        val ygw = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/ygw/")
        fragmentList.add(ygw)

        val dnn = CommonMainFragment.newInstance("http://www.msgao.com/mzxz/dnn/")
        fragmentList.add(dnn)

        return fragmentList
    }

}