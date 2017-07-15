package samples.com.sampleintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by rojesharunkumar on 15/07/17.
 */

public class MyService extends IntentService {


    // Provides default implementation for onBind and onStart
    // Intent service will automatically call stopSelf() once job is finished
    // In service we have to call stopSelf() to kill the jonb
    public MyService() {
        super("My_child_thread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        synchronized (this){
            int count = 0;
            while (count < 10){
                try {
                    wait(1500);
                    count++;


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this,"Intent Service started",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service stopped",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
