package app.mockhostelworld.com.mockhostelworld.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haitao on 02/02/2017.
 */

public class HttpMethods {

    String BASE_URL = "http://private-anon-685a2ab443-practical3.apiary-mock.com/";
    private PropertyService propertyListService;

    private HttpMethods() {

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        propertyListService = retrofit.create(PropertyService.class);
    }

    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public PropertyService getPropertyListService() {
        return propertyListService;
    }
}
