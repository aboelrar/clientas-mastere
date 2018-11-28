package com.example.lenovo.client.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.client.R;
import com.example.lenovo.client.adapter.titleAdapter;
import com.example.lenovo.client.interfaces.MVP;
import com.example.lenovo.client.presenter.addressPresenter;

import java.util.ArrayList;

public class continueToBuy extends AppCompatActivity implements MVP.interfaces.View {
 RecyclerView addressList;
 RecyclerView.Adapter adapter;
 RecyclerView.LayoutManager layoutManager;
 Button continueRequest;
    addressPresenter addressPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_to_buy);
        continueRequest=(Button)findViewById(R.id.continuerequest);
        addressPresenter=new addressPresenter(this);
        addressPresenter.getData();
        onClick();
    }

    @Override
    public void element() {
      addressList=(RecyclerView)findViewById(R.id.shippingAddressList);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(this);
        addressList.setLayoutManager(layoutManager);
        adapter=new titleAdapter(this,data,R.layout.addressitem);
        addressList.setAdapter(adapter);
    }
    public void onClick()
    {
        continueRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(continueToBuy.this,sendBill.class));
            }
        });
    }
}
