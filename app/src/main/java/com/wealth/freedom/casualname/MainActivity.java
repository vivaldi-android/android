package com.wealth.freedom.casualname;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.wealth.freedom.cache.CacheUtils;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private CacheUtils cacheUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        cacheUtils = new CacheUtils(this, CacheUtils.CACHE_IMAGE);
        String url = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
        if (cacheUtils.getImageCache(url) == null) {
            cacheUtils.putImageCache(url, imageView);
            Log.e("eee", "eee");
        } else {
            Log.e("eee", "fff");
            imageView.setImageBitmap(cacheUtils.getImageCache(url));
        }

    }

    public void newWidget(View view) {
        startActivity(new Intent(this, NewWidgetActivity.class));
    }
}
