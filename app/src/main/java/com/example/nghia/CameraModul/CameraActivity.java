package com.example.nghia.cameramodul;

import android.app.Activity;
import android.os.Bundle;

import com.example.nghia.imageediter.R;


public class CameraActivity extends Activity {
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
    }
}
