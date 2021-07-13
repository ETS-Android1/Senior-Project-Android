package Model.database;

public class BostonFitnessDBSchema {


    public static class AccountsTable {

        public static final String NAME = "UserAccounts";

        public static class Columns {
            public static final String uuid = "uuid";
            public static final String username = "username";
            public static final String password = "password";
            public static final String email = "email";
        }
    }
}
