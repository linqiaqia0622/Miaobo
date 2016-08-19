package com.lqh.miao.mvp.model;

import android.content.Context;


import com.lqh.miao.net.entity.Status;

import java.util.ArrayList;

/**
 * Created by wenmingvs on 16/5/14.
 */
public interface StatusListModel {

    interface OnDataFinishedListener {
        void noMoreData();

        void noDataInFirstLoad();

        void onDataFinish(ArrayList<Status> statuslist);

        void onError(String error);
    }


    public void friendsTimeline(Context context, OnDataFinishedListener onDataFinishedListener);

    public void friendsTimelineNextPage(Context context, OnDataFinishedListener onDataFinishedListener);

    public void friendsTimelineCacheLoad(Context context, OnDataFinishedListener onDataFinishedListener);

    public void friendsTimelineCacheSave(Context context, String response);

    public void bilateralTimeline(Context context, OnDataFinishedListener onDataFinishedListener);

    public void bilateralTimelineNextPage(Context context, OnDataFinishedListener onDataFinishedListener);

    public void timeline(long groundId, Context context, OnDataFinishedListener onDataFinishedListener);

    public void timelineNextPage(long groundId, Context context, OnDataFinishedListener onDataFinishedListener);


}
