package Presenters;

import android.content.Context;

import Model.Profile;
import Model.database.BostonFitnessBaseHelper;
import Model.database.BostonFitnessSQLiteDatabase;

public class ProfileActivityPresenter {
    private View profileView;
    private Context context;
    private BostonFitnessSQLiteDatabase bostonFitnessSQLiteDatabase;
    private Profile profile;

    public ProfileActivityPresenter(ProfileActivityPresenter.View profileView, Context context) {
        this.profileView = profileView;
        this.context = context;
        this.profile = new Profile(this.context);
        openConnectionToDatabase();
    }

    public void openConnectionToDatabase(){
        bostonFitnessSQLiteDatabase = new BostonFitnessSQLiteDatabase(new BostonFitnessBaseHelper(this.context).getWritableDatabase());
    }

    public interface View {
    }
}
