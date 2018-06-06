package com.angeliur.sight.fragment

import android.os.Bundle
import com.angeliur.sight.R
import com.xfhy.deeplibrary.basekit.BaseFragment

/**
 * Created by Administrator on 2018/5/22 0022.
 */

class AboutFragment : BaseFragment(){
    companion object {
        fun newInstance(): AboutFragment{
            val args = Bundle()
            val fragment = AboutFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun getLayoutResId(): Int = R.layout.fragment_about

    override fun initView() {
    }

    override fun initData() {
    }

}