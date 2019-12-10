package com.openlibrary.sahirulalim.mycontact;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<MyContact>> {
    static ArrayList<MyContact> myContact=new ArrayList<>();
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactAdapter=new ContactAdapter(this);
        contactAdapter.notifyDataSetChanged();

        recyclerView=findViewById(R.id.Recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactAdapter.setData(contactAdapter.getData());
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        getSupportLoaderManager().initLoader(0,null,this);
    }

    @NonNull
    @Override
    public Loader<ArrayList<MyContact>> onCreateLoader(int id, @Nullable Bundle args) {
        return new ContactAsyncTaskLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<MyContact>> loader, ArrayList<MyContact> data) {
        contactAdapter.setData(data);
        myContact=data;
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<MyContact>> loader) {
        contactAdapter.setData(null);
    }
    public static ArrayList<MyContact> getMyContact(){
        return myContact;
    }
}
