
package com.lansosdk.videoeditor.player;


import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;


public interface IRenderView {
    static final int AR_ASPECT_FIT_PARENT = 0; // without clip
    static final int AR_ASPECT_FILL_PARENT = 1; // may clip 平铺在屏幕上, 可能会有裁剪掉一些画面.
    static final int AR_ASPECT_WRAP_CONTENT = 2;
    static final int AR_MATCH_PARENT = 3;
    static final int AR_16_9_FIT_PARENT = 4;
    static final int AR_4_3_FIT_PARENT = 5;

    View getView();

    boolean shouldWaitForResize();

    void setVideoSize(int videoWidth, int videoHeight);

    void setVideoSampleAspectRatio(int videoSarNum, int videoSarDen);

    void setVideoRotation(int degree);

    void setAspectRatio(int aspectRatio);

//    void addRenderCallback(@NonNull IRenderCallback callback);
//
//    void removeRenderCallback(@NonNull IRenderCallback callback);

    interface ISurfaceHolder {
        void bindToMediaPlayer(IMediaPlayer mp);

        @NonNull
        IRenderView getRenderView();

        @Nullable
        SurfaceHolder getSurfaceHolder();

        @Nullable
        Surface openSurface();

        @Nullable
        SurfaceTexture getSurfaceTexture();
    }

    
//    //这个RenderCallback其实就是对 TextureView 的再次封装, 用mRenderCallbackMap管理多个callback, 因为TextureView.SurfaceTextureListener 只是setCallback.
//      //这里是addCallback.如果有多个增加进来,则TextureView的callback一次,则所有设置过来的callback都相应.
//    public interface IRenderCallback {
//        /**
//         * @param holder
//         * @param width  could be 0
//         * @param height could be 0
//         */
//        void onSurfaceCreated(@NonNull ISurfaceHolder holder, int width, int height);
//
//        /**
//         * @param holder
//         * @param format could be 0
//         * @param width
//         * @param height
//         */
//        void onSurfaceChanged(@NonNull ISurfaceHolder holder, int format, int width, int height);
//
//        void onSurfaceDestroyed(@NonNull ISurfaceHolder holder);
//    }
}