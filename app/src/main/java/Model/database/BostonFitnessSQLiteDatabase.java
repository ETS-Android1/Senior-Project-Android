package Model.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import Model.Authenticate;
import Model.User;

public class BostonFitnessSQLiteDatabase {

    /**
     * Member Fields
     **/
    private SQLiteDatabase sqLiteDatabase;
    private BostonFitnessCursorWrapper bostonFitnessCursorWrapper;
    String userName, firstName, lastName, email, password, query;


    /**
     * CONSTANT QUERY STATEMENTS
     **/

    public BostonFitnessSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    private static ContentValues getContentValuesForInsert(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.UUID, user.getUserID().toString());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.USERNAME, user.getUserName());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.FIRSTNAME, user.getFirstName());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.LASTNAME, user.getLastName());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.EMAIL, user.getEmail());
        contentValues.put(BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD, user.getPassword());
        return contentValues;
    }

    public void insertUser(User user) {
        ContentValues contentValues = getContentValuesForInsert(user);
        sqLiteDatabase.insert(BostonFitnessDBSchema.AccountsTable.USER_ACCOUNTS_TABLE_NAME, null, contentValues);
    }

    public User getUser(String userName, String userPassword) {
        try {
            query = BostonFitnessBaseHelper.getUserQuery(userName, userPassword);
            Cursor cursor = sqLiteDatabase.rawQuery(query, null );

            while (cursor.moveToNext()) {
                this.userName = cursor.getString(cursor.getColumnIndex(BostonFitnessDBSchema.AccountsTable.Columns.USERNAME));
                this.firstName = cursor.getString(cursor.getColumnIndex(BostonFitnessDBSchema.AccountsTable.Columns.FIRSTNAME));
                this.lastName = cursor.getString(cursor.getColumnIndex(BostonFitnessDBSchema.AccountsTable.Columns.LASTNAME));
                this.email = cursor.getString(cursor.getColumnIndex(BostonFitnessDBSchema.AccountsTable.Columns.EMAIL));
                this.password = cursor.getString(cursor.getColumnIndex(BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD));
            }

        } catch (SQLiteException exception) {
            exception.getMessage();
        }

        return new User(this.userName, this.firstName, this.lastName, this.email, this.password);
    }

}
