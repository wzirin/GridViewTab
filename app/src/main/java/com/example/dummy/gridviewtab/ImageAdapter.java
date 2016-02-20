package com.example.dummy.gridviewtab;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private File f = null;
    private ArrayList<File> images = null;
    public ImageAdapter(Context c) {
        mContext = c;
        f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/Selfit");
        /*if(f.exists() && f.isDirectory()) {
            for(int i = 0; i < f.listFiles().length; i++) {
                System.err.println("" + f.listFiles()[i]);
            }System.err.println(f.getAbsolutePath());
            System.exit(0);
        }
        else {
            System.exit(-1);
        }*/
        images = new ArrayList<File>();
    }
    public int getCount() {
        /*File[] filesInSelfit = f.listFiles();
        for(int i = 0; i < filesInSelfit.length; i++) {
            if(filesInSelfit[i].isFile() && filesInSelfit[i].getName().endsWith(".jpg")) {
                images.add(filesInSelfit[i]);
            }
        }*/
        if(f.exists()) {
            String[] filesInSelfit = f.list();
            if(filesInSelfit != null) {
                for(int i = 0; i < filesInSelfit.length; i++) {
                    if(filesInSelfit[i].endsWith(".jpg")) {
                        images.add(new File(f.getAbsolutePath() + "/" + filesInSelfit[i]));
                    }
                }
            }
            else {
                System.err.println("list returning as null");
                System.err.println(f.getAbsolutePath());
                //images.add(new File(f.getAbsolutePath() + "/IMG_20160217_145507.jpg"));
            }
        }
        else {
            System.err.println("directory doesn't exist");
            System.exit(-1);
        }
        return images.size();
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageURI(Uri.fromFile(images.get(position)));
        //imageView.setImageBitmap(BitmapFactory.decodeFile(images.get(position).getAbsolutePath()));
        return imageView;
    }
    public long getItemId(int position) {
        return 0;
    }
    public Object getItem(int position) {
        return null;
    }
}