package com.example.restaurant;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Add extends AppCompatActivity {
    My_Adapter adapter;
    Data db;
    filter restaurantFilter = new filter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Add context = this;
        db = Data.getInstance(this);

        List<restaurants> restaurants =  db.Database().getAll();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new My_Adapter(this, restaurants);
        recyclerView.setAdapter(adapter);
        Button addButton =  findViewById(R.id.button6);
        addButton.setOnClickListener(view -> {
            Intent addPageIntent = new Intent(this, MainActivity.class);
            startActivity(addPageIntent);
        });

        EditText RatingInput = findViewById(R.id.ratingid);
        EditText nameInput =  findViewById(R.id.nameid);
        EditText phoneInput =  findViewById(R.id.phoneid);
        EditText locationInput =  findViewById(R.id.locid);
        EditText desInput =  findViewById(R.id.desid);

        Button filterBtn =  findViewById(R.id.button5);

        filterBtn.setOnClickListener(view -> {
            List<restaurants> restaurantsFiltered = db.Database().getByFilter(
                    restaurantFilter.getName(), restaurantFilter.getLocation(),
                    restaurantFilter.getDes(),restaurantFilter.get_phone(),
                    restaurantFilter.getRating()

                    );
            adapter = new My_Adapter(context, restaurantsFiltered);
            recyclerView.setAdapter(adapter);
        });
        RatingInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                restaurantFilter.setRating(Float.parseFloat(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        phoneInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                restaurantFilter.setphone(Integer.parseInt(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                restaurantFilter.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        locationInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                restaurantFilter.setLocation(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        desInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                restaurantFilter.setDes(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void onResume(){
        super.onResume();
        List<restaurants> restaurants =  db.Database().getAll();
        adapter = new My_Adapter(this, restaurants);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
    }
}