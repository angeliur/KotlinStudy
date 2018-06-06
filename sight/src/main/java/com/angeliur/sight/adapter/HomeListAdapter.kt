package com.angeliur.sight.adapter

import android.widget.ImageView
import com.angeliur.sight.R
import com.angeliur.sight.bean.DivListImgBean
import com.bumptech.glide.Glide
import com.xfhy.basequickadapter.BaseQuickAdapter
import com.xfhy.basequickadapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_common_main.view.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Administrator on 2018/5/28 0028.
 * 外层列表页
 */
class HomeListAdapter(var layoutId: Int,var listData: ArrayList<DivListImgBean>) : BaseQuickAdapter<DivListImgBean,BaseViewHolder>(layoutId,listData){

    private var itemHeight = 300

    override fun convert(holder: BaseViewHolder?, bean: DivListImgBean?) {
        val params = holder?.itemView?.layoutParams
        val random = Random()
        params?.height = itemHeight + random.nextInt(400)
        holder?.itemView?.layoutParams = params
        Glide.with(holder?.itemView).load(bean?.src).into(holder?.getView(R.id.ivGirlImage) as ImageView)
        holder?.setText(R.id.tvImageTitle,bean?.text)
    }

    fun setDefaultHeight(height: Int){
        this.itemHeight = height
    }

    fun <DivListImgBean> replaceData(data: ArrayList<DivListImgBean>){
        if (listData != data){
            listData.clear()
            listData.addAll(data)
        }
        notifyDataSetChanged()
    }

    private fun <E, T> ArrayList<E>.addAll(elements: ArrayList<T>) {
        elements.forEach{
            add(it as E)
        }
    }

    fun <DivListImgBean> addData(listdata: ArrayList<DivListImgBean>){
        this.mData.addAll(listdata)
        this.notifyItemRangeInserted(mData.size - listdata.size + this.headerLayoutCount,listdata.size)
    }

    private fun <E, T> MutableList<E>.addAll(elements: ArrayList<T>) {
        elements.forEach {
            add(it as E)
        }
    }

}


