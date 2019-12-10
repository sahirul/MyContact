package com.openlibrary.sahirulalim.mycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailContact extends AppCompatActivity {

    ContactAdapter contactAdapter;
    Intent intent;
    TextView txtname,txtemail,txtalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);
        intent=getIntent();
        contactAdapter=new ContactAdapter(this);
        int posisi=intent.getIntExtra("data",0);
        txtname=findViewById(R.id.txtname);
        txtemail=findViewById(R.id.txtemail);
        txtalamat=findViewById(R.id.txtalamat);
        txtname.setText(": "+MainActivity.getMyContact().get(posisi).getName());
        txtemail.setText(": "+MainActivity.getMyContact().get(posisi).getEmail());
        txtalamat.setText(": "+MainActivity.getMyContact().get(posisi).getAddress());
    }
}
