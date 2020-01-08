package com.beatrice.bookfinder.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.beatrice.bookfinder.Model.BookSearchResponse;
import com.beatrice.bookfinder.Rest.ApiClient;
import com.beatrice.bookfinder.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookSearchRepository {

    ApiInterface apiService;
    public BookSearchRepository() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    /**
     *
     * @param queryString - name of a book or the author being searched
     * @param apiKey
     * @return
     */
    public LiveData<BookSearchResponse> getBooks(String queryString, String apiKey){
        final MutableLiveData<BookSearchResponse> bookSearchResponses = new MutableLiveData<>();
        Call<BookSearchResponse> call = apiService.getBooks(queryString, apiKey);
        call.enqueue(new Callback<BookSearchResponse>() {
            @Override
            public void onResponse(Call<BookSearchResponse> call, Response<BookSearchResponse> response) {
                if (response.isSuccessful()){
                    bookSearchResponses.setValue(response.body());
                }{

                }
            }

            @Override
            public void onFailure(Call<BookSearchResponse> call, Throwable t) {

            }
        });
        return bookSearchResponses;
    }
}
