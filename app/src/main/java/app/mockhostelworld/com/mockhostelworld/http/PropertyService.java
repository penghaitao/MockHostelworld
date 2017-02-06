package app.mockhostelworld.com.mockhostelworld.http;

import app.mockhostelworld.com.mockhostelworld.data.Properties;
import app.mockhostelworld.com.mockhostelworld.data.Property;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by haitao on 02/02/2017.
 */

public interface PropertyService {
    @GET("cities/{city_id}/properties/")
    public Call<Properties> getProperties(@Path("city_id") String cityId);

    @GET("properties/{property_id}")
    public Call<Property> getProperty(@Path("property_id") String propertyId);
}
