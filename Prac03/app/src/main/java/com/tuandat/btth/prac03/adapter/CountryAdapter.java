package com.tuandat.btth.prac03.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuandat.btth.prac03.CoutryDetailActivity;
import com.tuandat.btth.prac03.R;
import com.tuandat.btth.prac03.entity.Country;

import java.io.Serializable;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Country> countryList;
    private Context context;

    public CountryAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.textViewName.setText(country.getName());
        holder.textViewCapital.setText(country.getCapital());
        holder.imageViewFlag.setImageResource(country.getFlagResource());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CoutryDetailActivity.class);
            intent.putExtra("country", (Serializable) country);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewCapital;
        ImageView imageViewFlag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewCapital = itemView.findViewById(R.id.textViewCapital);
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag);
        }
    }
}

