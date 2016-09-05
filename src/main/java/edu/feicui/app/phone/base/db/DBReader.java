package edu.feicui.app.phone.base.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

import edu.feicui.app.phone.entity.TelclassInfo;
import edu.feicui.app.phone.entity.TelnumberInfo;


/**
 * Created by Administrator on 2016/8/12.
 */
public class DBReader {
    public static File toFile;
    static {
        String str="data/";
        str+= Environment.getDataDirectory().getAbsolutePath();
        str+="/edu.feicui.app.phone.activity/";
        File file=new File(str);
        file.mkdirs();

        str+= "commonnum.db";
        toFile=new File(str);
    }
    public static boolean isExistsTeldbFile(){
        File file=DBReader.toFile;
        if (!file.exists()||file.length()<=0){
            return false;
        }
        return true;
    }
    public static ArrayList<TelclassInfo> readTeldClasslist() {
        ArrayList<TelclassInfo> list=new ArrayList<TelclassInfo>();
        SQLiteDatabase db=null;
        Cursor cursor=null;
        try {
            db=SQLiteDatabase.openOrCreateDatabase(toFile,null);
            cursor=db.rawQuery("select * from classlist;",null);
            if(cursor.moveToFirst()){
                do {
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    int idx=cursor.getInt(cursor.getColumnIndex("idx"));
                    TelclassInfo info=new TelclassInfo(name,idx);
                    list.add(info);
                }while (cursor.moveToNext());

            }

        } catch (Exception e) {
        }finally {
            cursor.close();
            db.close();
        }
        return list;
    }
    public static ArrayList<TelnumberInfo> readTeldbTable(int idx){
        ArrayList<TelnumberInfo> list=new ArrayList<TelnumberInfo>();
        SQLiteDatabase db=null;
        Cursor cursor=null;
        String s1="select * from table"+idx;
        try {
            db=SQLiteDatabase.openOrCreateDatabase(DBReader.toFile,null);
           cursor=db.rawQuery(s1,null);
            //读数据，定位光标到第一行
            if (cursor.moveToFirst()){
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String number = cursor.getString(cursor.getColumnIndex("number"));
                    TelnumberInfo info = new TelnumberInfo(name, number);
                    list.add(info);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
            db.close();
        }
        return list;
    }

}
