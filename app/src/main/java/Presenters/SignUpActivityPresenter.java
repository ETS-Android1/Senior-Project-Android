package Presenters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import Model.Register;
import Model.User;
import Model.database.BostonFitnessBaseHelper;
import Model.database.BostonFitnessDBSchema;
import Model.database.BostonFitnessSQLiteDatabase;

public class SignUpActivityPresenter {

    private View signUpView;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private BostonFitnessSQLiteDatabase bostonFitnessSQLiteDatabase;
    private Register register;


    public SignUpActivityPresenter(View signUpView, Context context) {
        this.signUpView = signUpView;
        this.context = context;
        openConnectionToDatabase();
    }

    public void openConnectionToDatabase(){
        sqLiteDatabase = new BostonFitnessBaseHelper(this.context).getWritableDatabase();
        bostonFitnessSQLiteDatabase = new BostonFitnessSQLiteDatabase(this.sqLiteDatabase);
        register = new Register(this.context);


    }

    public boolean isFieldsEmpty(String userName, String firstName, String lastName, String email, String password, String confirmPassword){
        return userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty();
    }

    //https://developer.android.com/training/data-storage/sqlite
    //https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase
    //https://stackoverflow.com/questions/46530683/how-to-pass-string-variables-in-sqlite-query-in-android-project
    //https://www.sqlitetutorial.net/sqlite-select/
    // Checks if the inputted username already exists in the database.
    public boolean checkUserName(String userName){
        return register.checkUserNameExists(userName);
    }

    public boolean checkEmail(String email){
        return register.checkUserEmailExists(email);
    }

    //check if the password and re-entered password are the same
    public boolean checkPassword(String password1, String password2){
        if (password1.equals(password2)){
            return true;
        }
        return false;
    }

    public void insertUser(User user){
        bostonFitnessSQLiteDatabase.insertUser(user);
    };

    public interface View {

    }
}
