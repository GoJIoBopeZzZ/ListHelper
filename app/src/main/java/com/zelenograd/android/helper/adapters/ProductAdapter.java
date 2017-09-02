package com.zelenograd.android.helper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zelenograd.android.helper.R;
import com.zelenograd.android.helper.models.Product;
import com.zelenograd.android.helper.models.UserNotification;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by _red_ on 01/09/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> entries;
    private List<Product> filterEntries;
    private Context context;

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        entries = new ArrayList<Product>();
        if (charText.length() == 0) {
            entries.addAll(filterEntries);
        } else {
            for (Product item : filterEntries) {
                if (item.getDescription().toLowerCase(Locale.getDefault()).contains(charText)) {
                    entries.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context, List<Product> entries) {
        this.context = context;
        this.entries = entries;
        filterEntries = entries;
    }

    @Override
    public ProductAdapter.ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ProductHolder holder, int position) {
        holder.bindData(entries.get(position));
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView ivColor;
        private TextView tvDescription;
        private long position;

        private final String TAG = "ProductHolder";

        ProductHolder(View itemView) {
            super(itemView);
            ivColor = itemView.findViewById(R.id.ivColor);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivColor.setOnClickListener(this);
            Log.d(TAG, "Created new ProductHolder");
        }

        void bindData(Product entry) {
            ivColor.setBackgroundColor(entry.getColor());
            tvDescription.setText(entry.getDescription());
            position = entry.getId();
            Log.d(TAG, "Product added!");
        }

        @Override
        public void onClick(View view) {
            UserNotification.showMessage(context, "Click position - " + position);
        }
    }
}
