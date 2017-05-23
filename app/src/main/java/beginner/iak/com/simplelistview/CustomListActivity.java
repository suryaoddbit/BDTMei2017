package beginner.iak.com.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    ArrayList<String> value = new ArrayList<>();
    ListView list;
    Button btnAdd;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);


        //Simple List Adapter
//        value.add("Value 1");
//        value.add("Value 2");
//        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, value);
//        list.setAdapter(adapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String val = value.get(position);
//                Toast.makeText(getApplicationContext(),val,Toast.LENGTH_SHORT).show();
//            }
//        });


        // Custom List Adapter
        final ArrayList<Model> data = new ArrayList<>();
        for (int i = 0 ; i<10; i++){
            Model weather = new Model(R.mipmap.ic_launcher, "Tittle "+i, "Subtitle "+i);
            data.add(weather);
        }



        final CustomListAdpter adapter = new CustomListAdpter(this, R.layout.list_item, data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Model wet = data.get(position);
                Toast.makeText(getApplicationContext(),wet.title,Toast.LENGTH_SHORT).show();
            }
        });


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model = new Model(R.mipmap.ic_launcher_round, "Add New tittle ", "Add New Subtitle ");
                data.add(model);
                adapter.notifyDataSetChanged();
                list.setSelection(adapter.getCount() - 1);
            }
        });



    }
}
