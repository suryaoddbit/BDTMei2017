package beginner.iak.com.simplelistview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomListAdpter extends ArrayAdapter<Model> {
    Context context;
    int layoutResourceId;
    ArrayList<Model> data = null;
    public CustomListAdpter(Context context, int resource, ArrayList<Model> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = objects;

    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;

        if (row == null){

            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new WeatherHolder();
            holder.img = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTittle = (TextView) row.findViewById(R.id.txtTitle);
            holder.txtSub = (TextView) row.findViewById(R.id.txtSubtittle);
            row.setTag(holder);

        }else{

            holder = (WeatherHolder)row.getTag();
        }
        Model weather = data.get(position);
        holder.txtTittle.setText(weather.title);
        holder.img.setImageResource(weather.icon);
        holder.txtSub.setText(weather.sub);
        return row;
    }

    static class WeatherHolder{
        ImageView img;
        TextView txtTittle;
        TextView txtSub;
    }

}
