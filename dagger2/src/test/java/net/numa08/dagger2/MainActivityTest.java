package net.numa08.dagger2;

import net.numa08.dagger2.calendar.Today;
import net.numa08.dagger2.components.DaggerApplicationComponent;
import net.numa08.dagger2.modules.TodayModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class MainActivityTest {
    @Before
    public void initModule() {
        MainActivity.component = DaggerApplicationComponent.builder()
                .todayModule(new TodayModule() {
                    @Override
                    public Today providesToday() {
                        return new Today() {
                            @Override
                            public int getHour() {
                                return 12;
                            }
                        };
                    }
                }).build();
    }

    @Test
    public void showHour() throws Throwable {
        final MainActivity mainActivity = new MainActivity();
        mainActivity.onResume();
        final String hour = mainActivity.showHour();
        assertThat(hour, is("今は12時です"));
    }
}
