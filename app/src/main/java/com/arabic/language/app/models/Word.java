package com.arabic.language.app.models;
public class Word {
    private int id;
    private String word;
    private String root;
    private String type;
    private String meaning;
    public Word() {}
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }
    public String getRoot() { return root; }
    public void setRoot(String root) { this.root = root; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }
}
