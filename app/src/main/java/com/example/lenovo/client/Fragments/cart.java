package com.example.lenovo.client.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.client.R;
import com.example.lenovo.client.adapter.titleAdapter;
import com.example.lenovo.client.interfaces.MVP;
import com.example.lenovo.client.library.library;
import com.example.lenovo.client.presenter.cartPresenter;
import com.example.lenovo.client.presenter.favPresenter;
import com.example.lenovo.client.view.continueToBuy;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class cart extends Fragment implements MVP.interfaces.View {
    LinearLayout productDetails;
    View view;
    TextView favnum,continuere;
    ImageView delete;
    library library;
    RecyclerView cartList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    com.example.lenovo.client.presenter.cartPresenter cartPresenter;
    public cart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_cart, container, false);
        cartPresenter=new cartPresenter(this);
        cartPresenter.getData();
        library=new library();
        productDetails=(LinearLayout)view.findViewById(R.id.productDetails);
        continuere=(TextView)view.findViewById(R.id.continuu);
        delete=(ImageView)view.findViewById(R.id.rubbish);
        onClick();
        return view;
    }

    @Override
    public void element() {
        cartList=(RecyclerView)view.findViewById(R.id.cartList);
    }

    @Override
    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(getActivity());
        cartList.setLayoutManager(layoutManager);
        adapter=new titleAdapter(getActivity(),data,R.layout.carttitem);
        cartList.setAdapter(adapter);
        sendListNum(""+data.size());
    }

    public void sendListNum(String dataa)
    {
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("listnum",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("listnum", dataa);
        editor.commit();
    }

    public void onClick()
    {
        productDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               library.dialog(getActivity(),R.layout.productdetails);
            }
        });
        continuere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),continueToBuy.class));
            }
        });
        }
}
