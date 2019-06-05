package br.com.digitalhouse.recyclerviewlistenerexercicio.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.recyclerviewlistenerexercicio.R;
import br.com.digitalhouse.recyclerviewlistenerexercicio.RecycleViewClickListener;
import br.com.digitalhouse.recyclerviewlistenerexercicio.model.Professor;

public class RecyclerViewProfessorAdapter extends RecyclerView.Adapter<RecyclerViewProfessorAdapter.ViewHolder> {
    private List<Professor> professores;
    private RecycleViewClickListener listener;

    public RecyclerViewProfessorAdapter(List<Professor> professores, RecycleViewClickListener listener) {
        this.professores = professores;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.professor_recyclerview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Professor professor = professores.get(i);
        viewHolder.bind(professor);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(professor);
            }
        });

    }

    @Override
    public int getItemCount() {
        return professores.size();
    }

    //Class ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPhoto;
        private TextView textViewName;
        private TextView textViewCourse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewCourse = itemView.findViewById(R.id.textViewCourse);
        }

        public void bind(Professor professor) {
            imageViewPhoto.setImageDrawable(ContextCompat
                    .getDrawable(imageViewPhoto.getContext(), professor.getPhoto()));
            textViewName.setText(professor.getName());
            textViewCourse.setText(professor.getCourse());
        }
    }
}
