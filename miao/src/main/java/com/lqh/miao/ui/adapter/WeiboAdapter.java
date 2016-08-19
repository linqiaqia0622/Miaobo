package com.lqh.miao.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqh.miao.R;
import com.lqh.miao.net.entity.Status;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by wenmingvs on 2015/12/29.
 */
public class WeiboAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int TYPE_ORINGIN_ITEM = 0;
    private static final int TYPE_RETWEET_ITEM = 3;

    private ArrayList<Status> mDatas;
    private Context mContext;
    private View mView;


    public WeiboAdapter(ArrayList<Status> datas, Context context) {
        this.mDatas = datas;
        this.mContext = context;
    }

    /**
     * 设置图片间距，注意要保证addItemDecoration只被调用一次，多次调用间距会累加
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            mView = LayoutInflater.from(mContext).inflate(R.layout.weibo_item, parent, false);
            OriginViewHolder originViewHolder = new OriginViewHolder(mView);
            return originViewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder instanceof OriginViewHolder) {
//
//            FillContent.fillTitleBar(mContext, mDatas.get(position), ((OriginViewHolder) holder).profile_img, ((OriginViewHolder) holder).profile_verified, ((OriginViewHolder) holder).profile_name, ((OriginViewHolder) holder).profile_time, ((OriginViewHolder) holder).weibo_comefrom);
//            FillContent.fillWeiBoContent(mDatas.get(position).text, mContext, ((OriginViewHolder) holder).weibo_content);
//            FillContent.fillButtonBar(mContext, mDatas.get(position), ((OriginViewHolder) holder).bottombar_retweet, ((OriginViewHolder) holder).bottombar_comment, ((OriginViewHolder) holder).bottombar_attitude, ((OriginViewHolder) holder).comment, ((OriginViewHolder) holder).redirect, ((OriginViewHolder) holder).feedlike);
//            FillContent.fillWeiBoImgList(mDatas.get(position), mContext, ((OriginViewHolder) holder).imageList);

            //微博背景的点击事件
            ((OriginViewHolder) holder).content.setText(mDatas.get(position).text);
            Log.i("chinamiao","adapter"+mDatas.get(position).text);

        }

    }

    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.size();
        } else {
            return 0;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position).retweeted_status != null && mDatas.get(position).retweeted_status.user != null) {
            return TYPE_RETWEET_ITEM;
        } else {
            return TYPE_ORINGIN_ITEM;
        }
    }

    public void setData(ArrayList<Status> data) {
        this.mDatas = data;
    }

    public static class OriginViewHolder extends ViewHolder {
//        public LinearLayout origin_weibo_layout;
//        public ImageView profile_img;
//        public ImageView profile_verified;
//        public TextView profile_name;
//        public TextView profile_time;
//        public TextView weibo_comefrom;
//        public EmojiTextView weibo_content;
//        public TextView redirect;
//        public TextView comment;
//        public TextView feedlike;
//        public RecyclerView imageList;
//        public LinearLayout bottombar_retweet;
//        public LinearLayout bottombar_comment;
//        public LinearLayout bottombar_attitude;
        public TextView content;

        public OriginViewHolder(View v) {
            super(v);

            content = (TextView) v.findViewById(R.id.weibo_item_content);
        }
    }


}
