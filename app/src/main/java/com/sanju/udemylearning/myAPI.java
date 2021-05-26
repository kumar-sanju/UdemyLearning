package com.sanju.udemylearning;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myAPI {

    @GET("posts")
    Call<List<RetrofitModel>> getModels();

}
