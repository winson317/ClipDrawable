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
        //��ȡͼƬ����ʾ��ClipDrawable����
        final android.graphics.drawable.ClipDrawable  drawable = 
        		(android.graphics.drawable.ClipDrawable) imageView.getDrawable(); 
        final Handler hander = new Handler()
        {

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if (msg.what == 0x1233) //�������Ϣ�Ǳ����������͵�
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
				hander.sendMessage(msg);  //������Ϣ��֪ͨӦ���޸�ClipDrawable�����Levelֵ
				if (drawable.getLevel() >= 10000)  //ȡ����ʱ��
				{
					timer.cancel();
				}
				
			}
		}, 0, 300);
        
        
    }
}
