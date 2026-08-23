package com.arabic.language.app.activities;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arabic.language.app.R;
import com.arabic.language.app.adapters.WordAdapter;
import com.arabic.language.app.database.DatabaseHelper;
import com.arabic.language.app.models.Word;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = DatabaseHelper.getInstance(this);
        new Thread(() -> {
            List<Word> words = dbHelper.getAllWords();
            runOnUiThread(() -> recyclerView.setAdapter(new WordAdapter(words)));
        }).start();
    }
}
