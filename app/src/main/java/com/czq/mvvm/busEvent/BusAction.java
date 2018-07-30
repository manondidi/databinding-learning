package com.czq.mvvm.busEvent;

public class BusAction {
    public static class HideCommentRecyclerViewEvent {
        public float startPositionX = 0.0F;

        public HideCommentRecyclerViewEvent() {
        }

        public HideCommentRecyclerViewEvent(float paramFloat) {
            this.startPositionX = paramFloat;
        }
    }

    public static class GameDetailStatusClickEvent {
    }
}