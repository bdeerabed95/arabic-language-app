package com.arabic.language.app.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.arabic.language.app.models.Word;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "arabic.db";
    private static final int DB_VERSION = 1;
    private static DatabaseHelper instance;
    
    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) instance = new DatabaseHelper(context.getApplicationContext());
        return instance;
    }
    
    private DatabaseHelper(Context context) { super(context, DB_NAME, null, DB_VERSION); }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE words (id INTEGER PRIMARY KEY AUTOINCREMENT, word TEXT, root TEXT, type TEXT, meaning TEXT)");
        ContentValues v = new ContentValues();
        v.put("word", "كتاب"); v.put("root", "كتب"); v.put("type", "اسم"); v.put("meaning", "مجموعة صفحات");
        db.insert("words", null, v);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS words");
        onCreate(db);
    }
    
    public List<Word> getAllWords() {
        List<Word> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("words", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                Word w = new Word();
                w.setId(c.getInt(c.getColumnIndexOrThrow("id")));
                w.setWord(c.getString(c.getColumnIndexOrThrow("word")));
                w.setRoot(c.getString(c.getColumnIndexOrThrow("root")));
                w.setType(c.getString(c.getColumnIndexOrThrow("type")));
                w.setMeaning(c.getString(c.getColumnIndexOrThrow("meaning")));
                list.add(w);
            } while (c.moveToNext());
        }
        c.close(); db.close();
        return list;
    }
}
