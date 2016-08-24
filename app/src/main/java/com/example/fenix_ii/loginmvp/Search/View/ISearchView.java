package com.example.fenix_ii.loginmvp.Search.View;

import com.example.fenix_ii.loginmvp.Search.model.SearchModel;

/**
 * Created by fenix-ii on 23/8/16.
 */
public interface ISearchView {
    void onFetchSuccess(SearchModel searchModel);
    void onFail(String msg);
}