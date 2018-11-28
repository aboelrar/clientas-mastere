package com.example.lenovo.client.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.client.R;

public class sendBill extends AppCompatActivity {
    TextView send,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_bill);
        send=(TextView) findViewById(R.id.send);
        back=(TextView)findViewById(R.id.back);
        onClick();
    }

    public void onClick()
    {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sendBill.this,home.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sendBill.this,home.class));
            }
        });
    }
}
