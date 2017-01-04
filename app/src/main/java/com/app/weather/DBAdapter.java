package com.app.weather;

import android.content.Context;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */
public class DBAdapter {

    private final Context context;
    private final DatabaseHelper databaseHelper;

    public DBAdapter(Context context, DatabaseHelper databaseHelper) {
        this.context = context;
        this.databaseHelper = databaseHelper;
    }

    public static class DatabaseHelper {
        public DatabaseHelper(Context context) {

        }
    }

}
