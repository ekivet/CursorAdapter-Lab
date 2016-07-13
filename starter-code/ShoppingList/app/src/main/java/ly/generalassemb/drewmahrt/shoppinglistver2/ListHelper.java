package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erickivet on 7/12/16.
 */
public class ListHelper extends SQLiteOpenHelper {
    private static ListHelper sInstance;

    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "groceries";
    private static final String TABLE_NAME = "GROCERY_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "ITEM_NAME";
    public static final String COL_DESC = "DESCRIPTION";
    public static final String COL_PRICE = "PRICE";
    public static final String COL_TYPE = "TYPE";

    public static final String TABLE_STRING = "CREATE TABLE" + TABLE_NAME + "(" +
            COL_ID + "INTEGER PRIMARY KEY," +
            COL_NAME + "NAME," +
            COL_DESC + "TEXT," +
            COL_PRICE + "TEXT," +
            COL_TYPE + "TEXT)";

    public static ListHelper getInstance(Context context){
        if (sInstance == null)
            sInstance = new ListHelper(context);
        return sInstance;
    }

    private ListHelper (Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(TABLE_STRING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(TABLE_NAME);
    }

    public Cursor getNames(){
        SQLiteDatabase db = this.getReadableDatabase();

        return db.query(TABLE_NAME,null,null,null,null,null,null,null);
    }


}
