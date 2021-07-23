package Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.provider.ContactsContract;

import java.util.UUID;

import Model.database.BostonFitnessBaseHelper;


public class Register {
    private UUID mId;
    private String mUsername;
    private String mPassword;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public Register(Context context) {
        // Generate unique identifier (Note: wouldn't there be duplicate IDs with low % chance?)
        this.mId = UUID.randomUUID();
        this.context = context;
        openConnectionToDatabase();
    }

    public void openConnectionToDatabase(){
        sqLiteDatabase = new BostonFitnessBaseHelper(this.context).getWritableDatabase();
    }

    public boolean checkUserNameExists(String entryName){
        String[] arguments = new String[]{entryName};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT username FROM UserAccounts WHERE username LIKE ?", arguments);
        //System.out.println(cursor.getCount());
        if (cursor.getCount() != 0){ // if an entry exists within the db, return true
            return true;
        }
        cursor.close();
        return false;
    }

    public boolean checkUserEmailExists(String entryName){
        String[] arguments = new String[]{entryName};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT email FROM UserAccounts WHERE email LIKE ?", arguments);
        //System.out.println(cursor.getCount());
        if (cursor.getCount() != 0){ // if an entry exists within the db, return true
            return true;
        }
        cursor.close();
        return false;
    }


    // returns true if the there is a matching username and password
    /**
    public boolean validate(String username, String password) {
        if (username.equals(this.getUsername()) && password.equals(this.getPassword())) {
            return true;
        }
        return false;
    }
     **/

}