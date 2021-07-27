package Presenters;

import android.content.Context;

import Model.Authentication;
import Model.Authenticate;
import Model.User;
import Model.database.BostonFitnessBaseHelper;
import Model.database.BostonFitnessSQLiteDatabase;

public class LoginActivityPresenter {

    private View logInView;
    private Authenticate login;
    private Context context;
    private Authenticate authenticate;
    private BostonFitnessSQLiteDatabase bostonFitnessSQLiteDatabase;

    public LoginActivityPresenter(View logInView, Context context) {
        this.logInView = logInView;
        this.login = new Authenticate(context,bostonFitnessSQLiteDatabase);
        this.context = context;
        openConnectionToDatabase();


    }

    public boolean checkLogin(String username, String password){
        this.authenticate = new Authenticate(this.context,bostonFitnessSQLiteDatabase);
        return authenticate.verifyAccount(username, password);
    }

    public void openConnectionToDatabase(){
        this.bostonFitnessSQLiteDatabase = new BostonFitnessSQLiteDatabase(new BostonFitnessBaseHelper(this.context).getWritableDatabase());
    }

    public interface View {

    }
}
