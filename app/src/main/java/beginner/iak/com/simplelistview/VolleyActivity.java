package beginner.iak.com.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

import beginner.iak.com.simplelistview.model.Note;
import beginner.iak.com.simplelistview.model.APIResponse;

public class VolleyActivity extends AppCompatActivity {
    private RecyclerView rvView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<APIResponse> dataSet = new ArrayList<>();
    private RecyclerAdapterNotes adapter;

    private APIResponse notesResponse;
    private Gson gson = new Gson();

    private ArrayList<Note> listNotes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        //listNotes = new ArrayList<>();
        adapter = new RecyclerAdapterNotes(listNotes);
        rvView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerAdapterNotes.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }
        });

        getDataFromAPI();
    }

    /**
     * Created by SasserNetsky on 5/25/17.
     */

    public void getDataFromAPI(){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url = "http://note.bali-besttour.com/api.php/notes?transform=1";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                notesResponse = gson.fromJson(response, APIResponse.class);
                for (Note note : notesResponse.getList()){

                    listNotes.add(note);
                }
                adapter.notifyDataSetChanged();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                responseListener,
                errorListener

        );

        requestQueue.add(request);
    }


}
