package net.numa08.dagger2.modules;

import net.numa08.dagger2.calendar.Today;
import net.numa08.dagger2.calendar.internal.TodayImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class TodayModule {
    @Provides
    public Today providesToday() {
        return new TodayImpl();
    }
}
