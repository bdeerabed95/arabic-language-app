package com.arabic.language.app.repositories;

import android.content.Context;
import com.arabic.language.app.database.DatabaseHelper;
import com.arabic.language.app.models.GrammarRule;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GrammarRepository {
    
    private final DatabaseHelper dbHelper;
    private final ExecutorService executorService;
    private static GrammarRepository instance;
    
    private GrammarRepository(Context context) {
        dbHelper = DatabaseHelper.getInstance(context);
        executorService = Executors.newSingleThreadExecutor();
    }
    
    public static synchronized GrammarRepository getInstance(Context context) {
        if (instance == null) {
            instance = new GrammarRepository(context.getApplicationContext());
        }
        return instance;
    }
    
    public void getGrammarRules(RepositoryCallback<List<GrammarRule>> callback) {
        executorService.execute(() -> {
            try {
                List<GrammarRule> rules = dbHelper.getGrammarRules();
                callback.onSuccess(rules);
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
