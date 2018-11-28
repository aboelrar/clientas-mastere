package com.example.lenovo.client.library;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.lenovo.client.R;

import static android.content.Context.MODE_PRIVATE;

public class library {
    public String getLanguage(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("num",MODE_PRIVATE);
        String language=sharedPreferences.getString("num","");
        return language;
        }
    public String getTitle(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("title",MODE_PRIVATE);
        String language=sharedPreferences.getString("title","");
        return language;
    }
    public String getDistric(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("distric",MODE_PRIVATE);
        String language=sharedPreferences.getString("distric","");
        return language;
    }
    public String getListNum(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("listnum",MODE_PRIVATE);
        String language=sharedPreferences.getString("listnum","");
        return language;
    }
    public void dialog(Context context,int resource)
    {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(resource);
        int width = (int)(context.getResources().getDisplayMetrics().widthPixels*0.90);
        int height = android.view.WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setLayout(width, height);
        dialog.show();
        Button close=(Button)dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
