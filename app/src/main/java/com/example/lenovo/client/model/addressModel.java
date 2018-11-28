package com.example.lenovo.client.model;

import com.example.lenovo.client.R;
import com.example.lenovo.client.interfaces.MVP;
import com.example.lenovo.client.lists.titleList;

import java.util.ArrayList;

public class addressModel implements MVP.interfaces.Model {
    @Override
    public ArrayList getdata() {
        ArrayList<titleList>arrayList=new ArrayList<titleList>();
        arrayList.add(new titleList("الرياض - حى الوقفا","الرياض - حى الوقفا"));
        return arrayList;
    }
}