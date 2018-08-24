package samorganist.com.quranpro2.Home;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import samorganist.com.quranpro2.Helpers.SqlLiteHelper;
import samorganist.com.quranpro2.R;
import samorganist.com.quranpro2.Utils.BottomNavigationViewHelper;
import samorganist.com.quranpro2.Utils.SectionStatePagerAdapter;

public class HomeActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM=1;
    private Context mContext=HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupBottomNavigationView();
        setupViewPager();
    }

    /**
     * Responsible for adding the three tabs on home screen
     */
    void setupViewPager(){
        SectionStatePagerAdapter adapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RecodingFragment(),"Recording");
        adapter.addFragment(new NoteFragment(),"Notes");
        ViewPager viewPager=findViewById(R.id.container);
        viewPager.setAdapter(adapter);
        TabLayout tableLayout= findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.getTabAt(0).setIcon(R.drawable.ic_your_voice);
        tableLayout.getTabAt(1).setIcon(R.drawable.ic_to_do_later);
    }

    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomnavigationviewEx=findViewById(R.id.bottomViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomnavigationviewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomnavigationviewEx);
        Menu menu=bottomnavigationviewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
