package samorganist.com.quranpro2.Home;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import samorganist.com.quranpro2.Helpers.SqlLiteHelper;
import samorganist.com.quranpro2.Model.Suraat;
import samorganist.com.quranpro2.R;
import samorganist.com.quranpro2.Utils.Notify;
import samorganist.com.quranpro2.Utils.SectionStateAdapter;
import samorganist.com.quranpro2.Utils.SectionStatePagerAdapter;
import samorganist.com.quranpro2.Utils.SuratListAdapter;

import static samorganist.com.quranpro2.Utils.Notify.*;

/**
 * Created by Samorganist on 25/07/2018.
 */
public class NoteFragment extends Fragment {
    View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Notify.L("Note Fragment","On Create");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Notify.L("Note Fragment","On Create view");
        view=inflater.inflate(R.layout.fragment_note,container,false) ;
        SectionStateAdapter adapter=new SectionStateAdapter(getChildFragmentManager());
        adapter.addFragment(new SuratListFragment(),"Suratlist");
        adapter.addFragment(new SignetsListFragment(),"juzuzuz");
        adapter.addFragment(new JuzzListFragment(),"juzzFragment");

        ViewPager viewPager=view.findViewById(R.id.containernote);
        viewPager.setAdapter(adapter);
        TabLayout tableLayout= view.findViewById(R.id.surattabs);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.getTabAt(0).setIcon(R.drawable.ic_your_voice);
        tableLayout.getTabAt(1).setIcon(R.drawable.ic_home);
        tableLayout.getTabAt(2).setIcon(R.drawable.ic_to_do_later);


        return view;
    }

}