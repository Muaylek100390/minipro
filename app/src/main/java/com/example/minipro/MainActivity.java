package com.example.minipro;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference LED,LED1,LED2;
    public static final String TAG ="Control";
    public Button led;
    public Integer value1,value0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        LED = firebaseDatabase.getReference("LED");

        led = (Button)findViewById(R.id.button);
        LED.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.getValue(Integer.class);

                if(value1==1){
                   led.setText("LED_ON");
                   value0=0;
                }
                else {
                    led.setText("LED_OFF");
                    value0=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LED.setValue(value0);
            }
        });

        led = (Button)findViewById(R.id.button2);
        LED1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.getValue(Integer.class);

                if(value1==1){
                    led.setText("LED1_ON");
                    value0=0;
                }
                else {
                    led.setText("LED1_OFF");
                    value0=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LED1.setValue(value0);
            }
        });

        led = (Button)findViewById(R.id.button);
        LED2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.getValue(Integer.class);

                if(value1==1){
                    led.setText("LED2_ON");
                    value0=0;
                }
                else {
                    led.setText("LED2_OFF");
                    value0=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LED2.setValue(value0);
            }
        });
    }
}
