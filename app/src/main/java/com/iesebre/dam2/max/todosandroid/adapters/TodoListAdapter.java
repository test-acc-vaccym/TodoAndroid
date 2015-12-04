package com.iesebre.dam2.max.todosandroid.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iesebre.dam2.max.todosandroid.R;
import com.iesebre.dam2.max.todosandroid.models.TodoItem;

import java.util.ArrayList;

/**
 * Created by max on 20/11/15.
 */
public class TodoListAdapter extends BaseAdapter {

    private Activity activity;
    private int resource;
    private ArrayList<TodoItem> list;

    public TodoListAdapter(Activity activity, int resource, ArrayList listData)
    {
        this.activity = activity;
        this.resource = resource;
        this.list = listData;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // TODO, this is not the best solution...
        convertView = null;

        if (convertView == null)
        {
            convertView = activity.getLayoutInflater().inflate(resource, null);

            TodoItem item = list.get(position);

            if (item != null)
            {
                TextView tv1 = (TextView) convertView.findViewById(R.id.id1);
                TextView tv2 = (TextView) convertView.findViewById(R.id.id2);

                tv1.setText(item.getName());
                tv2.setText(String.valueOf(item.getPriority()));
            }
        }

        return convertView;

    }
}