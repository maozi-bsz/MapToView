package com.bsz.hanyue.maptoview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bsz.hanyue.maptoview.View.HImageView;
import com.github.snowdream.android.app.downloader.DownloadListener;
import com.github.snowdream.android.app.downloader.DownloadManager;
import com.github.snowdream.android.app.downloader.DownloadTask;
import com.github.snowdream.android.app.downloader.DownloadType;


public class MainActivity extends Activity {

    private HImageView imageView;
    private ImageView imageView2;
    private DownloadManager downloadManager = new DownloadManager(this);
    private DownloadTask task = new DownloadTask(this);
    private DownloadListener listener = new DownloadListener<Integer,DownloadTask>(){
        @Override
        public void onAdd(DownloadTask downloadTask) {
            super.onAdd(downloadTask);
        }

        @Override
        public void onDelete(DownloadTask downloadTask) {
            super.onDelete(downloadTask);
        }

        @Override
        public void onStop(DownloadTask downloadTask) {
            super.onStop(downloadTask);
        }

        @Override
        public void onCancelled() {
            super.onCancelled();
        }

        @Override
        public void onError(Throwable thr) {
            super.onError(thr);
        }

        @Override
        public void onFinish() {
            super.onFinish();
        }

        @Override
        public void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        public void onStart() {
            super.onStart();
        }

        @Override
        public void onSuccess(DownloadTask downloadTask) {
            super.onSuccess(downloadTask);
            Toast.makeText(MainActivity.this,downloadTask.getPath(),Toast.LENGTH_SHORT).show();
            imageView2.setImageURI(Uri.parse(downloadTask.getPath()));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (HImageView)findViewById(R.id.view);
        imageView2 = (ImageView)findViewById(R.id.imageView);

        task.setUrl("http://zhoumo-image2.oss-cn-qingdao.aliyuncs.com/20150605130046_478.jpg");
        task.setName("sdfs");
        task.setType(DownloadType.TYPE_IMAGE);
        downloadManager.add(task, listener);
        downloadManager.start(task,listener);
    }

}
