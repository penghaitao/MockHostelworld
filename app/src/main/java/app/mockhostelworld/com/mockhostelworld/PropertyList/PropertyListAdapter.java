package app.mockhostelworld.com.mockhostelworld.PropertyList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.mockhostelworld.com.mockhostelworld.R;
import app.mockhostelworld.com.mockhostelworld.data.Property;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by haitao on 02/02/2017.
 */

public class PropertyListAdapter extends RecyclerView.Adapter<PropertyListAdapter.ViewHolder> {

    private List<Property> mProperties;
    private Context mContext;
    private static IClickItem mIClickItem;

    public PropertyListAdapter(Context context, List<Property> properties) {
        this.mContext = context;
        this.mProperties = properties;
    }

    @Override
    public PropertyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View propertyView = inflater.inflate(R.layout.property_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(propertyView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PropertyListAdapter.ViewHolder holder, int position) {
        Property property = mProperties.get(position);
        holder.propertyNameView.setText(property.getName());
        holder.propertyTypeView.setText(property.getType());
        holder.propertyPriceView.setText("price per night");
        if (null == property.getOverallRating().getOverall()) {
            holder.propertyRatingView.setVisibility(View.INVISIBLE);
        } else {
            holder.propertyRatingView.setVisibility(View.VISIBLE);
            holder.propertyRatingView.setText(property.getOverallRating().getOverall());
        }
        if (property.getImages().size()>0) {
            Property.Image image = property.getImages().get(0);
            String imageUrl = image.getPrefix() + image.getSuffix();
            Glide.with(mContext).load(imageUrl).centerCrop().into(holder.propertyThumbnailView);
        }
    }

    public void setIClickItem(IClickItem IClickItem) {
        mIClickItem = IClickItem;
    }

    public interface IClickItem {

        void onClickItem(Property property);
    }

    @Override
    public int getItemCount() {
        return mProperties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.property_name)
        TextView propertyNameView;
        @BindView(R.id.property_type)
        TextView propertyTypeView;
        @BindView(R.id.property_price)
        TextView propertyPriceView;
        @BindView(R.id.property_thumbnail)
        ImageView propertyThumbnailView;
        @BindView(R.id.property_rating)
        TextView propertyRatingView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIClickItem.onClickItem(mProperties.get(getAdapterPosition()));
                }
            });
        }
    }
}
