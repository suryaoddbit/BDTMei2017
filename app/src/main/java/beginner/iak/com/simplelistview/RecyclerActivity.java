package beginner.iak.com.simplelistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Model> dataSet;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        dataSet = new ArrayList<>();
        dataSet.add(new Model(R.mipmap.ic_launcher,"Item 1", "Sub Item 1"));
        dataSet.add(new Model(R.mipmap.ic_launcher_round,"Item 2", "Sub Item 2"));
        dataSet.add(new Model(R.mipmap.ic_launcher,"Item 3", "Sub Item 3"));

        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataSet);
        rvView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerViewAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Model model = dataSet.get(position);
                Intent toTarget = new Intent(RecyclerActivity.this, TargetActivity.class);
                toTarget.putExtra("icon",model.icon);
                toTarget.putExtra("title",model.title);
                toTarget.putExtra("sub",model.sub);
                startActivity(toTarget);
            }
        });













    }


}