package samorganist.com.quranpro2.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import samorganist.com.quranpro2.Model.Reciter;
import samorganist.com.quranpro2.R;

/**
 * Created by Samorganist on 22/08/2018.
 */

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.MyViewHolder> {

    Context mcontext;
    List<Reciter> mreciters;


    public Recyclerviewadapter(Context mcontext, List<Reciter> mreciters) {
        this.mcontext = mcontext;
        this.mreciters = mreciters;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        view=layoutInflater.inflate(R.layout.reciter_card_profile,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.recitername.setText(mreciters.get(position).getName());
        holder.reciterimage.setImageResource(mreciters.get(position).getThumbnail());
        Glide.with(mcontext)
                .load(mreciters.get(position).getThumbnail())
                .into(holder.reciterimage);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify.showtoast(mreciters.get(position).getName(),mcontext);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mreciters.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView recitername;
        ImageView reciterimage;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.reciter_card);
            recitername=itemView.findViewById(R.id.reciter_name);
            reciterimage=itemView.findViewById(R.id.reciter_picture);

        }
    }
}
