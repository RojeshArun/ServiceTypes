package samples.com.sampleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by rojesharunkumar on 15/07/17.
 */

public class MyService extends Service{
// Started Service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Started Service started",Toast.LENGTH_SHORT).show();

        // Download
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this," Service Destroyed",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}



/*
    //called  If servic is Started Service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Started Service started",Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    // Called if the service is on Bind service
    // If started service return null
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this,"Destoryed",Toast.LENGTH_SHORT).show();
    }*/