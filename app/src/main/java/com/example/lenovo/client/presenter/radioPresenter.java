package com.example.lenovo.client.presenter;

import com.example.lenovo.client.interfaces.MVP;
import com.example.lenovo.client.interfaces.MVPP;
import com.example.lenovo.client.interfaces.MVPPP;
import com.example.lenovo.client.model.imageModel;
import com.example.lenovo.client.model.radioModel;

import java.util.ArrayList;

public class radioPresenter implements MVPPP.interfaces.presenter {
    private MVPPP.interfaces.Model model;
    private MVPPP.interfaces.View views;


    public radioPresenter(MVPPP.interfaces.View view) {
        this.views = view;
        initPresenter();
    }
    private void initPresenter() {
        model = new radioModel();
        views.element();
    }

    @Override
    public void getFirstData() {
        ArrayList data=model.getFirstData();
        views.setfirstData(data);
    }

    @Override
    public void getSecondData() {
        ArrayList data=model.getSecondData();
        views.setSecondData(data);
    }

    @Override
    public void getThirdData() {
        ArrayList data=model.getThirdData();
        views.setThirdData(data);
    }
}