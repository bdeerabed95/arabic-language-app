package com.arabic.language.app.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.arabic.language.app.database.DatabaseHelper;
import com.arabic.language.app.models.GrammarRule;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GrammarViewModel extends AndroidViewModel {
    
    private final DatabaseHelper dbHelper;
    private final ExecutorService executorService;
    private final MutableLiveData<List<GrammarRule>> grammarRulesLiveData;
    private final MutableLiveData<Boolean> isLoadingLiveData;
    
    public GrammarViewModel(@NonNull Application application) {
        super(application);
        dbHelper = DatabaseHelper.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        grammarRulesLiveData = new MutableLiveData<>();
        isLoadingLiveData = new MutableLiveData<>(false);
    }
    
    public LiveData<List<GrammarRule>> getGrammarRules() {
        return grammarRulesLiveData;
    }
    
    public LiveData<Boolean> isLoading() {
        return isLoadingLiveData;
    }
    
    public void loadGrammarRules() {
        isLoadingLiveData.setValue(true);
        executorService.execute(() -> {
            try {
                List<GrammarRule> rules = dbHelper.getGrammarRules();
                grammarRulesLiveData.postValue(rules);
            } finally {
                isLoadingLiveData.postValue(false);
            }
        });
    }
    
    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown();
    }
}
