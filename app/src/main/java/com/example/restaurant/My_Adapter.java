package com.example.restaurant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

public class My_Adapter extends RecyclerView.Adapter<My_Adapter.MyViewHolder>  {
    private List<restaurants> restaurantsData;

    private LayoutInflater mInflater;
    // data is passed into the constructor
    My_Adapter(Context context, List<restaurants> data) {
        this.mInflater = LayoutInflater.from(context);
        this.restaurantsData = data;

    }


    @NonNull
    @Override
    public My_Adapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.view, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder( My_Adapter.MyViewHolder holder, int position) {
        restaurants  restaurant = restaurantsData.get(position);
        holder.rating.setText(Float.toString(restaurant.rating));
        holder.name.setText(restaurant.name);
        holder.location.setText(restaurant.location);
        holder.description.setText(restaurant.description);
        holder.phone.setText(restaurant.phone);

    }

    @Override
    public int getItemCount() {
        return restaurantsData.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView rating;
        TextView description;
        TextView location;
        TextView name;
        TextView phone;

        public MyViewHolder( View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.ratingV);
            description = itemView.findViewById(R.id.descriptionV);
            location = itemView.findViewById(R.id.locationV);
            phone = itemView.findViewById(R.id.phoneV);
            name = itemView.findViewById(R.id.restaurantName);

        }
    }
}
