package com.mobile.example.wikieat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class foodImageAdapter extends BaseAdapter{

    private Context mContext;

    public foodImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 8, 5, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.onigiri, R.drawable.ramen,
            R.drawable.soba, R.drawable.sushi,
            R.drawable.tempura, R.drawable.yakitori,
            R.drawable.matcha, R.drawable.sakuratea,
            R.drawable.sake, R.drawable.uroncha,
            R.drawable.shochu, R.drawable.ramune,
    };
}
