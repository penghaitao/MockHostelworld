package app.mockhostelworld.com.mockhostelworld.PropertyDetail;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import app.mockhostelworld.com.mockhostelworld.R;
import app.mockhostelworld.com.mockhostelworld.data.Property;
import app.mockhostelworld.com.mockhostelworld.http.HttpMethods;
import app.mockhostelworld.com.mockhostelworld.tool.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyDetailActivity extends AppCompatActivity {

    @BindView(R.id.property_name)
    TextView propertyNameView;
    @BindView(R.id.property_address)
    TextView propertyAddressView;
    @BindView(R.id.property_county)
    TextView propertyCountyView;
    @BindView(R.id.property_direction)
    TextView propertyDirectionView;
    @BindView(R.id.divider1)
    View dividerView1;
    @BindView(R.id.divider2)
    View dividerView2;
    @BindView(R.id.image_pager)
    ViewPager imageViewPager;
    @BindView(R.id.expand_text_view)
    ExpandableTextView expandableTextView;
    String propertyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_detail);
        ButterKnife.bind(this);
        propertyId = getIntent().getStringExtra(Constants.PROPERTY_ID);
        getProperty();
    }

    private void getProperty() {
        Call<Property> call = HttpMethods.getInstance().getPropertyListService().getProperty(propertyId);
        call.enqueue(new Callback<Property>() {
            @Override
            public void onResponse(Call<Property> call, Response<Property> response) {
                Property property = response.body();
                propertyNameView.setText(property.getName());
                propertyAddressView.setText(property.getAddress());
                propertyCountyView.setText(property.getCity().getCountry());
                expandableTextView.setText(property.getDescription());
                propertyDirectionView.setText(property.getDirections());
                initImagePager(property);
                dividerView1.setVisibility(View.VISIBLE);
                dividerView2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<Property> call, Throwable t) {
                Toast.makeText(PropertyDetailActivity.this, "f", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initImagePager(Property property) {
        int imageNumber = property.getImages().size();
        String[] imageUrls = new String[imageNumber];
        for (int i=0; i<imageNumber; i++) {
            Property.Image image = property.getImages().get(i);
            String imageUrl = image.getPrefix() + image.getSuffix();
            imageUrls[i] = imageUrl;
            ImageViewPagerAdapter imageViewPagerAdapter = new ImageViewPagerAdapter(PropertyDetailActivity.this, imageUrls);
            imageViewPager.setAdapter(imageViewPagerAdapter);
        }
    }
}
