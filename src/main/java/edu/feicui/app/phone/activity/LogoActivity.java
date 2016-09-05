package edu.feicui.app.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LogoActivity extends AppCompatActivity {
    //1.得到ImageView
    //2.动画
    private ImageView imageView;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        //初始化
        imageView= (ImageView) findViewById(R.id.imageView);
        //得到动画
        animation= AnimationUtils.loadAnimation(this, R.anim.anim_logo);
        //添加监听器
        Animation.AnimationListener animationListener=new Animation.AnimationListener() {
            //开始动画
            @Override
            public void onAnimationStart(Animation animation) {
                //不需要写代码
            }
            //结束动画
            @Override
            public void onAnimationEnd(Animation animation) {
                //跳转
                Intent intent=new Intent(LogoActivity.this,TelmsgActivity.class);
                startActivity(intent);
                //关闭
                finish();
            }
            //重复动画
            @Override
            public void onAnimationRepeat(Animation animation) {
                //不需要写代码
            }
        };
        //添加监听
        animation.setAnimationListener(animationListener);
        //添加动画
        imageView.setAnimation(animation);
    }
}