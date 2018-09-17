package co.example.takwa.historyprodegy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ArrayList<String> header =new ArrayList<>();
    HashMap<String, ArrayList<String>> child= new HashMap<>();
    int lastPosition=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
        initFunctionality();

    }

    private void initFunctionality() {
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastPosition!= -1 && lastPosition!= groupPosition){

                    expandableListView.collapseGroup(lastPosition);
                }
                lastPosition =groupPosition;

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String children= child.get(header.get(groupPosition)).get(childPosition);
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private void loadData() {
        String[] h= getResources().getStringArray(R.array.parent);
        String[] c=getResources().getStringArray(R.array.child);
        int pos=-1;
        for(int i=0;i<h.length;i++){
            header.add(h[i]);
                ArrayList<String> list = new ArrayList<>();
                list.add(c[++pos]);
                list.add(c[++pos]);
                list.add(c[++pos]);
                child.put(header.get(i),list);


        }
        exAdapter adapter= new exAdapter(this,header,child);
        expandableListView.setAdapter(adapter);

    }

    private void initView() {
        expandableListView=findViewById(R.id.exlvId);

    }
}
