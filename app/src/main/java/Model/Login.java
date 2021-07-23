package Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.provider.ContactsContract;

import java.util.UUID;

import Model.database.BostonFitnessBaseHelper;


public class Login {
    private UUID mId;
    private String mUsername;
    private String mPassword;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public Login(Context context) {
        // Generate unique identifier (Note: wouldn't there be duplicate IDs with low % chance?)
        this.mId = UUID.randomUUID();
        this.context = context;
        openConnectionToDatabase();
    }

    public void openConnectionToDatabase(){
        sqLiteDatabase = new BostonFitnessBaseHelper(this.context).getWritableDatabase();
    }

    public UUID getId(){
        return mId;
    }

    public String getUsername(){
        return mUsername;
    }

    public String setUsername(String username){    // user inputted info
        return mUsername = username;
    }

    public String getPassword(){
        return mPassword;
    }

    public String setPassword(String password){    // user inputted info
        return mPassword = password;
    }



    // returns true if the there is a matching username and password
    public boolean checkCredentials(){
        String[] arguments = new String[]{mUsername};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT password FROM UserAccounts WHERE username LIKE ?", arguments);
        if (cursor.moveToFirst()) {     //cursor needs moveToFirst in order to for getString to work...
            String cursorValue = cursor.getString(cursor.getColumnIndex("password"));
            System.out.println(cursorValue);
            if (cursorValue.equals(getPassword())){
                return true;
            }
        }
        cursor.close();
        return false;
    }


}
