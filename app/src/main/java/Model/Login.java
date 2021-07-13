package Model;

import android.content.Context;
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
    public boolean validate(String username, String password) {
        if (username.equals(this.getUsername()) && password.equals(this.getPassword())) {
            return true;
        }
        return false;
    }

}
