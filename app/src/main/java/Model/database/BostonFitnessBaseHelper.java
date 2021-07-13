package Model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

public class BostonFitnessBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "bostonFitnessBase.db";

    public BostonFitnessBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + BostonFitnessDBSchema.AccountsTable.NAME + "(" +
                "_id integer primary key autoincrement," +
                BostonFitnessDBSchema.AccountsTable.Columns.uuid + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.username + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.password + ", " +
                BostonFitnessDBSchema.AccountsTable.Columns.email + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
