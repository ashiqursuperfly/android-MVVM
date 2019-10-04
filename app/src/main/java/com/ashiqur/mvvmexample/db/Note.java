package com.ashiqur.mvvmexample.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
  "@Entity" annotation ensures that this class should be generated as a SQL table.By default,
  All fields in this class would be columns of the SQL table.
  If you don't want to include a specific field in the actual SQL table use the ignore annotation like this:
  "@Ignore"
  private int bleh;
  this will make sure field 'bleh' isn't registered as a SQL column in the table
 **/

/**
 * Know about other useful room annotations here: https://medium.com/@tonyowen/room-entity-annotations-379150e1ca82
 **/

@Entity(tableName = NoteConstants.TABLE_NAME)
// By default the table would've been named the java class's name but this allows us to change the name.
public class Note {

    //autoGenerate = true => auto generate id after each insertion on the table (exactly like 'serial' in postgres)
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = NoteConstants.ATTR_ID)
    private int id;

    @ColumnInfo(name = NoteConstants.ATTR_TITLE) // sets the actual name of the column in the SQL table
    private String title;

    @ColumnInfo(name = NoteConstants.ATTR_DESCRIPTION)
    private String description;

    @ColumnInfo(name = NoteConstants.ATTR_PRIORITY)
    private int priority;

    public Note(String title, String description, int priority) { // note: we are not using id field since we are expecting it to be autogenerated
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @NonNull
    @Override
    public String toString() {
        return title+":"+description;
    }
}

class NoteConstants {
    static final String TABLE_NAME = "note_table";
    static final String ATTR_PRIORITY = "priority";
    static final String ATTR_TITLE = "title";
    static final String ATTR_DESCRIPTION = "description";
    static final String ATTR_ID = "id";
}
