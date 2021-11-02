package com.dedsec995.speedtime.Background;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dedsec995.speedtime.Model.Post;
import com.dedsec995.speedtime.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    Context context;
    String Veri;
    String Alt;
    private List<Post> items;

    public PostAdapter(Context context, List<Post> items) {
        this.context = context;
        this.items = items;
    }

    @androidx.annotation.NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.post_item,viewGroup,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull PostViewHolder postViewHolder, int i) {
        Post item = items.get(i);
        postViewHolder.Display_Vin.setText(item.getVin());
        postViewHolder.Display_Verified.setText(item.getVerified());
        String Speedy = Integer.toString(item.getSpeed());
        postViewHolder.Display_Speed.setText(Speedy);
        postViewHolder.Display_Alert.setText(item.getAlert());
        postViewHolder.Display_TimeStamp.setText(item.getTimest().toString());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView Display_Vin;
        TextView Display_Verified;
        TextView Display_Speed;
        TextView Display_Alert;
        TextView Display_TimeStamp;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            Display_Vin = (TextView) itemView.findViewById(R.id.Display_Vin);
            Display_Verified = (TextView) itemView.findViewById(R.id.Display_Verified);
            Display_Speed = (TextView) itemView.findViewById(R.id.Display_Speed);
            Display_Alert = (TextView) itemView.findViewById(R.id.Display_Alert);
            Display_TimeStamp = (TextView) itemView.findViewById(R.id.Display_TimeStamp );
        }
    }
}
