package beginner.iak.com.simplelistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import beginner.iak.com.simplelistview.model.User;

/**
 * Created by awidiyadew on 5/30/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    ArrayList<User> listUser = new ArrayList<>();

    public UsersAdapter(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        UserViewHolder vh = new UserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = listUser.get(position);
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());

        Context context = holder.itemView.getContext();
        String photoUrl = user.getPhoto();

        Glide.with(context)
                .load(photoUrl)
                .centerCrop()
                .crossFade()
                .into(holder.ivPhoto);


    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder  {
        public TextView tvName;
        public TextView tvEmail;
        public ImageView ivPhoto;

        public UserViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.tv_title);
            tvEmail = (TextView) v.findViewById(R.id.tv_subtitle);
            ivPhoto = (ImageView) v.findViewById(R.id.iv_photo);
        }
    }
}
