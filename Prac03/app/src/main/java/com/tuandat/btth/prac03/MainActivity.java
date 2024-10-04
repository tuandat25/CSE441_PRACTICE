package com.tuandat.btth.prac03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuandat.btth.prac03.adapter.CountryAdapter;
import com.tuandat.btth.prac03.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewCountry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        countryList = getCountries();
        adapter = new CountryAdapter(countryList, this);
        recyclerView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Vietnam", "Hanoi", 97338583, 331212, 314, 0.81, R.drawable.vn_flag));
        countries.add(new Country("India", "New Delhi", 1428600000, 2973190, 481, 17.76, R.drawable.india_flag));
        countries.add(new Country("China", "Beijing", 1411778724, 9596961, 146, 18.47, R.drawable.china_flag));
        countries.add(new Country("United States", "Washington, D.C.", 327167434, 9147420, 36, 4.28, R.drawable.us_flag));
        countries.add(new Country("Indonesia", "Jakarta", 273523615, 1811570, 268, 3.07, R.drawable.indo_flag));
        countries.add(new Country("Brazil", "Brasilia", 212559417, 8515767, 25, 2.99, R.drawable.brazil));
        countries.add(new Country("Pakistan", "Islamabad", 220892331, 770216, 305, 2.22, R.drawable.pakistan));
        countries.add(new Country("Nigeria", "Abuja", 206139587, 923768, 187, 2.07, R.drawable.nigeria));
        countries.add(new Country("Bangladesh", "Dhaka", 164689383, 147570, 139, 1.46, R.drawable.banglades));
        countries.add(new Country("Vietnam", "Hanoi", 97338583, 331212, 314, 0.81, R.drawable.vn_flag));
        countries.add(new Country("India", "New Delhi", 1428600000, 2973190, 481, 17.76, R.drawable.india_flag));
        countries.add(new Country("China", "Beijing", 1411778724, 9596961, 146, 18.47, R.drawable.china_flag));
        countries.add(new Country("United States", "Washington, D.C.", 327167434, 9147420, 36, 4.28, R.drawable.us_flag));
        countries.add(new Country("Indonesia", "Jakarta", 273523615, 1811570, 268, 3.07, R.drawable.indo_flag));
        countries.add(new Country("Brazil", "Brasilia", 212559417, 8515767, 25, 2.99, R.drawable.brazil));
        countries.add(new Country("Pakistan", "Islamabad", 220892331, 770216, 305, 2.22, R.drawable.pakistan));
        countries.add(new Country("Nigeria", "Abuja", 206139587, 923768, 187, 2.07, R.drawable.nigeria));
        countries.add(new Country("Bangladesh", "Dhaka", 164689383, 147570, 139, 1.46, R.drawable.banglades));
        // Add more countries
        return countries;
    }
}