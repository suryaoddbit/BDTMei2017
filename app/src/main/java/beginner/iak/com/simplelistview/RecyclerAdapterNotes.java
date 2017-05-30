package beginner.iak.com.simplelistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import beginner.iak.com.simplelistview.model.Note;


/**
 * Created by SasserNetsky on 5/25/17.
 */

public class RecyclerAdapterNotes extends RecyclerView.Adapter<RecyclerAdapterNotes.ViewHolder> {
    private static ClickListener clickListener;
    private ArrayList<Note> rvData;

    public RecyclerAdapterNotes(ArrayList<Note> inputData) {
        rvData = inputData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvTitle.setText(rvData.get(position).getEmail());
        holder.tvSubtitle.setText(rvData.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public interface ClickListener {

        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(RecyclerAdapterNotes.ClickListener clickListener) {
        RecyclerAdapterNotes.clickListener = clickListener;

    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView tvTitle;
        public TextView tvSubtitle;

        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvSubtitle = (TextView) v.findViewById(R.id.tv_subtitle);
        }
    }
}

