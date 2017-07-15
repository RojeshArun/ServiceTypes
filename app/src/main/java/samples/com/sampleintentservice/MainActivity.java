package samples.com.sampleintentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void startService(View v) {
        intent = new Intent(this, MyService.class);
        startService(intent);

    }


    public void stopService(View v) {
        stopService(intent);
    }
}
