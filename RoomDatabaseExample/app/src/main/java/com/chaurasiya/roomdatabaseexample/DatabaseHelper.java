package com.chaurasiya.roomdatabaseexample;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = Expense.class, exportSchema = false, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "expensedb";
    private static DatabaseHelper instance;
    public static synchronized DatabaseHelper getDB(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context ,DatabaseHelper.class, DB_NAME )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build() ;
        }
        return instance;
    }
    public abstract  ExpenseDAO expenseDAO();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
