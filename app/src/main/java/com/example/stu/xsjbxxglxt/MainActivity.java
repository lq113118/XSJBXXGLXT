package com.example.stu.xsjbxxglxt;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tv_main_xi,tv_main_bj,tv_main_xh,tv_main_xm,tv_main_xb,tv_main_mz,
            tv_main_csrq,tv_main_rxrq,tv_main_xjzk, tv_main_jg,tv_main_jtzz,tv_main_ssh;
    TextView tv_main_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main_bj = findViewById(R.id.tv_main_bj);
        tv_main_xh = findViewById(R.id.tv_main_xh);
        tv_main_xm = findViewById(R.id.tv_main_xm);
        tv_main_jg = findViewById(R.id.tv_main_jg);
        tv_main_ssh = findViewById(R.id.tv_main_ssh);
        tv_main_jtzz = findViewById(R.id.tv_main_jtzz);
        tv_main_display = findViewById(R.id.tv_main_display);


    }
    }