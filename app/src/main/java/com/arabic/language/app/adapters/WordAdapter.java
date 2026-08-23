package com.arabic.language.app.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.arabic.language.app.R;
import com.arabic.language.app.models.Word;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.VH> {
    private List<Word> words;
    public WordAdapter(List<Word> words) { this.words = words; }
    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new VH(v);
    }
    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        Word w = words.get(pos);
        h.wordText.setText(w.getWord());
        h.meaningText.setText(w.getMeaning());
    }
    @Override public int getItemCount() { return words.size(); }
    public void updateData(List<Word> newWords) { this.words = newWords; notifyDataSetChanged(); }
    static class VH extends RecyclerView.ViewHolder {
        TextView wordText, meaningText;
        VH(@NonNull View v) { super(v); wordText = v.findViewById(R.id.wordText); meaningText = v.findViewById(R.id.meaningText); }
    }
}
