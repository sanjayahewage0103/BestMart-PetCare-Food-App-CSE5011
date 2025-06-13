package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalogActivity extends AppCompatActivity {

    private EditText searchBar;
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalog);

        searchBar = findViewById(R.id.searchBar);
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

        // Initialize the category list
        categoryList = new ArrayList<>();
        loadCategories();

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void loadCategories() {
        // Load sample categories and products
        List<Product> dryFoodProducts = new ArrayList<>();
        dryFoodProducts.add(new Product(1, "Dry Food 1", "Description 1", 10.0, "Dry Food", "Brand A", "Adult", R.drawable.sample_image));
        dryFoodProducts.add(new Product(2, "Dry Food 2", "Description 2", 12.0, "Dry Food", "Brand B", "Puppy", R.drawable.sample_image));
        dryFoodProducts.add(new Product(3, "Dry Food 3", "Description 3", 15.0, "Dry Food", "Brand C", "Senior", R.drawable.sample_image));
        dryFoodProducts.add(new Product(4, "Dry Food 4", "Description 4", 20.0, "Dry Food", "Brand D", "All Ages", R.drawable.sample_image));
        dryFoodProducts.add(new Product(5, "Dry Food 5", "Description 5", 18.0, "Dry Food", "Brand E", "Adult", R.drawable.sample_image));

        List<Product> wetFoodProducts = new ArrayList<>();
        wetFoodProducts.add(new Product(6, "Wet Food 1", "Description 1", 11.0, "Wet Food", "Brand F", "Adult", R.drawable.sample_image));
        wetFoodProducts.add(new Product(7, "Wet Food 2", "Description 2", 13.0, "Wet Food", "Brand G", "Puppy", R.drawable.sample_image));
        wetFoodProducts.add(new Product(8, "Wet Food 3", "Description 3", 14.0, "Wet Food", "Brand H", "Senior", R.drawable.sample_image));
        wetFoodProducts.add(new Product(9, "Wet Food 4", "Description 4", 21.0, "Wet Food", "Brand I", "All Ages", R.drawable.sample_image));
        wetFoodProducts.add(new Product(10, "Wet Food 5", "Description 5", 19.0, "Wet Food", "Brand J", "Adult", R.drawable.sample_image));

        // Add more categories and products...

        categoryList.add(new Category("Dry Food", dryFoodProducts));
        categoryList.add(new Category("Wet Food", wetFoodProducts));
        // Add more categories...
    }
}
