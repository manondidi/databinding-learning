package com.czq.mvvm.util;

public class MotionMoveUtil {
    float oldY = 0;

    public float caculateMoveDistance(float y) {

        float disctance = y - oldY;
        if (oldY == 0) {
            disctance = 0;
        }
        oldY = y;
        return disctance;
    }
}
