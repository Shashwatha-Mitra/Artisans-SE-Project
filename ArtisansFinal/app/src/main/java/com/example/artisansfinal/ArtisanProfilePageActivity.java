package com.example.artisansfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ArtisanProfilePageActivity extends AppCompatActivity{

        DatabaseReference databaseArtisans;
        Button buttonUpdateArtisan;

        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();

        FirebaseUser userX = firebaseAuth.getCurrentUser();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_artisan_profile_page);

            databaseArtisans= FirebaseDatabase.getInstance().getReference("Artisans");

            buttonUpdateArtisan=(Button)findViewById(R.id.editArtisanInfoButton);
            buttonUpdateArtisan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ArtisanProfilePageActivity.this, ArtisanProfileUpdateActivity.class);
                    startActivity(i);
                }
            });

            databaseArtisans.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot ArtisanSnapshot: dataSnapshot.getChildren()) {
                        ArtisanInfo Artisan = ArtisanSnapshot.getValue(ArtisanInfo.class);
                        try {

                            if (Artisan.contact_no.equals(userX.getPhoneNumber())) {
                                TextView name = (TextView) findViewById(R.id.ArtisanName);
                                TextView phno = (TextView) findViewById(R.id.ArtisanPhno);
                                TextView pc = (TextView) findViewById(R.id.ArtisanPC);

                                name.setText(Artisan.username);
                                phno.setText(Artisan.contact_no);
                                pc.setText(Artisan.postal_address);

                                break;
                            }
                        } catch (NullPointerException e) {
                            Log.d("Err", "Exception "+e.getMessage().toString());
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
