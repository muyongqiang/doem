package edu.feicui.app.phone.base.db;

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/12.
 */
public class AssetsDBManager {
    /**
     * @param  context
     * @param  name  数据库的名字
     * @param  toFile  文件的完整路径+名字
     */
    public static void copyAssetsFileToFile(Context context, String name, File toFile){
        InputStream in=null;
        BufferedInputStream read=null;
        BufferedOutputStream write=null;
        try {
            in=context.getAssets().open(name);
            read=new BufferedInputStream(in);
            write=new BufferedOutputStream(new FileOutputStream(toFile, false));
            byte[] b=new byte[1024*2];
            //int len=read.read(b,0,b.length);
            int len=0;
            while (-1!=(len=read.read(b,0,b.length))){
                //输出流
                write.write(b,0,len);
            }
            write.flush();

        }catch (Exception e){
            Log.d("出错那","出错");
        }finally {
            try {
                in.close();
                read.close();
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
