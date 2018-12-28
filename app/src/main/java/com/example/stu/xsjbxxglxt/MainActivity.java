package com.example.stu.xsjbxxglxt;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.RowId;

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
        Button btn_main_insert=findViewById(R.id.btn_main_insert);
        Button query=findViewById(R.id.btn_main_query);
        Button alter=findViewById(R.id.btn_main_alter);
        Button delete=findViewById(R.id.btn_main_delete);


        btn_main_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
            }
        });

        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });

    }
    }