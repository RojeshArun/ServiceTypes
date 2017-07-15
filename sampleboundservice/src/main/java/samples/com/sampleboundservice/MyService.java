package samples.com.sampleboundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by rojesharunkumar on 15/07/17.
 */

public class MyService extends Service{

    private final IBinder mBinder = new LocalService();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalService extends Binder{
        MyService getService(){
            return MyService.this;
        }

    }

    public String getMessage(){
        return "This message from service whatzup?";
    }

    public String getSecondMessage(){
        return  "Thi is bound service another user method";
    }



}
