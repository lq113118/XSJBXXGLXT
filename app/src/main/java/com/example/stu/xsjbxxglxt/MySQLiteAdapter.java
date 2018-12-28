package com.example.stu.xsjbxxglxt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Xml;

import java.util.ArrayList;
import java.util.List;

//连接数据库
public class MySQLiteAdapter {
    private Context context;
    private String dBName;


    public MySQLiteAdapter(Context context, String dBName) {
        this.context = context;
        this.dBName = dBName;
    }
    private SQLiteDatabase db;
    private void openDatabase(){
        MyHelper myHelper=new MyHelper(context,dBName,null,1);
        db=myHelper.getWritableDatabase();
    }

    private void closeDatabase(){
        if(db.isOpen()){
            db.close();
        }
        db=null;
    }


    //对表进行四大操作
    // 添加
    public boolean insert(Infor infor){
        openDatabase();
        boolean result=false;
        String xm=infor.getxm();
        String bj=infor.getbj();
        String jg=infor.getjg();
        String jtzz=infor.getjtzz();
        String xh=infor.getxh();
        String ssh=infor.getssh();
        ContentValues values=new ContentValues();
        values.put("xm",xm);
        values.put("bj",bj);
        values.put("jg",jg);
        values.put("jtzz",jtzz);
        values.put("xh",xh);
        values.put("ssh",ssh);
        long rowId=db.insert("information",null,values);
        if (rowId!=-1){
            result=true;
        }
        closeDatabase();
        return result;
    }

    //修改

    //查询
    public List<Infor> query(){
        openDatabase();
        List<Infor> list=new ArrayList<>();
        Cursor cursor=db.query("information",null,null,null,null,null,null);
        int length=cursor.getCount();
        if(length>0) {
            cursor.moveToFirst();
            do {
                int id=cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("xm"));
                String bj = cursor.getString(cursor.getColumnIndex("bj"));
                String xh = cursor.getString(cursor.getColumnIndex("xh"));
                String jg = cursor.getString(cursor.getColumnIndex("jg"));
                String jtzz = cursor.getString(cursor.getColumnIndex("jtzz"));
                String ssh = cursor.getString(cursor.getColumnIndex("ssh"));
                Infor infor = new Infor();
                infor.set_id(id);

                infor.setbj(bj);
                infor.setxh(xh);
                infor.setjg(jg);
                infor.setjtzz(jtzz);
                infor.setssh(ssh);
                list.add(infor);

            } while (cursor.moveToNext());
        }
        closeDatabase();
        return  list;
    }



    //删除
    //数据处理
}


