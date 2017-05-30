package beginner.iak.com.simplelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        Button btnCustom = (Button) findViewById(R.id.btnCustomList);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCustom = new Intent(RootActivity.this, CustomListActivity.class);
                startActivity(toCustom);

            }
        });

        Button btnRecycler = (Button) findViewById(R.id.btnRecycleAdapter);
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecycler = new Intent(RootActivity.this, RecyclerActivity.class);
                startActivity(toRecycler);
            }
        });

        Button btnVolley = (Button) findViewById(R.id.btnVolley);
        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecycler = new Intent(RootActivity.this, VolleyActivity.class);
                startActivity(toRecycler);
            }
        });
    }
}
