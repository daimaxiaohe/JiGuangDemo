package com.example.weidumoviedemo.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.weidumoviedemo.R
import com.example.weidumoviedemo.app.MyApp
import com.example.weidumoviedemo.bean.ListResult

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
class ShowAdapter(layoutResId: Int, data: List<ListResult>) : BaseQuickAdapter<ListResult, ShowAdapter.ShowViewHolder>(layoutResId, data) {

    override fun convert(helper: ShowViewHolder?, item: ListResult?) {
        helper!!.setText(R.id.name,item!!.title)
        Glide.with(MyApp.context).load(item.thumbnail).apply(RequestOptions.bitmapTransform(RoundedCorners(8))).into(helper.getView(R.id.img))
    }

    class ShowViewHolder(view: View) : BaseViewHolder(view){

    }
}