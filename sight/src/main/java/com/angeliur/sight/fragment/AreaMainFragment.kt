package com.angeliur.sight.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.TabLayout.MODE_SCROLLABLE
import com.angeliur.sight.R
import com.angeliur.sight.adapter.AreaTabAdapter
import com.xfhy.deeplibrary.basekit.BaseFragment
import kotlinx.android.synthetic.main.fragment_area.*

/**
 * Created by Administrator on 2018/5/22 0022.
 */

class AreaMainFragment : BaseFragment(){

    companion object {
        fun newInstance(): AreaMainFragment{
            val args = Bundle()
            val fragment = AreaMainFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun getLayoutResId(): Int = R.layout.fragment_area

    override fun initView() {
        val tabAdapter = AreaTabAdapter(childFragmentManager, getTabData())
        viewPager.adapter = tabAdapter
        // 设置默认的缓存个数
        // viewPager.offscreenPageLimit(tabAdapter.count)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.tabMode = MODE_SCROLLABLE
    }

    /**
     * 获取tab数据
     */
    private fun getTabData(): ArrayList<android.support.v4.app.Fragment> {
        val fragmentList = ArrayList<android.support.v4.app.Fragment>()

        val zgndFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/zgnd/")
        fragmentList.add(zgndFragment)

        val twFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/tw/")
        fragmentList.add(twFragment)

        val xgFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/xg/")
        fragmentList.add(xgFragment)

        val rbFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/rb/")
        fragmentList.add(rbFragment)

        val hgFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/hg/")
        fragmentList.add(hgFragment)

        val mlxyFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/mlxy/")
        fragmentList.add(mlxyFragment)

        val tgFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/tg/")
        fragmentList.add(tgFragment)

        val omFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/om/")
        fragmentList.add(omFragment)

        val hxFragment = CommonMainFragment.newInstance("http://www.msgao.com/dqfl/hx/")
        fragmentList.add(hxFragment)

        return fragmentList
    }

    override fun initData() {
    }

}