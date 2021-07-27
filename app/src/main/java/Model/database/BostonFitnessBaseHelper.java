package Model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Model.Authenticate;

public class BostonFitnessBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DATABASE_NAME = "bostonFitnessBase.db";

//    public static String CHECK_USER_EXISTS = " SELECT  " +
//            BostonFitnessDBSchema.AccountsTable.Columns.USERNAME + ", " +
//            BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD +
//            " FROM " +
//            BostonFitnessDBSchema.AccountsTable.USER_ACCOUNTS_TABLE_NAME + " WHERE " +
//            BostonFitnessDBSchema.AccountsTable.Columns.USERNAME + " = " +
//            Authenticate.setUserNameToQuery() + " AND " +
//            BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD + " = " +
//            Authenticate.setUserPasswordToQuery();

    private static final String CREATE_USER_ACCOUNTS_TABLE = "create table " + BostonFitnessDBSchema.AccountsTable.USER_ACCOUNTS_TABLE_NAME + "(" +
            BostonFitnessDBSchema.AccountsTable.Columns.UUID + ", " +
            BostonFitnessDBSchema.AccountsTable.Columns.USERNAME + " PRIMARY KEY, " +
            BostonFitnessDBSchema.AccountsTable.Columns.FIRSTNAME + ", " +
            BostonFitnessDBSchema.AccountsTable.Columns.LASTNAME + ", " +
            BostonFitnessDBSchema.AccountsTable.Columns.EMAIL + ", " +
            BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD + ")";

    public BostonFitnessBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_ACCOUNTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static String getUserQuery(String userName, String userPassword){
        return "SELECT  *" +
//                BostonFitnessDBSchema.AccountsTable.Columns.USERNAME + ", " +
//                BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD +
                " FROM " +
                BostonFitnessDBSchema.AccountsTable.USER_ACCOUNTS_TABLE_NAME + " WHERE " +
                BostonFitnessDBSchema.AccountsTable.Columns.USERNAME + " = '" +
                userName+ "' AND " +
                BostonFitnessDBSchema.AccountsTable.Columns.PASSWORD + " = '" +
                userPassword + "'";
    }


}
