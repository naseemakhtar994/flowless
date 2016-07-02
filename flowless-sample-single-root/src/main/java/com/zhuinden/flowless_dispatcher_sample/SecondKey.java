package com.zhuinden.flowless_dispatcher_sample;

import com.google.auto.value.AutoValue;

import flowless.preset.FlowAnimation;
import flowless.preset.LayoutPath;

/**
 * Created by Zhuinden on 2016.06.28..
 */
@AutoValue
public abstract class SecondKey
        implements LayoutPath {
    public static SecondKey create() {
        return new AutoValue_SecondKey(R.layout.path_second, FlowAnimation.SEGUE);
    }
}
