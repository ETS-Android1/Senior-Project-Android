package Presenters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import Model.User;
import Model.database.BostonFitnessBaseHelper;
import Model.database.BostonFitnessSQLiteDatabase;

public class SignUpActivityPresenter {

    private View signUpView;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private BostonFitnessSQLiteDatabase bostonFitnessSQLiteDatabase;

    public SignUpActivityPresenter(View signUpView, Context context) {
        this.signUpView = signUpView;
        this.context = context;
        openConnectionToDatabase();
    }

    public void openConnectionToDatabase(){
        sqLiteDatabase = new BostonFitnessBaseHelper(this.context).getWritableDatabase();
        bostonFitnessSQLiteDatabase = new BostonFitnessSQLiteDatabase(this.sqLiteDatabase);
    }

    public boolean isFieldsEmpty(String userName, String firstName, String lastName, String email, String password, String confirmPassword){
        return userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty();
    }

    public void insertUser(User user){
        bostonFitnessSQLiteDatabase.insertUser(user);
    };

    public interface View {

    }
}
