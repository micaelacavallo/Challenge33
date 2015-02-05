package com.example.micaelacavallo.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by micaela.cavallo on 05/02/2015.
 */
public class TaskAdapter extends ArrayAdapter<Task> {

    Context mContext;
    List<Task> mTask;

    public TaskAdapter (Context context, List<Task> task)
    {
        super(context, R.layout.list_item_entry, task);
        mContext = context;
        mTask = task;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = reuseOrGenerateRowView(convertView, parent);
        displayContentInView(position, rowView);
        return rowView;
    }

    private View reuseOrGenerateRowView(View convertView, ViewGroup parent) {
        View rowView;
        if (convertView != null) {
            rowView = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_entry, parent, false);
        }
        return rowView;
    }

    private void displayContentInView(final int position, View rowView) {
        if (rowView != null) {
            TextView textViewTask = (TextView)rowView.findViewById(R.id.text_view_task);
            textViewTask.setText(mTask.get(position).getTitle());
            CheckBox checkBoxDone =(CheckBox)rowView.findViewById(R.id.check_box_done);
            checkBoxDone.setChecked(mTask.get(position).getDone());
            checkBoxDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mTask.get(position).setDone(isChecked);
                }
            });

        }
    }
}
