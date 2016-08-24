package com.example.fenix_ii.loginmvp.Search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fenix_ii.loginmvp.R;
import com.example.fenix_ii.loginmvp.Search.View.ISearchView;
import com.example.fenix_ii.loginmvp.Search.model.SearchModel;
import com.example.fenix_ii.loginmvp.Search.presenter.SearchPresenter;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fenix-ii on 23/8/16.
 */
public class SearchFetch extends AppCompatActivity implements ISearchView {
    ListView listView;
    SearchPresenter searchPresenter;
    //public ListAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ButterKnife.bind(this);
        listView=(ListView)findViewById(R.id.listView);
        ArrayList <String> arrayList=new ArrayList<String>();
        ArrayAdapter<String > myadapter = new ArrayAdapter<String>(this,R.layout.search,arrayList);
        listView.setAdapter(myadapter);
        searchPresenter = new SearchPresenter();
        try {
            searchPresenter.fetchList();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onFetchSuccess(SearchModel searchModel) {
        //arrayList=searchModel.getName();
        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
