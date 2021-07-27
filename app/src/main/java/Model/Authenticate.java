package Model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import Model.database.BostonFitnessSQLiteDatabase;


public class Authenticate {

    private Context context;
    private BostonFitnessSQLiteDatabase bostonFitnessSQLiteDatabase;
    private User user;

    public Authenticate(Context context, BostonFitnessSQLiteDatabase sqLiteDatabase) {
        // Generate unique identifier (Note: wouldn't there be duplicate IDs with low % chance?)
        this.context = context;
        this.bostonFitnessSQLiteDatabase = sqLiteDatabase;
    }


    public boolean verifyAccount(String username, String password){
        if(!(isUserNameOrPassWordEmpty(username, password))){
            if(checkIfUserExists(username, password) != null){
               return true;
            }
        }
        return false;
    };

    public User checkIfUserExists(String username, String password){ ;
        return this.user = bostonFitnessSQLiteDatabase.getUser(username, password);
    }

    public boolean isUserNameOrPassWordEmpty(String username, String password){
        return username.isEmpty() || password.isEmpty();
    }

}
