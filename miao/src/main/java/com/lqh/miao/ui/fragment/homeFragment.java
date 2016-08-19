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
import android.widget.TextView;

import com.lqh.miao.R;
import com.lqh.miao.mvp.presenter.imp.HomeFragmentPresentImp;
import com.lqh.miao.mvp.view.HomeFragmentView;
import com.lqh.miao.net.Constants;
import com.lqh.miao.net.entity.Status;
import com.lqh.miao.mvp.presenter.HomeFragmentPresent;
import com.lqh.miao.ui.adapter.MainActivityFragmentAdapter;
import com.lqh.miao.ui.adapter.WeiboAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/12.
 */

public class homeFragment extends BaseFragment implements HomeFragmentView {
    private ArrayList<Status> mDatas;
    public Context mContext;
    public Activity mActivity;
    WeiboAdapter weiboAdapter;
    private LinearLayout mGroup;
    public RecyclerView mRecyclerView;
    public TextView mUserName;
    public SwipeRefreshLayout mSwipeRefreshLayout;

    private long mCurrentGroup = Constants.GROUP_TYPE_ALL;
    private LinearLayout mEmptyLayout;
    private boolean mComeFromAccoutActivity;
    public View mView;
    public HomeFragmentPresent homeFragmentPresent;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     homeFragmentPresent=new HomeFragmentPresentImp(this);
        homeFragmentPresent.firstLoadData(getContext(),true);

        mView = inflater.inflate(R.layout.mainfragment_layout, container, false);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.weiboRecyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipe_refresh_widget);

        return mView;
    }
    @Override
    public void updateListView(ArrayList<Status> statuselist) {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        weiboAdapter= new WeiboAdapter(statuselist,getContext());
        mRecyclerView.setAdapter(weiboAdapter);

        for (Status status:statuselist
             ) {
            Log.i("chinamiao","weibo"+status.text);
            Log.i("chinamiao","\n weibo id"+status.id);
        }
    }

    @Override
    public void showLoadingIcon() {

    }

    @Override
    public void hideLoadingIcon() {

    }

    @Override
    public void showLoadFooterView() {

    }

    @Override
    public void hideFooterView() {

    }

    @Override
    public void showEndFooterView() {

    }

    @Override
    public void showErrorFooterView() {

    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public void scrollToTop(boolean refreshData) {

    }

    @Override
    public void showRecyclerView() {

    }

    @Override
    public void hideRecyclerView() {

    }

    @Override
    public void showEmptyBackground() {

    }

    @Override
    public void hideEmptyBackground() {

    }

    @Override
    public void popWindowsDestory() {

    }
}
