package com.video360;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.vr.sdk.widgets.common.VrWidgetView;
import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;

import java.io.IOException;

public class VideoVRView extends FrameLayout {
    private static final String TAG = "VideoVRView";
    private Long lastDuration;
    protected VrVideoView videoWidgetView;
    private TextView textView;
    private TextView textDuration;
    private ImageButton playToggle;
    private Boolean isPaused = false;
    private Boolean isError = false;
    private SeekBar seekBar;
    private Uri uriVideo;

    public VideoVRView(@NonNull Context context) {
        super(context);
        View layoutInflater = inflate(context, R.layout.activity_videovr, this);
        textView = layoutInflater.findViewById(R.id.txt_current);
        textDuration = layoutInflater.findViewById(R.id.txt_duration);
        //
        videoWidgetView = findViewById(R.id.video_view);
        //videoWidgetView.setEventListener(new ActivityEventListener());
        playToggle = findViewById(R.id.play_toggle);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        playToggle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePause();

            }
        });
        videoWidgetView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("VIEW", "videoWidgetView.setOnTouchListener");
                return false;
            }
        });
    }

    private void togglePause() {
        try {


            Log.e(TAG, "togglePause123");
            Log.e(TAG, "lastDuration=" + lastDuration);
            Log.e(TAG, "isError=" + isError);
            if (isPaused) {
                Log.e(TAG, "playVideo");
                videoWidgetView.playVideo();
                if (isError) {

                } else {

                }

            } else {
                Log.e(TAG, "pauseVideo");
                videoWidgetView.pauseVideo();
            }
            isPaused = !isPaused;
            playToggle.setImageResource(isPaused ? R.drawable.play : R.drawable.pause);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception
            Log.e(TAG, "19008198",e);
        }
    }


    public void remove() {
        videoWidgetView.pauseVideo();
        videoWidgetView.setEventListener(null);
        seekBar.setProgress(0);
    }

    private void reloadVideo() {
        try {
            videoWidgetView.setEventListener(null);
            videoWidgetView.setEventListener(new ActivityEventListener());
            Log.d(TAG, "reloadVideo");

            VrVideoView.Options videoOptions = new VrVideoView.Options();
            videoOptions.inputFormat = VrVideoView.Options.FORMAT_DEFAULT;

            videoWidgetView.loadVideo(uriVideo, videoOptions);
            videoWidgetView.seekTo(lastDuration);
            videoWidgetView.pauseVideo();

        } catch (IOException e) {
            Log.e(TAG, "VideoLoaderTask VideoLoaderTask VideoLoaderTask");
        }

    }

    public void setVideo(String url) {

        uriVideo = Uri.parse(url);
        VrVideoView.Options videoOptions = new VrVideoView.Options();
        videoOptions.inputFormat = VrVideoView.Options.FORMAT_DEFAULT;

        VideoLoaderTask videoLoaderTask = new VideoLoaderTask();
        videoLoaderTask.execute(Pair.create(uriVideo, videoOptions));

    }

    public void setVolume(float value) {
        videoWidgetView.setVolume(value);
    }

    public void setFullscreenButtonEnabled(Boolean enabled) {
        videoWidgetView.setFullscreenButtonEnabled(enabled);
    }

    public void setCardboardButtonEnabled(Boolean enabled) {
        videoWidgetView.setStereoModeButtonEnabled(enabled);
    }

    public void setTouchTrackingEnabled(Boolean enabled) {
        videoWidgetView.setTouchTrackingEnabled(enabled);
    }

    public void setTransitionViewEnabled(Boolean enabled) {
        videoWidgetView.setTransitionViewEnabled(!enabled);
    }

    public void setInfoButtonEnabled(Boolean enabled) {
        videoWidgetView.setInfoButtonEnabled(enabled);
    }

    public void setDisplayMode(String mode) {
        switch (mode) {
            case "embedded":
                videoWidgetView.setDisplayMode(VrWidgetView.DisplayMode.EMBEDDED);
                break;
            case "fullscreen":
                videoWidgetView.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_MONO);
                break;
            case "cardboard":
                videoWidgetView.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_STEREO);
                break;
            default:
                videoWidgetView.setDisplayMode(VrWidgetView.DisplayMode.EMBEDDED);
                break;
        }
        videoWidgetView.setTransitionViewEnabled(false);
    }

    class VideoLoaderTask extends AsyncTask<Pair<Uri, VrVideoView.Options>, Void, Boolean> {
        @SafeVarargs
        @SuppressWarnings("WrongThread")
        protected final Boolean doInBackground(Pair<Uri, VrVideoView.Options>... args) {
            try {
                videoWidgetView.loadVideo(args[0].first, args[0].second);
            } catch (IOException e) {
                Log.e(TAG, "VideoLoaderTask VideoLoaderTask VideoLoaderTask");
            }
            return true;
        }
    }

    private class ActivityEventListener extends VrVideoEventListener {
        /**
         * Called by video widget on the UI thread when it's done loading the video.
         */
        @Override
        public void onLoadSuccess() {
            Log.i(TAG, "Successfully loaded video " + videoWidgetView.getDuration());
            seekBar.setMax((int) videoWidgetView.getDuration());
            textDuration.setText(getTimeString(videoWidgetView.getDuration()));
        }

        /**
         * Called by video widget on the UI thread on any asynchronous error.
         */
        @Override
        public void onLoadError(String errorMessage) {
            Toast.makeText(getContext(), "Error al cargar el video: " + errorMessage, Toast.LENGTH_LONG).show();
            Log.e(TAG, "Error al cargar el video: " + errorMessage);
            isError = true;
            reloadVideo();
        }

        @Override
        public void onClick() {
        }

        @Override
        public void onNewFrame() {
            String i = String.valueOf((videoWidgetView.getCurrentPosition()));
            textView.setText(getTimeString(videoWidgetView.getCurrentPosition()));
            seekBar.setProgress((int) videoWidgetView.getCurrentPosition());
            lastDuration = videoWidgetView.getCurrentPosition();
        }


        @Override
        public void onCompletion() {
            videoWidgetView.seekTo(0);
        }
    }

    private String getTimeString(long millis) {
        StringBuffer buf = new StringBuffer();

        int hours = (int) (millis / (1000 * 60 * 60));
        int minutes = (int) ((millis % (1000 * 60 * 60)) / (1000 * 60));
        int seconds = (int) (((millis % (1000 * 60 * 60)) % (1000 * 60)) / 1000);

        if (hours > 0) {
            buf.append(String.format("%02d", hours)).append(":");
        }

        // Display mm:ss format when the duration is less than 1 hour
        buf.append(String.format("%02d", minutes)).append(":").append(String.format("%02d", seconds));

        return buf.toString();
    }


}
