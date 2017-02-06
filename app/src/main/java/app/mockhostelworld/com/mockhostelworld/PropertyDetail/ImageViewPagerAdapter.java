package app.mockhostelworld.com.mockhostelworld.PropertyDetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import app.mockhostelworld.com.mockhostelworld.R;

/**
 * Created by haitao on 05/02/2017.
 */

public class ImageViewPagerAdapter extends PagerAdapter {

    Context mContext;
    String[] mImageUrls;

    public ImageViewPagerAdapter(Context context, String[] imageUrls) {
        mContext = context;
        mImageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return mImageUrls.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((FrameLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        TextView indicatorView = (TextView) itemView.findViewById(R.id.indicator);
        Glide.with(mContext).load(mImageUrls[position]).centerCrop().into(imageView);
        indicatorView.setText((position+1)+"/"+mImageUrls.length);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }

}
