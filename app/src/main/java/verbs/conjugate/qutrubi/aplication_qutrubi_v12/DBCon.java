package verbs.conjugate.qutrubi.aplication_qutrubi_v12;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

// import android.database.sqlite.SQLiteOpenHelper;


public class DBCon extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BDD.sqlite";

    public DBCon(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("create table IF NOT EXISTS history(id INTEGER PRIMARY KEY AUTOINCREMENT,verb varchar(10) ,date varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table IF EXISTS history");
        onCreate(db);

    }



    public void insert(String verbs  ,String date){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();




    cv.put("verb", verbs);
    cv.put("date", String.valueOf(date));


    db.insert("history", null, cv);

    }

    public void delete() {
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cr= db.rawQuery("select id from history", null);
int[] t1 = new int[20];int i=0;

        if(cr!=null) {
            if (cr.moveToFirst()) {
                do {
                t1[i]=  cr.getInt(0);
                    i++;
                } while (cr.moveToNext());
            }
        }

        String a = "delete from history where id ='"+t1[0]+ "'";

        db.execSQL(a);
    }

    public ArrayList arrlist(){
        ArrayList al=new ArrayList<verbs_itm>();

        SQLiteDatabase db = this.getReadableDatabase();
       // SQLiteDatabase db=this.getWritableDatabase();
        Cursor cr= db.rawQuery("select * from history",null);

        if(cr!=null) {
            if (cr.moveToFirst()) {
                do {
                    verbs_itm in=new verbs_itm();
        //    al.add(cr.getString(cr.getColumnIndex("verb")));
          in.setVerbs(cr.getString(1));
         in.setDate(cr.getString(2));

          //  al.add(cr.getString(cr.getColumnIndex("date")));
            al.add(in);

                } while (cr.moveToNext());
            }
        }


        return al;
    }

   /* public ArrayList arrcherch(String nom){
        ArrayList al=new ArrayList();
       // SQLiteDatabase db=this.getWritableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr= db.rawQuery("select * from dd where Nom like '"+nom+"%'",null);
        cr.moveToFirst();
        while(cr.isAfterLast()==false){
            al.add(cr.getString(cr.getColumnIndex("Nom")));
            cr.moveToNext();
        }

        return al;
    }*/




}