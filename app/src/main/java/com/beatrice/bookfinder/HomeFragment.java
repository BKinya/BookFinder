package com.beatrice.bookfinder;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beatrice.bookfinder.Model.BookSearchResponse;
import com.beatrice.bookfinder.ViewModel.BookSearchViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private BookSearchViewModel bookSearchViewModel;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        bookSearchViewModel = ViewModelProviders.of(getActivity()).get(BookSearchViewModel.class);
        bookSearchViewModel.init("Paulo Coelho", Util.API_KEY);
        bookSearchViewModel.getBookSearchResponse().observe(getViewLifecycleOwner(), new Observer<BookSearchResponse>() {
            @Override
            public void onChanged(BookSearchResponse bookSearchResponse) {
                Log.e("REEESPONSE", String.valueOf(bookSearchResponse.getItems().size()));
            }
        });


        return rootView;
    }

}
