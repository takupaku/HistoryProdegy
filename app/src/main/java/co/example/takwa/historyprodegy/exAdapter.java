package co.example.takwa.historyprodegy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class exAdapter extends BaseExpandableListAdapter {

    private Context context;
    ArrayList<String> header = new ArrayList<>();
    HashMap<String, ArrayList<String>> child = new HashMap<>();

    public exAdapter(Context context, ArrayList<String> header, HashMap<String, ArrayList<String>> child) {
        this.context = context;
        this.header = header;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child.get(header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(header.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_activity, null);
        }

        String s = (String) getGroup(groupPosition);
        TextView textView = convertView.findViewById(R.id.tvHeader);
        ImageView imageView= convertView.findViewById(R.id.ivIndicator);
        textView.setText(s);

        if(isExpanded){
            imageView.setImageResource(R.drawable.down_array);
        }
        else{
            imageView.setImageResource(R.drawable.right_array);

        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_activity, null);
        }

        String s = (String) getChild(groupPosition,childPosition);
        TextView textView = convertView.findViewById(R.id.tvChild);
        textView.setText(s);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
