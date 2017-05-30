package beginner.iak.com.simplelistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static ClickListener clickListener;
    private ArrayList<Model> rvData;

    public RecyclerViewAdapter(ArrayList<Model> inputData) {
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

        holder.tvTitle.setText(rvData.get(position).title);
        holder.tvSubtitle.setText(rvData.get(position).sub);
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public interface ClickListener{

        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener){
        RecyclerViewAdapter.clickListener = clickListener;

    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTitle;
        public TextView tvSubtitle;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);



            tvTitle = (TextView) v.findViewById(R.id.tv_subtitle);
            tvSubtitle = (TextView) v.findViewById(R.id.tv_title);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}