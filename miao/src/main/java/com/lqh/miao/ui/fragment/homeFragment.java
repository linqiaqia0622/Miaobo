package com.lqh.miao.ui.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lqh.miao.R;
import com.lqh.miao.mvp.presenter.imp.HomeFragmentPresentImp;
import com.lqh.miao.mvp.view.HomeFragmentView;
import com.lqh.miao.net.Constants;
import com.lqh.miao.net.entity.Status;
import com.lqh.miao.mvp.presenter.HomeFragmentPresent;
import com.lqh.miao.ui.adapter.MainActivityFragmentAdapter;
import com.lqh.miao.ui.adapter.WeiboAdapter;
import com.lqh.miao.utils.LogUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/12.
 */

public class homeFragment extends BaseFragment implements HomeFragmentView {
    private ArrayList<Status> mDatas;

    public Activity mActivity;
    WeiboAdapter weiboAdapter;
    private LinearLayout mGroup;
    public RecyclerView mRecyclerView;
    public TextView mUserName;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public Context mContext;
    private long mCurrentGroup = Constants.GROUP_TYPE_ALL;
    private LinearLayout mEmptyLayout;
    private boolean mComeFromAccoutActivity;
    public View mView;
    public ProgressBar mprogressbar;
    public HomeFragmentPresent homeFragmentPresent;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity=getActivity();
        mContext=getContext();

        mView = inflater.inflate(R.layout.mainfragment_layout, container, false);
        mprogressbar=(ProgressBar)mView.findViewById(R.id.weibo_item_progressbar);
        initRecyclerView();
        initRefreshLayout();
        initGroupWindows();

        homeFragmentPresent=new HomeFragmentPresentImp(this);
        homeFragmentPresent.firstLoadData(getContext(),true);

        return mView;
    }
    public void initRecyclerView(){
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.weiboRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        weiboAdapter= new WeiboAdapter(mDatas,getContext());
        mRecyclerView.setAdapter(weiboAdapter);
    }
    public void initGroupWindows(){


    }public void initRefreshLayout(){
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                homeFragmentPresent.pullToRefreshData(mCurrentGroup, mContext);
            }
        });
    }
    @Override
    public void updateListView(ArrayList<Status> statuselist) {
        mDatas=statuselist;
        weiboAdapter.setData(mDatas);
        weiboAdapter.notifyDataSetChanged();
        mprogressbar.setVisibility(View.GONE);

//
//        for (Status status:statuselist
//             ) {
//            Log.i("chinamiao","weibo"+status.text);
//            Log.i("chinamiao","\n weibo id"+status.id);
//        }
    }

    @Override
    public void showLoadingIcon() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
        mSwipeRefreshLayout.setRefreshing(true);
    }
        LogUtil.i("showLoadingIcon");
    }

    @Override
    public void hideLoadingIcon() {
        LogUtil.i("hideLoadingIcon");
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showLoadFooterView() {

        LogUtil.i("showLoadFooterView");
    }

    @Override
    public void hideFooterView() {

        LogUtil.i("hideFooterView");
    }

    @Override
    public void showEndFooterView() {

        LogUtil.i("showEndFooterView");
    }

    @Override
    public void showErrorFooterView() {

        LogUtil.i("showErrorFooterView");
    }

    @Override
    public void setUserName(String userName) {

        LogUtil.i("setUserName");
    }

    @Override
    public void scrollToTop(boolean refreshData) {

        LogUtil.i("scrollToTop"+refreshData);
    }

    @Override
    public void showRecyclerView() {

        LogUtil.i("showRecyclerView");
    }

    @Override
    public void hideRecyclerView() {
        LogUtil.i("hideRecyclerView");
    }

    @Override
    public void showEmptyBackground() {
        LogUtil.i("showEmptyBackground");
    }

    @Override
    public void hideEmptyBackground() {
        LogUtil.i("hideEmptyBackground");
    }

    @Override
    public void popWindowsDestory() {
        LogUtil.i("popWindowsDestory");
    }
}
