package com.video360;

import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;

import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.vr.sdk.widgets.video.VrVideoView;

import java.util.Map;

import javax.annotation.Nullable;


public class VideoVRModule extends SimpleViewManager <VideoVRView>{
    private static final String CLASS_NAME = "RCTVideoVR";
    private View view2;
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
        view2 = new View(context.getCurrentActivity());
        videoVRView = new VideoVRView(context.getCurrentActivity());
//        int width = 200; // Specify your desired width
//        int height = 150; // Specify your desired height
//        view2.setLayoutParams(new ViewGroup.LayoutParams(width, height));
//
//        // Set background color for view2
//        view2.setBackgroundColor(Color.BLUE);
        return videoVRView;
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
