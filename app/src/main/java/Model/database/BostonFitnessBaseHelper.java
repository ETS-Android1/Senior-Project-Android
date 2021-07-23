package Model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Model.User;

public class BostonFitnessBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "bostonFitnessBase.db-journal";


    public BostonFitnessBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + BostonFitnessDBSchema.AccountsTable.NAME + "(" +
                "_id integer primary key autoincrement," +
                BostonFitnessDBSchema.AccountsTable.Columns.UUID + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.USERNAME + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.FIRSTNAME + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.LASTNAME + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.EMAIL + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
