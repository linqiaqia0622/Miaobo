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
import com.lqh.miao.ui.FillContent;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wenmingvs on 2015/12/29.
 */
public class WeiboAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int TYPE_ORINGIN_ITEM = 0;
    private static final int TYPE_RETWEET_ITEM = 3;

    private static final int TYPE_FOOTER = 1;
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
        if (viewType==TYPE_FOOTER){
            mView = LayoutInflater.from(mContext).inflate(R.layout.weibo_list_footer, parent, false);
            Footer footer = new Footer(mView);
            return footer;
        }
            mView = LayoutInflater.from(mContext).inflate(R.layout.weibo_item, parent, false);
            OriginViewHolder originViewHolder = new OriginViewHolder(mView);
            return originViewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder instanceof OriginViewHolder) {
//
           FillContent.fillTitleBar(mContext, mDatas.get(position), ((OriginViewHolder) holder).profile_img, ((OriginViewHolder) holder).profile_verified, ((OriginViewHolder) holder).profile_name, ((OriginViewHolder) holder).profile_time, ((OriginViewHolder) holder).weiboComeFrom);
//            FillContent.fillWeiBoContent(mDatas.get(position).text, mContext, ((OriginViewHolder) holder).weibo_content);
//            FillContent.fillButtonBar(mContext, mDatas.get(position), ((OriginViewHolder) holder).bottombar_retweet, ((OriginViewHolder) holder).bottombar_comment, ((OriginViewHolder) holder).bottombar_attitude, ((OriginViewHolder) holder).comment, ((OriginViewHolder) holder).redirect, ((OriginViewHolder) holder).feedlike);
//            FillContent.fillWeiBoImgList(mDatas.get(position), mContext, ((OriginViewHolder) holder).imageList);

            //微博背景的点击事件
            ((OriginViewHolder) holder).content.setText(mDatas.get(position).text);
//            ((OriginViewHolder) holder).profile_name.setText(mDatas.get(position).user.name);
//            ((OriginViewHolder) holder).profile_time.setText(mDatas.get(position).created_at);
//            ((OriginViewHolder) holder).weiboComeFrom.setText(mDatas.get(position).source);
          //  ((OriginViewHolder) holder).content.setText(mDatas.get(position).text);
            Log.i("chinamiao","adapter"+mDatas.get(position).text);

        }

    }

    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.size()+1;
        } else {
            return 0;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position==mDatas.size()){
            return  TYPE_FOOTER;
        }
        if (mDatas.get(position).retweeted_status != null && mDatas.get(position).retweeted_status.user != null) {
            return TYPE_RETWEET_ITEM;
        } else {
            return TYPE_ORINGIN_ITEM;
        }
    }

    public void setData(ArrayList<Status> data) {
        this.mDatas = data;
    }
    public static class Footer extends  ViewHolder{
        public Footer(View itemView) {
            super(itemView);

        }
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


        @BindView(R.id.weibo_item_content) TextView content;
        @BindView(R.id.weibo_item_profile_name) TextView profile_name;
        @BindView(R.id.weibo_item_image) RecyclerView image;
        @BindView(R.id.weibo_item_profile_verified) ImageView profile_verified;
    //    @BindView(R.id.weibo_item_retweet) TextView retweet;
     //   @BindView(R.id.weibo_item_comment) TextView comment;
        @BindView(R.id.weibo_item_profile_time) TextView profile_time;
        @BindView(R.id.weibo_item_weiboComeFrom) TextView weiboComeFrom;
        @BindView(R.id.weibo_item_profile_img)  ImageView profile_img;

       // @Bind(R.id.job_title) TextView jobTitle;
        public OriginViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

           // content = (TextView) v.findViewById(R.id.weibo_item_content);
        }
    }


}
