package Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import Model.User;

public class BostonFitnessCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public BostonFitnessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

}
