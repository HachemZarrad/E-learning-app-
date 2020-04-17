package com.example.release;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Catalog extends AppCompatActivity {

    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fillExampleList();
        setUpRecyclerView();

    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.instructor, "Title : Javascript", "one"));
        exampleList.add(new ExampleItem(R.drawable.teacher, "DesignPattern", "two"));
        exampleList.add(new ExampleItem(R.drawable.instructor, "Oriented objected programming", "three"));
        exampleList.add(new ExampleItem(R.drawable.teacher, "Javascript basics", "four"));
        exampleList.add(new ExampleItem(R.drawable.teacher, "Basic Git Commands", "five"));
        exampleList.add(new ExampleItem(R.drawable.instructor, "DOM JS", "six"));
        exampleList.add(new ExampleItem(R.drawable.instructor, "Git in Android-Studio", "seven"));
        exampleList.add(new ExampleItem(R.drawable.teacher, "JS functions", "eight"));
        exampleList.add(new ExampleItem(R.drawable.instructor, "Android Broadcast Receivers", "nine"));
        exampleList.add(new ExampleItem(R.drawable.teacher, "IELTS Academic wordlist", "ten"));
        exampleList.add(new ExampleItem(R.drawable.instructor, "Uml", "eleven"));
        exampleList.add(new ExampleItem(R.drawable.teacher, "DataBase", "twelve"));


    }

    public void openUp(View v){
        Intent discoverCourse = new Intent(this, PayingCourse.class);
        startActivity(discoverCourse);
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        MenuInflater inflater1 = getMenuInflater();
        inflater1.inflate(R.menu.menu_main,menu);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(this, MainActivity.class);
                startActivity(intToMain);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
