package app.mockhostelworld.com.mockhostelworld.PropertyList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import app.mockhostelworld.com.mockhostelworld.PropertyDetail.PropertyDetailActivity;
import app.mockhostelworld.com.mockhostelworld.R;
import app.mockhostelworld.com.mockhostelworld.data.Properties;
import app.mockhostelworld.com.mockhostelworld.data.Property;
import app.mockhostelworld.com.mockhostelworld.http.HttpMethods;
import app.mockhostelworld.com.mockhostelworld.tool.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyListActivity extends AppCompatActivity implements PropertyListAdapter.IClickItem {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private PropertyListAdapter propertyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_list);
        ButterKnife.bind(this);
        getProperties();
    }

    private void getProperties() {

        Call<Properties> call = HttpMethods.getInstance().getPropertyListService().getProperties("1530");
        call.enqueue(new Callback<Properties>() {
            @Override
            public void onResponse(Call<Properties> call, Response<Properties> response) {
                Properties properties = response.body();
                propertyListAdapter = new PropertyListAdapter(PropertyListActivity.this, properties.getProperties());
                propertyListAdapter.setIClickItem(PropertyListActivity.this);
                recyclerView.setAdapter(propertyListAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(PropertyListActivity.this));
            }

            @Override
            public void onFailure(Call<Properties> call, Throwable t) {
                Toast.makeText(PropertyListActivity.this, R.string.network_error, Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onClickItem(Property property) {
        Intent intent = new Intent();
        String propertyId = property.getId();
        intent.setClass(this, PropertyDetailActivity.class);
        intent.putExtra(Constants.PROPERTY_ID, propertyId);
        startActivity(intent);
    }
}
