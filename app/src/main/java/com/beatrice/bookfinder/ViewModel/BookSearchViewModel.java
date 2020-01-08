package com.beatrice.bookfinder.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.beatrice.bookfinder.Model.BookSearchResponse;
import com.beatrice.bookfinder.Repository.BookSearchRepository;

public class BookSearchViewModel extends ViewModel {
    private BookSearchRepository bookSearchRepository;
    private LiveData<BookSearchResponse> bookSearchResponseLiveData;

    public void init(String queryString, String apiKey){
        bookSearchRepository = new BookSearchRepository();
        bookSearchResponseLiveData = bookSearchRepository.getBooks(queryString, apiKey);
    }

    public LiveData<BookSearchResponse> getBookSearchResponse(){
        return bookSearchResponseLiveData;
    }
}
