package com.example.lenovo.client.model;

import com.example.lenovo.client.R;
import com.example.lenovo.client.interfaces.MVP;
import com.example.lenovo.client.interfaces.MVPP;
import com.example.lenovo.client.interfaces.MVPPP;
import com.example.lenovo.client.lists.titleList;

import java.util.ArrayList;

public class radioModel implements MVPPP.interfaces.Model {

    @Override
    public ArrayList getFirstData() {
        ArrayList<titleList>arrayList=new ArrayList<titleList>();
        arrayList.add(new titleList("حلوبات","الرياض - حى الوقفا"));
        arrayList.add(new titleList("لحوم","الرياض - حى الوقفا"));
        arrayList.add(new titleList("عصائر","الرياض - حى الوقفا"));
        arrayList.add(new titleList("فاكهه","الرياض - حى الوقفا"));
        return arrayList;    }

    @Override
    public ArrayList getSecondData() {
        ArrayList<titleList>arrayList=new ArrayList<titleList>();
        arrayList.add(new titleList(R.drawable.snilkers,"سنيكرز  قالب شيكولاتة من شركة مارس لصناعة الشوكولاتة","15 ريال"));
        arrayList.add(new titleList(R.drawable.snilkers,"سنيكرز  قالب شيكولاتة من شركة مارس لصناعة الشوكولاتة","15 ريال"));
        arrayList.add(new titleList(R.drawable.snilkers,"سنيكرز  قالب شيكولاتة من شركة مارس لصناعة الشوكولاتة","15 ريال"));
        arrayList.add(new titleList(R.drawable.snilkers,"سنيكرز  قالب شيكولاتة من شركة مارس لصناعة الشوكولاتة","15 ريال"));
        arrayList.add(new titleList(R.drawable.snilkers,"سنيكرز  قالب شيكولاتة من شركة مارس لصناعة الشوكولاتة","15 ريال"));
        arrayList.add(new titleList(R.drawable.snilkers,"سنيكرز  قالب شيكولاتة من شركة مارس لصناعة الشوكولاتة","15 ريال"));
        arrayList.add(new titleList(R.drawable.snilkers,"سنيكرز  قالب شيكولاتة من شركة مارس لصناعة الشوكولاتة","15 ريال"));

        return arrayList;
    };


    @Override
    public ArrayList getThirdData() {
        ArrayList<titleList>arrayList=new ArrayList<titleList>();
        arrayList.add(new titleList("الاحرف : ا-ى","الرياض - حى الوقفا"));
        arrayList.add(new titleList("الاحرف ى-ا","الرياض - حى الوقفا"));
        arrayList.add(new titleList("السعر : من الاكثر للاقل","الرياض - حى الوقفا"));
        arrayList.add(new titleList("السعر : من الاقل للاكثر","الرياض - حى الوقفا"));
        return arrayList;
    }
}