package Presenters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import Model.Login;
import Model.Register;
import Model.database.BostonFitnessSQLiteDatabase;

public class LoginActivityPresenter {

    private View logInView;
    private Login login;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private BostonFitnessSQLiteDatabase bostonFitnessSQLiteDatabase;


    public LoginActivityPresenter(View logInView, Context context) {
        this.logInView = logInView;
        this.login = new Login(context);
        this.context = context;
    }

    public String userGetUsername(){
        return login.getUsername();
    }

    public String userGetPassword(){
        return login.getPassword();
    }

    public void userSetUsername(String username){
        login.setUsername(username);
    }

    public void userSetPassword(String password){
        login.setPassword(password);
    }

    public boolean isUserNameOrPassWordEmpty(String username, String password){
        return username.isEmpty() || password.isEmpty();
    }

    // This method calls validate in the Log In class to validate if user matches
    public boolean checkCredentials(String username, String password) {
        login.setUsername(username);
        login.setPassword(password);
        return login.checkCredentials();
    }

   public interface View {

    }
}
