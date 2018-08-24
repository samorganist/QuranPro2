package samorganist.com.quranpro2.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import samorganist.com.quranpro2.Anachid.AnachidActivity;
import samorganist.com.quranpro2.Duaa.DuaaActivity;
import samorganist.com.quranpro2.Home.HomeActivity;
import samorganist.com.quranpro2.R;

/**
 * Created by Samorganist on 6/07/2018.
 */

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";
    public static void setupBottomNavigationView(BottomNavigationViewEx bottomnavigationviewEx){
        Log.d(TAG, "setupBottomNavigationView: setting up Bottom Navigation view");
        bottomnavigationviewEx.enableAnimation(false);
        bottomnavigationviewEx.enableShiftingMode(false);
        bottomnavigationviewEx.enableItemShiftingMode(false);
        bottomnavigationviewEx.setTextVisibility(false);

    }
    //We reference the context in this methode and we call context.startActivity(intent1); because this class doesnt
    // have any context it doesnt know where it's comming from so we need to make sure to refernce the context
    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.anachid :
                        Intent intent1=new Intent(context, AnachidActivity.class);
                        context.startActivity(intent1);

                        break;
                    case R.id.duaa:
                        Intent intent2=new Intent(context, DuaaActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.home:
                        Intent intent3=new Intent(context, HomeActivity.class);
                        context.startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
