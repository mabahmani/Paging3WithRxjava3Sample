package ir.mab.pagingsample;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("passenger")
    Single<PassengerModel> getPassengers(@Query("page") String page, @Query("size") String size);
}
