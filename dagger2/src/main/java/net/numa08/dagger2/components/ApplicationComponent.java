package net.numa08.dagger2.components;

import net.numa08.dagger2.MainActivity;
import net.numa08.dagger2.modules.TodayModule;

import dagger.Component;

@Component(modules = TodayModule.class)
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
