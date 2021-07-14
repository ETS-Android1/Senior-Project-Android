package Model.database;

public class BostonFitnessDBSchema {


    public static class AccountsTable {

        public static final String NAME = "UserAccounts";

        public static class Columns {
            public static final String UUID = "uuid";
            public static final String USERNAME = "username";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
            public static final String PASSWORD = "password";
            public static final String EMAIL = "email";
        }
    }
}
