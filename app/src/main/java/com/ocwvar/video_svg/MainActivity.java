package com.ocwvar.video_svg;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import de.greenrobot.event.EventBus;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.VideoEvents;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    JCVideoPlayer videoController1, videoController2, videoController3;
    Button btnToList, btnToListViewpager, btnToFullscreen, btnToChangecolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 如果没有埋点需求，可以不用注册eventbus
         * <br>
         * if you do not want to get Buried Point , you do not need regist eventbus here
         */
        EventBus.getDefault().register(this);

        videoController1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        videoController1.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
                "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
                "简单代码实现视频播放");

        videoController2 = (JCVideoPlayer) findViewById(R.id.videocontroller2);
        videoController2.setUp("http://2449.vod.myqcloud.com/2449_ded7b566b37911e5942f0b208e48548d.f20.mp4",//
                "http://p.qpic.cn/videoyun/0/2449_ded7b566b37911e5942f0b208e48548d_2/640",
                "简单代码实现视频播放", false);

        videoController3 = (JCVideoPlayer) findViewById(R.id.videocontroller3);
        videoController3.setUp("http://121.40.64.47/resource/mp3/music_yangguang3.mp3",//
                "http://p.qpic.cn/videoyun/0/2449_38e65894d9e211e5b0e0a3699ca1d490_1/640",
                "简单代码实现视频播放");

        btnToList = (Button) findViewById(R.id.to_list_activity);
        btnToListViewpager = (Button) findViewById(R.id.to_list_viewpager_activity);
        btnToFullscreen = (Button) findViewById(R.id.to_fullscreen);
        btnToChangecolor = (Button) findViewById(R.id.to_changecolor_activity);

        btnToList.setOnClickListener(this);
        btnToListViewpager.setOnClickListener(this);
        btnToFullscreen.setOnClickListener(this);
        btnToChangecolor.setOnClickListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


    public void onEventMainThread(VideoEvents event) {
        if (event.type == VideoEvents.POINT_START_ICON) {
            Log.i("Video Event", "POINT_START_ICON" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_START_THUMB) {
            Log.i("Video Event", "POINT_START_THUMB" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_STOP) {
            Log.i("Video Event", "POINT_STOP" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_STOP_FULLSCREEN) {
            Log.i("Video Event", "POINT_STOP_FULLSCREEN" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_RESUME) {
            Log.i("Video Event", "POINT_RESUME" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_RESUME_FULLSCREEN) {
            Log.i("Video Event", "POINT_RESUME_FULLSCREEN" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_CLICK_BLANK) {
            Log.i("Video Event", "POINT_CLICK_BLANK" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_CLICK_BLANK_FULLSCREEN) {
            Log.i("Video Event", "POINT_CLICK_BLANK_FULLSCREEN" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_CLICK_SEEKBAR) {
            Log.i("Video Event", "POINT_CLICK_SEEKBAR" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_CLICK_SEEKBAR_FULLSCREEN) {
            Log.i("Video Event", "POINT_CLICK_SEEKBAR_FULLSCREEN" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_AUTO_COMPLETE) {
            Log.i("Video Event", "POINT_AUTO_COMPLETE" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_AUTO_COMPLETE_FULLSCREEN) {
            Log.i("Video Event", "POINT_AUTO_COMPLETE_FULLSCREEN" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_ENTER_FULLSCREEN) {
            Log.i("Video Event", "POINT_ENTER_FULLSCREEN" + " title is : " + event.obj + " url is : " + event.obj1);
        } else if (event.type == VideoEvents.POINT_QUIT_FULLSCREEN) {
            Log.i("Video Event", "POINT_QUIT_FULLSCREEN" + " title is : " + event.obj + " url is : " + event.obj1);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_list_activity:
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                break;
            case R.id.to_list_viewpager_activity:
                startActivity(new Intent(MainActivity.this, ListViewpagerActivity.class));
                break;
            case R.id.to_fullscreen://进入全屏播放
                JCVideoPlayer.toFullscreenActivity(this,
                        "http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
                        "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
                        "简单代码实现视频播放");
                break;
            case R.id.to_changecolor_activity:
                startActivity(new Intent(this, SetSkinActivity.class));
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
