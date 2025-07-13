package com.example.proqwiz.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proqwiz.DbQuery;
import com.example.proqwiz.Models.CategoryModel;
import com.example.proqwiz.R;
import com.example.proqwiz.TestsActivity;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    private List<CategoryModel> catList;

    public CategoryAdapter(List<CategoryModel> catList) {
        this.catList = catList;
    }

    @Override
    public int getCount() {
        return catList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view;

        if(convertView == null)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item_layout,parent,false);
        }
        else
        {
            view = convertView;
        }


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbQuery.selected_cat_index = position;
                Intent intent = new Intent(v.getContext(), TestsActivity.class);
                v.getContext().startActivity(intent);
            }
        });


        ((TextView) view.findViewById(R.id.catName)).setText(catList.get(position).getName());
        ((TextView) view.findViewById(R.id.no_of_tests)).setText(String.valueOf(catList.get(position).getNoOfTest()) + " Tests");

        return view;
    }
}
