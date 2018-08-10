package com.kotlin.datearound.indicator.animation.data.type;

import com.kotlin.datearound.indicator.animation.data.Value;

public class SlideAnimationValue implements Value {

    private int coordinate;

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }
}
