package com.example.cilpdrawable;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class ClipDrawable extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        //获取图片所显示的ClipDrawable对象
        final android.graphics.drawable.ClipDrawable  drawable = 
        		(android.graphics.drawable.ClipDrawable) imageView.getDrawable(); 
        final Handler hander = new Handler()
        {

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if (msg.what == 0x1233) //如果该消息是本程序所发送的
				{
					drawable.setLevel(drawable.getLevel() + 200);
				}
			}
        	
        };
        
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Message msg = new Message();
				msg.what = 0x1233;
				hander.sendMessage(msg);  //发送消息，通知应用修改ClipDrawable对象的Level值
				if (drawable.getLevel() >= 10000)  //取消定时器
				{
					timer.cancel();
				}
				
			}
		}, 0, 300);
        
        
    }
}
