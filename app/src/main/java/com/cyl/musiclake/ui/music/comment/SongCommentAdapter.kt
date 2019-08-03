package com.cyl.musiclake.ui.music.comment


import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.cyl.musicapi.bean.BeRepliedItem
import com.cyl.musicapi.bean.SongComment
import com.cyl.musiclake.R
import com.cyl.musiclake.utils.CoverLoader
import com.cyl.musiclake.utils.FormatUtil

/**
 * 作者：yonglong on 2016/8/10 21:36
 * 邮箱：643872807@qq.com
 * 版本：2.5
 */
class SongCommentAdapter(list: List<SongComment>) : BaseQuickAdapter<SongComment, BaseViewHolder>(R.layout.item_comment, list) {
    val TAG = "SongCommentAdapter"
    override fun convert(helper: BaseViewHolder, item: SongComment) {
        helper.setText(R.id.tv_comment_user, item.nick)
        helper.setText(R.id.tv_comment_time, FormatUtil.formatDate(item.time))
        helper.setText(R.id.tv_comment_content, item.content)
//        val beReplied = item.beReplied
////        val size = beReplied?.size
////        val rvReplie = helper.getView<RecyclerView>(R.id.rv_replie)
////        if (size!! > 0) {
////            rvReplie.visibility = View.VISIBLE;
////            LogUtil.d(TAG, "convert SongComment " + item)
////            rvReplie.layoutManager = LinearLayoutManager(rvReplie.context, LinearLayoutManager.VERTICAL, false)
////            rvReplie.adapter = ReplieAdapter(beReplied)
////        } else {
////            rvReplie.visibility = View.GONE;
////        }
        CoverLoader.loadImageView(mContext, item.avatarUrl, helper.getView(R.id.civ_cover))
    }

    class ReplieAdapter(list: List<BeRepliedItem>) : BaseQuickAdapter<BeRepliedItem, BaseViewHolder>(R.layout.item_comment, list) {
        override fun convert(helper: BaseViewHolder, item: BeRepliedItem) {
            helper.getView<View>(R.id.rv_replie).visibility = View.GONE
            helper.getView<View>(R.id.tv_comment_time).visibility = View.GONE
            helper.setText(R.id.tv_comment_user, item.user.nickname)
            helper.setText(R.id.tv_comment_time, item.user.remarkName)
            helper.setText(R.id.tv_comment_content, item.content)
            CoverLoader.loadImageView(mContext, item.user.avatarUrl, helper.getView(R.id.civ_cover))

        }

    }
}