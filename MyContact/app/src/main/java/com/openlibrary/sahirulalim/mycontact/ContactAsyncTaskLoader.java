package com.openlibrary.sahirulalim.mycontact;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import cz.msebera.android.httpclient.Header;

public class ContactAsyncTaskLoader extends AsyncTaskLoader<ArrayList<MyContact>> {

    static final String ALAMAT="https://api.androidhive.info/contacts/";
    ArrayList<MyContact> mData=new ArrayList<>();
    boolean mHasResult=false;
    public ContactAsyncTaskLoader(@NonNull Context context) {
        super(context);
        onContentChanged();
    }

    @Nullable
    @Override
    public ArrayList<MyContact> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();
        final ArrayList<MyContact> contacts=new ArrayList<>();
        client.get(ALAMAT, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                setUseSynchronousMode(true);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result=new String(responseBody);
                try {
                    JSONObject reponseObject=new JSONObject(result);
                    JSONArray jsonArray=reponseObject.getJSONArray("contacts");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject contact =jsonArray.getJSONObject(i);
                        MyContact myContact=new MyContact(contact);
                        contacts.add(myContact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return contacts;
    }

    @Override
    protected void onStartLoading() {
        if(takeContentChanged()){
            forceLoad();
        }else{
            deliverResult(mData);
        }
    }

    @Override
    public void deliverResult(@Nullable ArrayList<MyContact> data) {
        mData=data;
        mHasResult=true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if(mHasResult){
            mData=null;
            mHasResult=false;
        }
    }
}
