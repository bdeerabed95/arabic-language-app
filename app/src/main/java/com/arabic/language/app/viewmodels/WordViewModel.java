package com.arabic.language.app.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.arabic.language.app.database.DatabaseHelper;
import com.arabic.language.app.models.Word;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordViewModel extends AndroidViewModel {
    
    private final DatabaseHelper dbHelper;
    private final ExecutorService executorService;
    private final MutableLiveData<List<Word>> wordsLiveData;
    private final MutableLiveData<List<Word>> searchResultsLiveData;
    private final MutableLiveData<List<Word>> favoritesLiveData;
    private final MutableLiveData<Boolean> isLoadingLiveData;
    private final MutableLiveData<String> errorLiveData;
    
    public WordViewModel(@NonNull Application application) {
        super(application);
        dbHelper = DatabaseHelper.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        wordsLiveData = new MutableLiveData<>();
        searchResultsLiveData = new MutableLiveData<>();
        favoritesLiveData = new MutableLiveData<>();
        isLoadingLiveData = new MutableLiveData<>(false);
        errorLiveData = new MutableLiveData<>();
    }
    
    public LiveData<List<Word>> getWords() {
        return wordsLiveData;
    }
    
    public LiveData<List<Word>> getSearchResults() {
        return searchResultsLiveData;
    }
    
    public LiveData<List<Word>> getFavorites() {
        return favoritesLiveData;
    }
    
    public LiveData<Boolean> isLoading() {
        return isLoadingLiveData;
    }
    
    public LiveData<String> getError() {
        return errorLiveData;
    }
    
    public void loadAllWords() {
        isLoadingLiveData.setValue(true);
        executorService.execute(() -> {
            try {
                List<Word> words = dbHelper.getAllWords();
                wordsLiveData.postValue(words);
            } catch (Exception e) {
                errorLiveData.postValue(e.getMessage());
            } finally {
                isLoadingLiveData.postValue(false);
            }
        });
    }
    
    public void searchWords(String query) {
        if (query == null || query.trim().length() < 2) {
            searchResultsLiveData.setValue(wordsLiveData.getValue());
            return;
        }
        
        isLoadingLiveData.setValue(true);
        executorService.execute(() -> {
            try {
                List<Word> results = dbHelper.searchWords(query);
                searchResultsLiveData.postValue(results);
            } catch (Exception e) {
                errorLiveData.postValue(e.getMessage());
            } finally {
                isLoadingLiveData.postValue(false);
            }
        });
    }
    
    public void loadFavorites() {
        isLoadingLiveData.setValue(true);
        executorService.execute(() -> {
            try {
                List<Word> favorites = dbHelper.getFavorites();
                favoritesLiveData.postValue(favorites);
            } catch (Exception e) {
                errorLiveData.postValue(e.getMessage());
            } finally {
                isLoadingLiveData.postValue(false);
            }
        });
    }
    
    public void addToFavorites(int wordId) {
        executorService.execute(() -> {
            dbHelper.addToFavorites(wordId);
            loadFavorites();
        });
    }
    
    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown();
    }
}
