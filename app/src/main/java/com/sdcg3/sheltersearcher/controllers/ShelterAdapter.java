package com.sdcg3.sheltersearcher.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.Shelter;

import java.util.List;

/**
 * Created by pi on 3/4/18.
 *
 */

public class ShelterAdapter extends ArrayAdapter<Shelter> {
//    private List<Shelter> shelters;
//    private Context mContext;

    private static class ViewHolder {
        TextView name;
    }
    public ShelterAdapter(List<Shelter> data, Context context) {
        super(context, R.layout.row_item, data);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Shelter shelter = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.name = convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(shelter.name);//can this be moved to first if statement?

        // Return the completed view to render on screen
        return convertView;
    }
}

