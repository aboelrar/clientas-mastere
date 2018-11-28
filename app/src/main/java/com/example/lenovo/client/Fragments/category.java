package com.example.lenovo.client.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.lenovo.client.R;
import com.example.lenovo.client.adapter.titleAdapter;
import com.example.lenovo.client.interfaces.MVPPP;
import com.example.lenovo.client.library.library;
import com.example.lenovo.client.presenter.radioPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class category extends Fragment implements MVPPP.interfaces.View {
    View view;
    RecyclerView categoryList,RadioList;
    RecyclerView.Adapter adapter,radioAdapter1,radioAdapter2;
    RecyclerView.LayoutManager layoutManager,radioManager1,RadioManager2;
    ImageView grid,list;
    ViewSwitcher switcher1;
    ImageView category;
    LinearLayout categoryaList;
    com.example.lenovo.client.presenter.radioPresenter favPresenter;
    library library;
    public category() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_category, container, false);
        grid=(ImageView) view.findViewById(R.id.grid);
        list=(ImageView)view.findViewById(R.id.list);
        switcher1= (ViewSwitcher) view.findViewById(R.id.my_switcher);
        categoryaList=(LinearLayout)view.findViewById(R.id.categoryList);
        category=(ImageView)view.findViewById(R.id.categorydd);
        favPresenter=new radioPresenter(this);
        favPresenter.getSecondData();
        library=new library();
        onClick();
        return view;
    }

    @Override
    public void element() {
        categoryList=(RecyclerView)view.findViewById(R.id.catlist);

        }

    @Override
    public void setfirstData(final ArrayList data) {


    }

    @Override
    public void setSecondData(final ArrayList data) {
        setAdapter(data,R.layout.productitem);
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutManager=new GridLayoutManager(getActivity(),2);
                categoryList.setLayoutManager(layoutManager);
                adapter=new titleAdapter(getActivity(),data,R.layout.gridproductitem);
                categoryList.setAdapter(adapter);
                switcher1.showNext();
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdapter(data,R.layout.productitem);
                switcher1.showNext();

            }
        });
    }

    @Override
    public void setThirdData(ArrayList data) {

    }


    public void setAdapter(ArrayList data,int resource)
    {
        layoutManager=new LinearLayoutManager(getActivity());
        categoryList.setLayoutManager(layoutManager);
        adapter=new titleAdapter(getActivity(),data,resource);
        categoryList.setAdapter(adapter);
    }

    private void onClick()
    {
        categoryaList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                library.dialog(getActivity(),R.layout.radiobutton);
            }
        });
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                library.dialog(getActivity(),R.layout.filter);
            }
        });
    }
}
