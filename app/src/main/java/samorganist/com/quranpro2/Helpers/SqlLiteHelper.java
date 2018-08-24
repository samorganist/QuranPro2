package samorganist.com.quranpro2.Helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import samorganist.com.quranpro2.Model.Suraat;
import samorganist.com.quranpro2.Utils.Notify;

/**
 * Created by Samorganist on 23/08/2018.
 */

public class SqlLiteHelper extends SQLiteOpenHelper{
    public static final String DBNAME="Quran.sqlite";
    public static final String DBLOCATION="/data/data/samorganist.com.quranpro2/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public SqlLiteHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void openDatabase(){

        String dbPath=mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase!=null && mDatabase.isOpen()){
            return;
        }

        mDatabase=SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase(){

        if(mDatabase!=null){
            mDatabase.close();
        }

    }
    public List<Suraat> getSuratList(){
        Suraat suraat;
        List<Suraat> suraatList;
        suraatList=new ArrayList<>();
        openDatabase();
        Cursor q=mDatabase.rawQuery("SELECT * FROM SuratList",null);
        q.moveToFirst();
        while (!q.isAfterLast()){
            boolean makkah;
            if(q.getInt(5)==1)makkah=true;
            else makkah=false;
            suraat=new Suraat(q.getPosition()+1,q.getString(0),q.getString(1),q.getString(2),makkah,q.getInt(4),q.getInt(6));
            suraatList.add(suraat);
            q.moveToNext();
            Notify.L("Db Helper :","Getting Sql Request ");

           // System.out.println(suraat.toString());
        }
        q.close();
        closeDatabase();
        return suraatList;
    }
}
