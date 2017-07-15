package samples.com.sampleboundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mLblMessage;

    MyService myService;
    boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLblMessage = (TextView) findViewById(R.id.lbl_message);

        Intent intent = new Intent(this,MyService.class);
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);


    }

    public void getFirstMsg(View v) {
        mLblMessage.setText(myService.getMessage());

    }

    public void getSecondMsg(View v) {
        mLblMessage.setText(myService.getSecondMessage());
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.LocalService localService = (MyService.LocalService) iBinder;
            myService = localService.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


    @Override
    protected void onStop() {
        super.onStop();
        if(isBind) {
            unbindService(mServiceConnection);
            myService = null;
            isBind = false;
        }
    }
}
