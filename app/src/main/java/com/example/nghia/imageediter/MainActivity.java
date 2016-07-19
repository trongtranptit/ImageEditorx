package com.example.nghia.imageediter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.nghia.CameraModul.CameraActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton img_cam, img_galery ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_cam = (ImageButton) findViewById(R.id.imb_cam);
        img_galery = (ImageButton) findViewById(R.id.imb_galery);

        ActionClickBut ac = new ActionClickBut() ;

        img_cam.setOnClickListener(ac);
        img_galery.setOnClickListener(ac);
    }

    class ActionClickBut implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imb_cam : {
                    Intent t = new Intent(getBaseContext(),CameraActivity.class) ;
                    startActivity(t);
                }
                case R.id.imb_galery : {

                }
            }
        }
    }
}
