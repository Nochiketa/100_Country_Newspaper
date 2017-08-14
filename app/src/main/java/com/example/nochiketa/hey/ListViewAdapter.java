package com.example.nochiketa.hey;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static android.R.attr.name;
import static com.example.nochiketa.hey.R.attr.icon;

/**
 * Created by Nochiketa on 8/2/2017.
 */
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Country> countrylist = null;
    private ArrayList<Country> arraylist;

    public ListViewAdapter(Context context, List<Country> paperlist) {
        mContext = context;
        this.countrylist = paperlist;   //university as paperlist
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Country>();
        this.arraylist.addAll(paperlist);
    }

    public class ViewHolder {
        TextView name;
        ImageView icon;
    }

    @Override
    public int getCount() {
        return countrylist.size();
    }

    @Override
    public Country getItem(int position) {
        return countrylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_item_main, null);
            holder.name = (TextView) view.findViewById(R.id.textViewList);
            holder.icon = (ImageView) view.findViewById(R.id.ImageViewList);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(countrylist.get(position).getName());
        holder.icon.setImageResource(countrylist.get(position).getIcon());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, Main2Activity.class);
                intent.putExtra("name", (countrylist.get(position).getName()));
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        countrylist.clear();
        if (charText.length() == 0) {
            countrylist.addAll(arraylist);
        }
        else {
            for (Country wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    countrylist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}

