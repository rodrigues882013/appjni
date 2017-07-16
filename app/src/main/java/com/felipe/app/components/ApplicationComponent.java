package com.felipe.app.components;

import android.content.Context;

import com.felipe.app.FruitsActivity;
import com.felipe.app.adapters.FruitAdapter;
import com.felipe.app.adapters.FruitViewHolder;
import com.felipe.app.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by felipe on 7/15/17.
 */

@Singleton
@Component( modules = { ApplicationModule.class })
public interface ApplicationComponent {
    void inject(FruitsActivity activity);
}
