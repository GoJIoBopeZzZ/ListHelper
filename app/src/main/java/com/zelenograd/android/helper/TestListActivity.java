package com.zelenograd.android.helper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zelenograd.android.helper.adapters.ProductAdapter;
import com.zelenograd.android.helper.models.Product;

import java.util.ArrayList;
import java.util.List;

public class TestListActivity extends AppCompatActivity {

    private List<Product> products = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        initProducts();

        recyclerView = (RecyclerView) findViewById(R.id.items_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter(this, products));
    }

    private void initProducts() {
        for (int i = 0; i < 1000; i++)
            products.add(new Product(i, String.valueOf(i)));
    }
}
