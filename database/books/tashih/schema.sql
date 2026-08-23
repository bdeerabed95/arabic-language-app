CREATE TABLE tashih_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT
);
CREATE TABLE tashih_errors (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    error_word TEXT NOT NULL,
    correct_word TEXT NOT NULL,
    explanation TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES tashih_books(id)
);
CREATE INDEX idx_tashih_error ON tashih_errors(error_word);
