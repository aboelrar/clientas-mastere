package com.example.lenovo.client.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.client.Fragments.cart;
import com.example.lenovo.client.Fragments.favourite;
import com.example.lenovo.client.Fragments.login;
import com.example.lenovo.client.Fragments.settings;
import com.example.lenovo.client.R;
import com.example.lenovo.client.adapter.titleAdapter;
import com.example.lenovo.client.adapter.viewimage;
import com.example.lenovo.client.interfaces.MVP;
import com.example.lenovo.client.interfaces.MVPP;
import com.example.lenovo.client.library.library;
import com.example.lenovo.client.presenter.categoriesPresenter;
import com.example.lenovo.client.presenter.imagePresenter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class home extends AppCompatActivity{
BottomNavigationView bottomNavigationView;
TextView listNum;
ImageView delete,back;
library library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        library=new library();
        listNum=(TextView)findViewById(R.id.listnum);
        listNum.setText(library.getListNum(this));
         delete=(ImageView)findViewById(R.id.rubbish);
         back=(ImageView)findViewById(R.id.back);
         AddFragment();
        replace();
    }

    public void AddFragment()
    {
        Fragment home = new com.example.lenovo.client.Fragments.home();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frag, home ).commit();
    }
    public void replace()
    {
        bottomNavigationView=findViewById(R.id.nav);
        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home)
                {

                    Fragment Home = new com.example.lenovo.client.Fragments.home();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frag, Home ).commit();
                    back.setImageResource(R.drawable.back);

                }else if(item.getItemId()==R.id.fav) {
                    Fragment favourite = new favourite();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frag, favourite).commit();
                    delete.setImageResource(0);
                    back.setImageResource(0);
                    }else if(item.getItemId()==R.id.cart)
                {
                    Fragment cart = new cart();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frag, cart).commit();
                    delete.setImageResource(R.drawable.rubbishbin);
                    back.setImageResource(0);
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            delete.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                    vibe.vibrate(100);
                                    Alert();
                                }
                            });

                            }
                    });
                }else if(item.getItemId()==R.id.more)
                {
                    Fragment settings = new settings();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frag, settings).commit();
                    delete.setImageResource(0);
                    back.setImageResource(0);

                }
                return true;
            }
        });
    }


    public void Alert()
{
    AlertDialog.Builder builder1 = new AlertDialog.Builder(home.this);
    builder1.setTitle("Are you sure");
    builder1.setMessage("are you sure want to delete");
    builder1.setCancelable(true);

    builder1.setPositiveButton(
            "Yes",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

    builder1.setNegativeButton(
            "No",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

    AlertDialog alert11 = builder1.create();
    alert11.show();
}
      public void onClick()
      {
          back.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  finish();
              }
          });

      }

}

