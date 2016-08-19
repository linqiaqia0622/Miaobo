package com.lqh.miao.ui.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lqh.miao.R;
import com.lqh.miao.mvp.view.HomeFragmentView;
import com.lqh.miao.net.entity.Status;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/12.
 */

public class MessageFragment extends BaseFragment implements HomeFragmentView {
    public View mView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.messagefragment_layout, container, false);

        return mView;
    }
    @Override
    public void updateListView(ArrayList<Status> statuselist) {

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
