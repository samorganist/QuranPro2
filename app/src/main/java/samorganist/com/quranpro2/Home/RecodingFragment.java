package samorganist.com.quranpro2.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import samorganist.com.quranpro2.Model.Reciter;
import samorganist.com.quranpro2.R;
import samorganist.com.quranpro2.Utils.Recyclerviewadapter;

/**
 * Created by Samorganist on 25/07/2018.
 */

public class RecodingFragment extends Fragment {
    List<Reciter> reciters;
    RecyclerView recyclerView;
    View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_record,container,false) ;
        recyclerView=view.findViewById(R.id.recyler_reciters);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        Recyclerviewadapter recyclerviewadapter=new Recyclerviewadapter(getContext(),reciters);
        recyclerView.setAdapter(recyclerviewadapter);
        return view;
    }


    private void init(){
        reciters=new ArrayList<>();
        reciters.add(new Reciter("Affasy",R.drawable.affasy));
        reciters.add(new Reciter("Ghamedy",R.drawable.ghamidi));
        reciters.add(new Reciter("Affasy",R.drawable.affasy));
        reciters.add(new Reciter("Affasy",R.drawable.affasy));
        reciters.add(new Reciter("Affasy",R.drawable.affasy));
        reciters.add(new Reciter("Ghamedy",R.drawable.ghamidi));

    }
}
