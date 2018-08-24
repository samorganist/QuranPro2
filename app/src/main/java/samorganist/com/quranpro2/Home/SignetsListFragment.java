package samorganist.com.quranpro2.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import samorganist.com.quranpro2.R;
import samorganist.com.quranpro2.Utils.Notify;
import samorganist.com.quranpro2.Utils.SectionStatePagerAdapter;

/**
 * Created by Samorganist on 23/08/2018.
 */

public class SignetsListFragment extends Fragment {
    View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Notify.L("Signets Fragment","On Create");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Notify.L("Signets Fragment","On Create view");
        view=inflater.inflate(R.layout.fragment_singets,container,false) ;
        return view;
    }

}
