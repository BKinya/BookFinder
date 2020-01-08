package com.beatrice.bookfinder.Rest;

import com.beatrice.bookfinder.Model.BookSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET
    Call<BookSearchResponse> getBooks(
            @Query("q") String queryString,
            @Query("key") String apiKey,
            @Query("orderby") String orderBy
    );
}
