package com.angeliur.sight.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.angeliur.sight.DetailsActivity
import com.angeliur.sight.R
import com.angeliur.sight.adapter.HomeListAdapter
import com.angeliur.sight.adapter.SpacesItemDecoration
import com.angeliur.sight.bean.DivListImgBean
import com.angeliur.sight.net.NetUtils
import com.angeliur.sight.net.ZResponse
import com.xfhy.basequickadapter.BaseQuickAdapter
import com.xfhy.deeplibrary.basekit.BaseFragment
import com.xfhy.deeplibrary.common.LogUtil
import com.xfhy.deeplibrary.common.dp2px
import kotlinx.android.synthetic.main.fragment_common.*

/**
 * Created by Administrator on 2018/5/22 0022.
 * 首页
 */

class CommonMainFragment : BaseFragment(),BaseQuickAdapter.RequestLoadMoreListener,BaseQuickAdapter.OnItemClickListener{

    private var mUrl: String = ""
    private var mPageCount: Int = 1
    private var mAdapter: HomeListAdapter = HomeListAdapter(R.layout.item_common_main,ArrayList())
    companion object {
        fun newInstance(url: String): CommonMainFragment{
            val args = Bundle()
            args.putString("url",url)
            val fragment = CommonMainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initArguments() {
        mUrl = arguments.getString("url")
    }

    override fun lazyLoad() {
        super.lazyLoad()
        doNetwork(false)
    }

    private fun doNetwork(isLoadMore: Boolean) {
        if (isLoadMore){
            mPageCount ++
        }
        NetUtils.reqOutList(mUrl,mPageCount,object: ZResponse{
            override fun <T> onSuccess(dataList: ArrayList<T>) {
                if (isLoadMore){
                    LogUtil.e("加载更多成功")
                    mAdapter.addData(dataList)
                    mAdapter.loadMoreComplete()
                }
            }

            override fun onError(error: String?) {
                LogUtil.e(error)
                if (isLoadMore){
                    mAdapter.loadMoreFail()
                }
            }

        })
    }

    override fun getLayoutResId(): Int = R.layout.fragment_common

    override fun initView() {
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = mAdapter
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        mAdapter.isFirstOnly(false)
        mAdapter.setDefaultHeight(dp2px(300))
        mAdapter.setOnLoadMoreListener(this,recyclerView)
        //设置item之间的间隔
        val decoration = SpacesItemDecoration(16)
        recyclerView.addItemDecoration(decoration)
        mAdapter.setOnItemClickListener(this)
        //刷新
        refreshLayout.setColorSchemeColors(resources.getColor(R.color.colorPrimary))
        refreshLayout.setOnRefreshListener {
            doNetwork(false)
        }

    }

    override fun initData() {
    }

    override fun onLoadMoreRequested() {
        doNetwork(true)
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        val listImgBean = adapter?.getItem(position) as DivListImgBean
        val intent = Intent(context,DetailsActivity::class.java)
        intent.putExtra("url",listImgBean.detailUrl)
        context.startActivity(intent)
    }

}