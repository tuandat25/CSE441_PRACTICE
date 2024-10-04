package com.tuandat.btth.prac03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tuandat.btth.prac03.entity.Country;

public class CoutryDetailActivity extends AppCompatActivity {
    private ImageView imageViewFlag;
    private TextView textViewNation, textViewCapital,
            textViewPopulation, textViewArea, textViewDensity, textViewWorldShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coutry_detail);
        imageViewFlag = findViewById(R.id.imageViewFlag);
        textViewNation = findViewById(R.id.textViewNation);
        textViewCapital = findViewById(R.id.textViewCapital);
        textViewPopulation = findViewById(R.id.textViewPopulation);
        textViewArea = findViewById(R.id.textViewArea);
        textViewDensity = findViewById(R.id.textViewDensity);
        textViewWorldShare = findViewById(R.id.textViewWorldShare);

        Country country = (Country) getIntent().getSerializableExtra("country");

        if (country != null) {
            imageViewFlag.setImageResource(country.getFlagResource());
            textViewNation.setText("Nation: " + country.getName());
            textViewCapital.setText("Capital: " + country.getCapital());
            textViewPopulation.setText("Population: " + country.getPopulation()+" million people");
            textViewArea.setText("Area: " + country.getArea() + " Km²");
            textViewDensity.setText("Density: " + country.getDensity() + " people/Km²");
            textViewWorldShare.setText("World Share: " + country.getWorldShare() + "%");
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}