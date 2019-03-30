package com.example.artisansfinal;

public class ArtisanInfo {

    String artisan_id;
    String email;
    String contact_no;
    String postal_address;
    String username;
    String wallet;
    String FCMToken;



    public ArtisanInfo(String artisan_id, String email, String contact_no,String wallet, String postal_address, String username, String FCMToken) {
        this.artisan_id = artisan_id;
        this.email = email;
        this.contact_no = contact_no;
        this.postal_address = postal_address;
        this.wallet=wallet;
        this.username = username;
        this.FCMToken = FCMToken;
    }

    public ArtisanInfo(String artisan_id, String email, String contact_no, String postal_address, String username) {
        this.artisan_id = artisan_id;
        this.email = email;
        this.contact_no = contact_no;
        this.postal_address = postal_address;
        this.username = username;

    }

    public ArtisanInfo()
    {

    }


    public String getArtisan_id() {
        return artisan_id;
    }

    public String getEmail() {
        return email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public String getUsername() {
        return username;
    }

    public String getWallet() {
        return wallet;
    }
    //    public String getFCMToken() {
//        return FCMToken;
//    }

}
