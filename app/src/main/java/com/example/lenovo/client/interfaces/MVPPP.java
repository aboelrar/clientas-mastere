package com.example.lenovo.client.interfaces;

import java.util.ArrayList;

public interface MVPPP {
    public interface interfaces {
        interface  View
        {
            void element();
            void setfirstData(ArrayList data);
            void setSecondData(ArrayList data);
            void setThirdData(ArrayList data);


        }
        interface Model{
            ArrayList getFirstData();
            ArrayList getSecondData();
            ArrayList getThirdData();


        }
        interface presenter{
            void getFirstData();
            void getSecondData();
            void getThirdData();
        }

    }
}
