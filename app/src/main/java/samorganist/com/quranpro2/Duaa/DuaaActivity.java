package samorganist.com.quranpro2.Duaa;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import samorganist.com.quranpro2.R;
import samorganist.com.quranpro2.Utils.BottomNavigationViewHelper;

/**
 * Created by Samorganist on 25/07/2018.
 */

public class DuaaActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM=2;
    private Context mContext=DuaaActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douaa);
        setupBottomNavigationView();
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
