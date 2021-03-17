package ir.mab.pagingsample;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceInstance {
    private static ApiService apiService;

    public static ApiService get(){
        if (apiService == null){
            return new Retrofit.Builder().baseUrl("https://api.instantwebtools.net/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
                    .create(ApiService.class);
        }

        return apiService;
    }
}
