package Model;

import android.location.Address;
import android.provider.ContactsContract;

import java.util.UUID;


public class Login {
    private UUID mId;
    private String mUsername;
    private String mPassword;

    public Login() {
        // Generate unique identifier (Note: wouldn't there be duplicate IDs with low % chance?)
        UUID.randomUUID();
    }

    public UUID getmId(){
        return mId;
    }

    public String getmUsername(){
        return mUsername;
    }

    public String setmUsername(String username){    // user inputted info
        return mUsername = username;
    }

    public String getmPassword(){
        return mPassword;
    }

    public String setmPassword(String password){    // user inputted info
        return mPassword = password;
    }


}
