CREATE TABLE adab_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT,
    description TEXT,
    contents TEXT
);
CREATE TABLE adab_selections (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    selection_text TEXT,
    selection_type TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES adab_books(id)
);
CREATE INDEX idx_adab_book ON adab_books(book_title);
