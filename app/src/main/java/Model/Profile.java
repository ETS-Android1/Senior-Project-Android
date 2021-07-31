package Model;

import android.content.Context;

import java.util.UUID;

public class Profile {
    private UUID userID; //friend code?
    private String firstName;
    private String lastName;
    private String aboutMe;
    private String location;
    private int age;
    private int heightFeet;
    private int heightInches;
    private String gender;
    private int weightLB;
    private String goal;
    private String diet;
    private String likes;

    //constructor?
    public Profile(Context context) {
    }

    public UUID getUserID() {
        return userID;
    }
    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAboutMe() { return aboutMe; }
    public void setAboutMe(String aboutMe) { this.aboutMe = aboutMe; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getHeightFeet() { return heightFeet; }
    public void setHeightFeet(int heightFeet) { this.heightFeet = heightFeet; }

    public int getHeightInches() { return heightInches; }
    public void setHeightInches(int heightInches) { this.heightInches = heightInches; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    public String getDiet() { return diet; }
    public void setDiet(String diet) { this.diet = diet; }

    public String getLikes() { return likes; }
    public void setLikes(String likes) { this.likes = likes; }

    public int getWeightLB() { return weightLB; }
    public void setWeightLB(int weightLB) { this.weightLB = weightLB; }


}
