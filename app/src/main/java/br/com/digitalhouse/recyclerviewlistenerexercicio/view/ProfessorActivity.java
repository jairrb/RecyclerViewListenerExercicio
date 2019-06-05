package br.com.digitalhouse.recyclerviewlistenerexercicio.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.recyclerviewlistenerexercicio.R;
import br.com.digitalhouse.recyclerviewlistenerexercicio.RecycleViewClickListener;
import br.com.digitalhouse.recyclerviewlistenerexercicio.adapters.RecyclerViewProfessorAdapter;
import br.com.digitalhouse.recyclerviewlistenerexercicio.model.Professor;

public class ProfessorActivity extends AppCompatActivity implements RecycleViewClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewProfessorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        recyclerView = findViewById(R.id.recyclerViewProfessor);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        adapter = new RecyclerViewProfessorAdapter(getProfessor(),this);

        recyclerView.setAdapter(adapter);


    }

    private List<Professor> getProfessor() {
        List<Professor> professores = new ArrayList<>();

        professores.add(new Professor("Professor A","Android","BLABLABLABLABLABLABLABLABLABLABLABLA",R.drawable.prof1));
        professores.add(new Professor("Professor B","Android","BLABLABLABLABLABLABLABLABLABLABLABLA",R.drawable.prof2));
        professores.add(new Professor("Professor C","Android","BLABLABLABLABLABLABLABLABLABLABLABLA",R.drawable.prof3));
        professores.add(new Professor("Professor D","Android","BLABLABLABLABLABLABLABLABLABLABLABLA",R.drawable.prof4));
        professores.add(new Professor("Professor E","Android","BLABLABLABLABLABLABLABLABLABLABLABLA",R.drawable.prof5));
        professores.add(new Professor("Professor F","Android","BLABLABLABLABLABLABLABLABLABLABLABLA",R.drawable.prof6));
        professores.add(new Professor("Professor G","Android","BLABLABLABLABLABLABLABLABLABLABLABLA",R.drawable.prof7));
        return professores;
    }


    @Override
    public void onClick(Professor professor) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("PROFESSOR",professor);
        startActivity(intent);
    }
}
