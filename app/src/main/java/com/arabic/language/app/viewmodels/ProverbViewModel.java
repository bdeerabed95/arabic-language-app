package com.arabic.language.app.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.arabic.language.app.database.DatabaseHelper;
import com.arabic.language.app.models.Proverb;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProverbViewModel extends AndroidViewModel {
    
    private final DatabaseHelper dbHelper;
    private final ExecutorService executorService;
    private final MutableLiveData<List<Proverb>> proverbsLiveData;
    private final MutableLiveData<Boolean> isLoadingLiveData;
    
    public ProverbViewModel(@NonNull Application application) {
        super(application);
        dbHelper = DatabaseHelper.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        proverbsLiveData = new MutableLiveData<>();
        isLoadingLiveData = new MutableLiveData<>(false);
    }
    
    public LiveData<List<Proverb>> getProverbs() {
        return proverbsLiveData;
    }
    
    public LiveData<Boolean> isLoading() {
        return isLoadingLiveData;
    }
    
    public void loadProverbs() {
        isLoadingLiveData.setValue(true);
        executorService.execute(() -> {
            try {
                List<Proverb> proverbs = dbHelper.getProverbs();
                proverbsLiveData.postValue(proverbs);
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
