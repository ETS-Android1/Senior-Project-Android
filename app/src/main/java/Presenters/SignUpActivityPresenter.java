package Presenters;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import Model.Register;
import Model.User;
import Model.database.BostonFitnessBaseHelper;
import Model.database.BostonFitnessSQLiteDatabase;

public class SignUpActivityPresenter {

    private View signUpView;
    private Context context;
    private BostonFitnessSQLiteDatabase bostonFitnessSQLiteDatabase;
    private Register register;


    public SignUpActivityPresenter(View signUpView,Context context) {
        this.signUpView = signUpView;
        this.context = context;
        this.register = new Register(this.context);
        openConnectionToDatabase();
    }

    public void openConnectionToDatabase(){
        bostonFitnessSQLiteDatabase = new BostonFitnessSQLiteDatabase(new BostonFitnessBaseHelper(this.context).getWritableDatabase());
    }

    public boolean isFieldsEmpty(String userName, String firstName, String lastName, String email, String password, String confirmPassword){
        return userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty();
    }

    /** Check if user exists ***/
    public boolean checkIfUserExists(String username){
        return register.checkUserNameExists(username);
    }

    /** Check if user email exists **/
    public boolean checkIfUserEmailExists(String userEmail) {
        return register.checkUserEmailExists(userEmail);
    }

    public boolean verifyUserPasswordMatch(String userPassword, String userConfirmedPassword){
        return register.checkIfPasswordsMatch(userPassword, userConfirmedPassword);
    }

    public void insertUser(User user){
        bostonFitnessSQLiteDatabase.insertUser(user);
    };

    public void redirectUserToStartingFragment(){

    }




    public interface View {

    }
}
