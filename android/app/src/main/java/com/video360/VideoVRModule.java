package com.video360;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


public class VideoVRModule extends SimpleViewManager <VideoVRView>{
    private static final String CLASS_NAME = "RCTVideoVR";
    private VideoVRView videoVRView;

    public VideoVRModule(ReactApplicationContext context) {
        super();
        Log.e("RCTVideoVR", "RCTVideoVR");
    }

    @Override
    public String getName() {
        return CLASS_NAME;
    }

    @Override
    protected VideoVRView createViewInstance(ThemedReactContext context) {
        Log.e("createViewInstance","createViewInstance");
        videoVRView = new VideoVRView(context.getCurrentActivity());
        return videoVRView;
    }

    @Override
    public void onDropViewInstance(VideoVRView view ) {
        super.onDropViewInstance(view);
        try {
            videoVRView.remove();
            Log.e("TAG", "VideoLoaderTask VideoLoaderTask VideoLoaderTask");
        } finally {

        }
        Log.e("VideoVRModule","onDropViewInstance");
    }

    @ReactProp(name = "urlVideo")
    public void setVideo(VideoVRView view,  String url ) {
      videoVRView.setVideo(url);
        Log.e("setVideo #001",url);
    }
    @ReactProp(name = "volume")
    public void setVolume(VideoVRView view, float value) {
        videoVRView.setVolume(value);
    }

    @ReactProp(name = "enableFullscreenButton")
    public void setFullscreenButtonEnabled(VideoVRView view, Boolean enabled) {
        videoVRView.setFullscreenButtonEnabled(enabled);
    }

    @ReactProp(name = "enableCardboardButton")
    public void setCardboardButtonEnabled(VideoVRView view, Boolean enabled) {
        videoVRView.setCardboardButtonEnabled(enabled);
    }

    @ReactProp(name = "enableTouchTracking")
    public void setTouchTrackingEnabled(VideoVRView view, Boolean enabled) {
        videoVRView.setTouchTrackingEnabled(enabled);
    }

    @ReactProp(name = "hidesTransitionView")
    public void setTransitionViewEnabled(VideoVRView view, Boolean enabled) {
        videoVRView.setTransitionViewEnabled(!enabled);
    }

    @ReactProp(name = "enableInfoButton")
    public void setInfoButtonEnabled(VideoVRView view, Boolean enabled) {
        videoVRView.setInfoButtonEnabled(enabled);
    }
    @ReactProp(name = "displayMode")
    public void setDisplayMode(VideoVRView view,String mode) {
        videoVRView.setDisplayMode(mode);
    }


}
