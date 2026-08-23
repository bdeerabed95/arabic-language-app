package com.arabic.language.app.repositories;

import android.content.Context;
import com.arabic.language.app.database.DatabaseHelper;
import com.arabic.language.app.models.Word;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordRepository {
    
    private final DatabaseHelper dbHelper;
    private final ExecutorService executorService;
    private static WordRepository instance;
    
    private WordRepository(Context context) {
        dbHelper = DatabaseHelper.getInstance(context);
        executorService = Executors.newFixedThreadPool(2);
    }
    
    public static synchronized WordRepository getInstance(Context context) {
        if (instance == null) {
            instance = new WordRepository(context.getApplicationContext());
        }
        return instance;
    }
    
    public void searchWords(String query, RepositoryCallback<List<Word>> callback) {
        executorService.execute(() -> {
            try {
                List<Word> results = dbHelper.searchWords(query);
                callback.onSuccess(results);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }
    
    public void getAllWords(RepositoryCallback<List<Word>> callback) {
        executorService.execute(() -> {
            try {
                List<Word> words = dbHelper.getAllWords();
                callback.onSuccess(words);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }
    
    public void getFavorites(RepositoryCallback<List<Word>> callback) {
        executorService.execute(() -> {
            try {
                List<Word> favorites = dbHelper.getFavorites();
                callback.onSuccess(favorites);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }
    
    public void addToFavorites(int wordId, RepositoryCallback<Boolean> callback) {
        executorService.execute(() -> {
            try {
                dbHelper.addToFavorites(wordId);
                callback.onSuccess(true);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }
    
    public interface RepositoryCallback<T> {
        void onSuccess(T result);
        void onError(Exception e);
    }
}
