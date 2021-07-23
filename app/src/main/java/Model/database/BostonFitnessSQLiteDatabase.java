package Model.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import Model.User;

public class BostonFitnessSQLiteDatabase {

    SQLiteDatabase sqLiteDatabase;

    public BostonFitnessSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    private static ContentValues putContentValues(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.UUID, user.getUserID().toString());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.USERNAME, user.getUserName());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.FIRSTNAME, user.getFirstName());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.LASTNAME, user.getLastName());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.EMAIL, user.getEmail());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD, user.getPassword());
        return contentValues;
    }


    public void insertUser(User user){
        ContentValues contentValues = putContentValues(user);
        sqLiteDatabase.insert(BostonFitnessDBSchema.AccountsTable.NAME, null, contentValues);
    }
}
