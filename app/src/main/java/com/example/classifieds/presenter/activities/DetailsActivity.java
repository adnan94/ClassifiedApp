package com.example.classifieds.presenter.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.classifieds.R;
import com.example.classifieds.data.pojos.ClassifiedItem;
import com.example.classifieds.databinding.ActivityDetailsBinding;
import com.example.classifieds.presenter.Utils;

import okhttp3.internal.Util;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private ClassifiedItem classifiedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        manageIntent();
        setupBackButton();
        setupUI();
    }

    private void setupUI() {
        binding.name.setText("Product : "+classifiedItem.getName());
        binding.price.setText("Price : " + classifiedItem.getPrice());
        binding.itemId.setText("Item Id : " + classifiedItem.getUid());
        binding.createdAt.setText("Created At : " + Utils.Companion.convertToDate(classifiedItem.getCreated_at()));
        Uri uri = Uri.parse(classifiedItem.getImage_urls().get(0));
        binding.image.setImageURI(uri);
        Log.d("test","uri_value"+ String.valueof(uri));
    }

    private void manageIntent() {
        classifiedItem = getIntent().getParcelableExtra("item");
        getSupportActionBar().setTitle(classifiedItem.getName());
    }


    private void setupBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}