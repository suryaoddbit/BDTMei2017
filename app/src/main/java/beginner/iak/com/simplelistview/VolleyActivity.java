package beginner.iak.com.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
import beginner.iak.com.simplelistview.model.User;
import beginner.iak.com.simplelistview.model.UsersResponse;

public class VolleyActivity extends AppCompatActivity {
    private RecyclerView rvView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<APIResponse> dataSet = new ArrayList<>();
    private RecyclerAdapterNotes noteAdapter;

    private UsersAdapter usersAdapter;

    private APIResponse notesResponse;
    private Gson gson = new Gson();

    private ArrayList<Note> listNotes = new ArrayList<>();
    private ArrayList<User> listUser = new ArrayList<>();

    private UsersResponse usersResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        //listNotes = new ArrayList<>();
        noteAdapter = new RecyclerAdapterNotes(listNotes);
        //rvView.setAdapter(noteAdapter);

        usersAdapter = new UsersAdapter(listUser);
        rvView.setAdapter(usersAdapter);

        noteAdapter.setOnItemClickListener(new RecyclerAdapterNotes.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }
        });

        //getNoteFromAPI();
        getUsersFromAPI();
    }

    // untuk mengambil data note
    public void getNoteFromAPI(){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        /**
         * coba ganti dengan url http://note.bali-besttour.com/api.php/users?transform=1 dan tampikan field name dan email
         */
        final String url = "http://note.bali-besttour.com/api.php/notes?transform=1";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                notesResponse = gson.fromJson(response, APIResponse.class);
                for (Note note : notesResponse.getList()){

                    listNotes.add(note);
                }
                noteAdapter.notifyDataSetChanged();
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

    // untuk mendapatkan data users dari api
    public void getUsersFromAPI(){

        RequestQueue resRequestQueue = Volley.newRequestQueue(this);

        final String urlUsers = "http://note.bali-besttour.com/api.php/users?transform=1";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                usersResponse = gson.fromJson(response, UsersResponse.class);

                for (User user : usersResponse.getUsers()){
                    listUser.add(user);
                }
                usersAdapter.notifyDataSetChanged();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VolleyActivity", "onErrorResponse: " + error.getMessage());
            }
        };

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                urlUsers,
                responseListener,
                errorListener
        );

        resRequestQueue.add(stringRequest);

    }

}
