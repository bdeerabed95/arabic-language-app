CREATE TABLE addad_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT
);
CREATE TABLE addad_words (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    word TEXT NOT NULL,
    opposite_meaning TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES addad_books(id)
);
CREATE INDEX idx_addad_word ON addad_words(word);
