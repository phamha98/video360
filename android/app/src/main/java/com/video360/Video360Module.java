package com.video360;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.vr.sdk.widgets.common.VrWidgetView;
import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.facebook.react.bridge.ReactMethod;

import java.io.IOException;


public class Video360Module extends SimpleViewManager {
    private static final String CLASS_NAME = "RCTVideo360";
    private static final String TAG = Video360Module.class.getSimpleName();
    private VrVideoView view;
    private View view2;
    private Uri uriCache;

    public Video360Module(ReactApplicationContext context) {
        super();
    }

    @Override
    public String getName() {
        return CLASS_NAME;
    }

    @Override
    protected View createViewInstance(ThemedReactContext context) {
        view = new VrVideoView(context.getCurrentActivity());
        view.setEventListener(new ActivityEventListener());
        // Log.d(TAG, "createViewInstance: test");

        //  view2 = View.inflate(context.getCurrentActivity(), R.layout.activity_video_player_360,null);

        return view;
    }

    @ReactProp(name = "displayMode")
    public void setDisplayMode(VrVideoView view, String mode) {
        switch (mode) {
            case "embedded":
                view.setDisplayMode(VrWidgetView.DisplayMode.EMBEDDED);
                break;
            case "fullscreen":
                view.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_MONO);
                break;
            case "cardboard":
                view.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_STEREO);
                break;
            default:
                view.setDisplayMode(VrWidgetView.DisplayMode.EMBEDDED);
                break;
        }
    }

    @ReactProp(name = "volume")
    public void setVolume(VrVideoView view, float value) {
        view.setVolume(value);
    }

    @ReactProp(name = "enableFullscreenButton")
    public void setFullscreenButtonEnabled(VrVideoView view, Boolean enabled) {
        view.setFullscreenButtonEnabled(enabled);
    }

    @ReactProp(name = "enableCardboardButton")
    public void setCardboardButtonEnabled(VrVideoView view, Boolean enabled) {
        view.setStereoModeButtonEnabled(enabled);
    }

    @ReactProp(name = "enableTouchTracking")
    public void setTouchTrackingEnabled(VrVideoView view, Boolean enabled) {
        view.setTouchTrackingEnabled(enabled);
    }

    @ReactProp(name = "hidesTransitionView")
    public void setTransitionViewEnabled(VrVideoView view, Boolean enabled) {
        view.setTransitionViewEnabled(!enabled);
    }

    @ReactProp(name = "enableInfoButton")
    public void setInfoButtonEnabled(VrVideoView view, Boolean enabled) {
        view.setInfoButtonEnabled(enabled);
    }

    @ReactProp(name = "urlVideo")
    public void setVideo(VrVideoView view, String url) {
        // String type = config.getString("type");
        //   Uri uri = Uri.parse(config.getString("uri"));

        Uri uri = Uri.parse(url);
        uriCache=Uri.parse(url);

        VrVideoView.Options videoOptions = new VrVideoView.Options();
        videoOptions.inputFormat = VrVideoView.Options.FORMAT_DEFAULT;
//
//        switch(type) {
//            case "mono":
//                videoOptions.inputType = VrVideoView.Options.TYPE_MONO;
//                break;
//            case "stereo":
//                videoOptions.inputType = VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
//                break;
//            default:
//                videoOptions.inputType = VrVideoView.Options.TYPE_MONO;
//                break;
//        }

        VideoLoaderTask videoLoaderTask = new VideoLoaderTask();
        videoLoaderTask.execute(Pair.create(uri, videoOptions));
    }

    private class ActivityEventListener extends VrVideoEventListener {
        @Override
        public void onLoadSuccess() {

            Log.i(TAG, "Successfully loaded video " + view.getDuration());
        }

        /**
         * Called by video widget on the UI thread on any asynchronous error.
         */
        @Override
        public void onLoadError(String errorMessage) {
            // An error here is normally due to being unable to decode the video format.
            Log.e(TAG, "Error loading video: " + errorMessage);
        }

        /**
         * Update the UI every frame.
         */
        @Override
        public void onNewFrame() {

        }

        /**
         * Make the video play in a loop. This method could also be used to move to the next video in
         * a playlist.
         */
        @Override
        public void onCompletion() {
            if (view != null) view.seekTo(0);
        }
    }
    @ReactMethod
    public void test( ) {
        Log.d("rtest", "test test ");
    }
    @ReactMethod
    public void loadVideo(final Promise promise) {
        try {
            Log.d(TAG, "myMethod called from JavaScript loadVideo");
            view.loadVideo(uriCache,null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("playVideo error", e.getMessage());
        }
    }

    @ReactMethod
    public void playVideo(final Promise promise) {
        try {
            view.playVideo();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("playVideo error", e.getMessage());
        }
    }

    @ReactMethod
    public void pauseVideo(final Promise promise) {
        try {
            view.pauseVideo();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("pauseVideo error", e.getMessage());
        }
    }

    @ReactMethod
    public void seekTo(long seek, final Promise promise) {
        try {
            view.seekTo(seek);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("seekTo error", e.getMessage());
        }
    }

    @ReactMethod
    public void getDuration(final Promise promise) {
        try {
            Long duration = view.getDuration();
            promise.resolve(duration);
        } catch (Exception e) {
            promise.reject("getDuration error", e.getMessage());
        }
    }

    @ReactMethod
    public void getCurrentPosition(final Promise promise) {
        try {
            Long duration = view.getCurrentPosition();
            promise.resolve(duration);
        } catch (Exception e) {
            promise.reject("getCurrentPosition error", e.getMessage());
        }
    }

    class VideoLoaderTask extends AsyncTask<Pair<Uri, VrVideoView.Options>, Void, Boolean> {
        @SafeVarargs
        @SuppressWarnings("WrongThread")
        protected final Boolean doInBackground(Pair<Uri, VrVideoView.Options>... args) {
            try {
                view.loadVideo(args[0].first, args[0].second);
            } catch (IOException e) {
            }

            return true;
        }
    }
}
//    @ReactMethod
//    public void playVideo(final Promise promise) {
//        try {
//            view.playVideo();
//            promise.resolve(true);
//        } catch (Exception e) {
//            promise.reject("PLAYBACK_ERROR", e.getMessage());
//        }
//    }