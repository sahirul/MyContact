package com.openlibrary.sahirulalim.mycontact;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private ArrayList<MyContact> mData=new ArrayList<>();
    private LayoutInflater mInflater;
    private Context context;

    public ContactAdapter(Context context){
        this.context=context;
        mInflater=LayoutInflater.from(this.context);
    }

    public void setData(ArrayList<MyContact> items){
        mData=items;
        notifyDataSetChanged();
    }

    public ArrayList<MyContact> getData(){

        return mData;
    }

    public void addItem(MyContact myContact){
        mData.add(myContact);
        notifyDataSetChanged();
    }

    public void clearData(){
        mData.clear();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.layout_row_contact,parent,false);
        view.setTag(view);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {
        holder.textName.setText(getData().get(position).getName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),DetailContact.class);
                intent.putExtra("data", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getData().size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView textName;
        Button button;
        ContactViewHolder(View item){
            super(item);
            textName=item.findViewById(R.id.txtname);
            button=item.findViewById(R.id.btndetail);
        }
    }
}
