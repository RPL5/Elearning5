package com.androidprojectrpl.k5.learning_kelompok5.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidprojectrpl.k5.learning_kelompok5.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    TextView name;
    TextView gelar;
    TextView description;
    ImageView foto;
    TextView Title;
    TextView Time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.rv_detail_name_new);
        gelar = findViewById(R.id.rv_detailgelar_data_new);
        description = findViewById(R.id.rv_detail_content_data);
        foto = findViewById(R.id.rv_detail_foto_new);
        Title = findViewById(R.id.rv_detail_title);
        Time = findViewById(R.id.time_detail);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            name.setText(mBundle.getString("name"));
            description.setText(mBundle.getString("status"));
            gelar.setText(mBundle.getString("gelar"));
            Title.setText(mBundle.getString("title"));
            Time.setText(mBundle.getString("time"));
            Glide.with(getApplicationContext())
                    .load(mBundle.getString("photo"))
                    .apply(new RequestOptions().override(55, 55))
                    .into(foto);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
