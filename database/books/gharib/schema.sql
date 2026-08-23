CREATE TABLE gharib_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT,
    source_type TEXT
);
CREATE TABLE gharib_terms (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    term TEXT NOT NULL,
    explanation TEXT,
    source_text TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES gharib_books(id)
);
CREATE INDEX idx_gharib_book ON gharib_books(book_title);
CREATE INDEX idx_gharib_term ON gharib_terms(term);
