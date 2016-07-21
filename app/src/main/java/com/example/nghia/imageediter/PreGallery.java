package com.example.nghia.imageediter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Syl on 7/21/2016.
 */
public class PreGallery extends AppCompatActivity {
    GridView gv;
    ArrayList<File> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_gallery);

        arrayList = imageReader(Environment.getExternalStorageDirectory());
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        DisplayImageOptions displayImageOptions=new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration imageLoaderConfiguration =
                new ImageLoaderConfiguration.Builder(getApplicationContext())
                        .defaultDisplayImageOptions(displayImageOptions)
                        .build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);


        gv = (GridView) findViewById(R.id.list);
        gv.setAdapter(new GripAdapter());
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent t = new Intent(getApplicationContext(),GalleryActivity.class);
                t.putExtra("img",arrayList.get(position)+"");
                startActivity(t);
            }
        });
    }
    class GripAdapter extends BaseAdapter {
        GripAdapter(){

        }
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView =getLayoutInflater().inflate(R.layout.item,parent,false);
            ImageView iv = (ImageView) convertView.findViewById(R.id.imageSingle);
            ImageLoader.getInstance().displayImage("file://"+getItem(position),iv);
            return convertView;
        }
    }
    ArrayList<File> imageReader (File root){
        ArrayList<File> a = new ArrayList<>();
        File[] files =root.listFiles();
        for( int i=0;i<files.length;i++){
            // kiem tra la duong dan file hay forder
            if(files[i].isDirectory()){
                a.addAll( ( imageReader ( files[i] ) ) );
            }
            else{
                if(files[i].getName().endsWith(".jpg")||files[i].getName().endsWith(".png")){
                    a.add(files[i]);
                }
            }
        }
        return a;
    };
}
