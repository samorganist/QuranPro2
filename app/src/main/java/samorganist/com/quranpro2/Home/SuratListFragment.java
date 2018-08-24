package samorganist.com.quranpro2.Home;

import android.content.Context;
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
import samorganist.com.quranpro2.Utils.SectionStatePagerAdapter;
import samorganist.com.quranpro2.Utils.SuratListAdapter;

/**
 * Created by Samorganist on 23/08/2018.
 */

public class SuratListFragment extends Fragment {
    List<Suraat> suraats;
    RecyclerView recyclerView;
    View view;
    SqlLiteHelper sqLiteOpenHelper;
    Context mContext;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Notify.L("Surat Fragment","On Create");
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);
        suraats=new ArrayList<>();
        mContext=getActivity();
        sqLiteOpenHelper=new SqlLiteHelper(mContext);
        File database=mContext.getDatabasePath(SqlLiteHelper.DBNAME);
        if (false==database.exists()){
            sqLiteOpenHelper.getReadableDatabase();
            if(copydatabase(getContext())) {
                Notify.showtoast("Coppying databse Succeed", getContext());
            }else {
                Notify.showtoast("Coppying databse failed", getContext());
            }
        }else{
            if(suraats.size()==0){
                populateSurat();
            }
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragmentsuratlist,container,false) ;
        recyclerView=view.findViewById(R.id.surat_list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SuratListAdapter recyclerviewadapter=new SuratListAdapter(getContext(),suraats);
        recyclerView.setAdapter(recyclerviewadapter);
        Notify.L("Surat Fragment","On Create View ");

        return view;
    }

    private void populateSurat() {
        Notify.L("Surat Fragment","Populating  ");

        //suraats.add(new Suraat(1,"fatiha","fatiha","ff",true,25,2));
        suraats=sqLiteOpenHelper.getSuratList();
    }
    private boolean copydatabase(Context context){
        try {
            InputStream inputStream=context.getAssets().open(SqlLiteHelper.DBNAME);
            String outfilename=SqlLiteHelper.DBLOCATION+SqlLiteHelper.DBNAME;
            OutputStream outputStream=new FileOutputStream(outfilename);
            byte[] buff=new byte[1024];
            int length;
            while ((length=inputStream.read(buff))>0){
                outputStream.write(buff,0,length);
            }
            outputStream.flush();
            Notify.L("Note Fragment ", "copying database succes" );
            return true;
        }catch (Exception e){
            e.printStackTrace();
            Notify.L("Note Fragment ", "copying database failed" );
            return false;
        }
    }
}
