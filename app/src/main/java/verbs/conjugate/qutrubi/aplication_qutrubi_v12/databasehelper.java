package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by ahmed and redouane on 06/04/16.
 */


public class databasehelper extends SQLiteOpenHelper {
    private  static final String DB_PATH ="/data/data/verbs.conjugate.qutrubi.aplication_qutrubi_v12/";
    private  static final String DB_NAME ="data_verbs_v1.sqlite";
    private Context mcontext;
    private SQLiteDatabase mdb;

    public databasehelper(Context context) {
        super(context, DB_NAME , null, 1);
        this.mcontext = context;
    }

   @Override
    public void onCreate(SQLiteDatabase db) { }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public boolean chekdatabase(){

        try {
            String path=DB_PATH+DB_NAME;
            mdb=SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);


        }catch (SQLiteException e){

        }
        if(mdb != null) mdb.close();
        return mdb != null ? true : false;
    }

    public void copyDataBase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = mcontext.getAssets().open(DB_NAME);
        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        mdb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public Cursor quer(String qur) throws SQLiteException{
        return mdb.rawQuery(qur,null);
    }
    @Override
    public synchronized void close() {
        if(mdb != null)
            mdb.close();

        super.close();
    }

    public void chekandcopy(){
        boolean exist = chekdatabase();
        if(exist){
            Log.d("MainActivity", "database exist ");

        }else{
            this.getReadableDatabase();
            try{
                copyDataBase();
            }catch (IOException es){
                Log.d("MainActivity", "Error   of copy" );

            }
        }
    }
}

