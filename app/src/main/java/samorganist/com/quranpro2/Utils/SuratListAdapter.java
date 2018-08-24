package samorganist.com.quranpro2.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import samorganist.com.quranpro2.Home.BookReaderActivity;
import samorganist.com.quranpro2.Home.HomeActivity;
import samorganist.com.quranpro2.Model.Suraat;
import samorganist.com.quranpro2.R;

/**
 * Created by Samorganist on 22/08/2018.
 */

public class SuratListAdapter extends RecyclerView.Adapter<SuratListAdapter.MyViewHolder> {

    Context mcontext;
    List<Suraat> msurrats;


    public SuratListAdapter(Context mcontext, List<Suraat> msurrats) {
        this.mcontext = mcontext;
        this.msurrats = msurrats;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        view=layoutInflater.inflate(R.layout.sourat_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.suratposition.setText(String.valueOf(msurrats.get(position).getPosition()));
        holder.surratname.setText(msurrats.get(position).getName());
        holder.surrat_versets.setText(String.valueOf(msurrats.get(position).getNumber_versets()));
        if(msurrats.get(position).isMakkah()){
            holder.surratorigine.setText("Surrat Makia");
        }else{
            holder.surratorigine.setText("Surrat Madnia");
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify.showtoast(msurrats.get(position).getName()+"  "+String.valueOf(msurrats.get(position).getPosition()),mcontext);
                Intent i= new Intent(mcontext,BookReaderActivity.class);
                i.putExtra("SuraPosition",(msurrats.get(position).getStartpage()));
                mcontext.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return msurrats.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView suratposition;
        TextView surratname;
        TextView surrat_versets;
        TextView surratorigine;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.souratcardid);
            suratposition=itemView.findViewById(R.id.sura_number);
            surratname=itemView.findViewById(R.id.sura_name);
            surrat_versets=itemView.findViewById(R.id.sura_number_ayat);
            surratorigine=itemView.findViewById(R.id.surrat_details);
        }
    }
}
