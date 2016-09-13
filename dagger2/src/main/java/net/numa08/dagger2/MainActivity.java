package net.numa08.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.numa08.dagger2.calendar.Today;
import net.numa08.dagger2.components.ApplicationComponent;
import net.numa08.dagger2.components.DaggerApplicationComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    static ApplicationComponent component = DaggerApplicationComponent.create();

    @Inject
    Today today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Robolectric を利用しないために無理やりやってます orz
    @Override
    protected void onResume() {
        component.inject(this);
        System.out.println(showHour());
    }

    String showHour() {
        return "今は" + today.getHour() +"時です";
    }
}
