package net.numa08.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.numa08.dagger2.calendar.Today;
import net.numa08.dagger2.calendar.internal.TodayImpl;

public class MainActivity extends AppCompatActivity {

    Today today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        today = new TodayImpl();
        Log.d("Android_Test_BC", showHour());
    }

    String showHour() {
        return "今は" + today.getHour() +"時です";
    }
}
