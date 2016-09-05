package edu.feicui.app.phone.base.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/8/18.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG,getClass().getSimpleName()+"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG,getClass().getSimpleName()+"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG,getClass().getSimpleName()+"onRause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG,getClass().getSimpleName()+"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG,getClass().getSimpleName()+"onDestroy");
    }
    protected void startActivity(Class<?> targetClass){
        Intent intent=new Intent(this,targetClass);
        startActivity(intent);
    }
}

