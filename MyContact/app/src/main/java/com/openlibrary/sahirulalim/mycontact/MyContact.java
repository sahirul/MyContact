package com.openlibrary.sahirulalim.mycontact;

import org.json.JSONObject;

public class MyContact {
    private String id;
    private String name;
    private String email;
    private String addres;

    public MyContact(JSONObject json){
        try {
            this.id=json.getString("id");
            this.name=json.getString("name");
            this.email=json.getString("email");
            this.addres=json.getString("address");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getAddress(){
        return addres;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setAddress(String addres){
        this.addres=addres;
    }
}
