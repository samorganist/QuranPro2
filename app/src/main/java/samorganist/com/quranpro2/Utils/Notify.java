package samorganist.com.quranpro2.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Samorganist on 23/08/2018.
 */

 public  class Notify {
    static public void showtoast(String message, Context context){
        Toast t=Toast.makeText(context,message,Toast.LENGTH_SHORT);
        t.show();
    }
    static public void L(String tag,String message){
        Log.d(tag,message);


    }
}
