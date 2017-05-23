package beginner.iak.com.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        TextView title = (TextView)findViewById(R.id.txtTitle);
        TextView sub = (TextView)findViewById(R.id.txtSub);

        int icon = getIntent().getExtras().getInt("icon");
        String txttitle = getIntent().getExtras().getString("title");
        String txtsub = getIntent().getExtras().getString("sub");

        iv.setImageResource(icon);
        title.setText(txttitle);
        sub.setText(txtsub);


    }
}
