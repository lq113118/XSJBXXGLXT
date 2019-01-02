package com.example.stu.xsjbxxglxt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    MyHelper myHelper = new MyHelper(this);
    private EditText tv_main_bj, tv_main_xh, tv_main_xm,
              tv_main_jg, tv_main_jtzz, tv_main_ssh;
    private TextView tv_main_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
private  void init () {
    tv_main_bj = (EditText)findViewById(R.id.tv_main_bj);
    tv_main_xh = (EditText)findViewById(R.id.tv_main_xh);
    tv_main_xm = (EditText)findViewById(R.id.tv_main_xm);
    tv_main_jg = (EditText)findViewById(R.id.tv_main_jg);
    tv_main_ssh = (EditText)findViewById(R.id.tv_main_ssh);
    tv_main_jtzz = (EditText)findViewById(R.id.tv_main_jtzz);
    tv_main_display = (TextView)findViewById(R.id.tv_main_display);
    Button btn_main_insert = (Button) findViewById(R.id.btn_main_insert);
    Button btn_main_query = (Button)findViewById(R.id.btn_main_query);
    Button btn_main_alter = (Button)findViewById(R.id.btn_main_alter);
    Button btn_main_delete = (Button)findViewById(R.id.btn_main_delete);
    btn_main_insert.setOnClickListener(this);
    btn_main_query.setOnClickListener(this);
    btn_main_alter.setOnClickListener(this);
    btn_main_delete.setOnClickListener(this);

}
@Override
        public void onClick(View v){
   String xh;
   String ssh;
   String bj;
   String xm;
   String jg;
   String jtzz;
   SQLiteDatabase db;
   ContentValues values;
   switch (v.getId()){
       case R.id.btn_main_insert:                                                             //添加
           xm = tv_main_xm.getText().toString();
           bj =tv_main_bj.getText().toString();
           xh=tv_main_xh.getText().toString();
           jg=tv_main_jg.getText().toString();
           jtzz=tv_main_jtzz.getText().toString();
           ssh=tv_main_ssh.getText().toString();
           db=myHelper.getWritableDatabase();
           values=new ContentValues();
           values.put("xm",xm);
           values.put("bj",bj);
           values.put("xh",xh);
           values.put("jg",jg);
           values.put("jtzz",jtzz);
           values.put("ssh",ssh);
           db.insert("information",null,values);
           Toast.makeText(this,"信息已添加",Toast.LENGTH_SHORT).show();
           db.close();
           break;

       case R.id.btn_main_query:                                                              //查询
           db=myHelper.getReadableDatabase();
           Cursor cursor;
           cursor = db.query("information",null,null,null,null,null,null);
           if (cursor.getCount()==0) {
               tv_main_display.setText("");
               Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
           }else{
               cursor.moveToFirst();
               tv_main_display.setText("姓名："+cursor.getString(1)+"  "+
                       "班级："+cursor.getString(2)+"  "+
                       "学号："+cursor.getString(3)+"  "+
                       "籍贯："+cursor.getString(4)+"  "+
                       "家庭住址："+cursor.getString(5)+"  "+
                       "宿舍号："+cursor.getString(6));
           }
            while (cursor.moveToNext()) {
                tv_main_display.append("姓名：" + cursor.getString(1) +"  "+
                        "班级：" + cursor.getString(2) +"  "+
                        "学号：" + cursor.getString(3) +"  "+
                        "籍贯：" + cursor.getString(4) +"  "+
                        "家庭住址：" + cursor.getString(5) +"  "+
                        "宿舍号：" + cursor.getString(6));
            }
               cursor.close();
           db.close();
           break;
       case R.id.btn_main_alter:                                                              //修改
           db=myHelper.getWritableDatabase();
           values=new ContentValues();
           values.put("bj",bj =tv_main_bj.getText().toString());
           db.update("information",values,"xm=?",
                   new String[]{tv_main_xm.getText().toString()});
           values.put("xh",xh =tv_main_xh.getText().toString());
           db.update("information",values,"xm=?",
                   new String[]{tv_main_xm.getText().toString()});
           values.put("bj",jg =tv_main_jg.getText().toString());
           db.update("information",values,"xm=?",
                   new String[]{tv_main_xm.getText().toString()});
           values.put("bj",jtzz =tv_main_jtzz.getText().toString());
           db.update("information",values,"xm=?",
                   new String[]{tv_main_xm.getText().toString()});
           values.put("bj",ssh =tv_main_ssh.getText().toString());
           db.update("information",values,"xm=?",
                   new String[]{tv_main_xm.getText().toString()});
           Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
           db.close();
           break;

       case R.id.btn_main_delete:                                                             //删除
           db=myHelper.getWritableDatabase();
           db.delete("information",null,null);
           Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
           tv_main_display.setText("");
           db.close();
           break;

    }
           }

}