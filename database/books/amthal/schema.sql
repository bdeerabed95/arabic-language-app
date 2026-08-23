CREATE TABLE amthal_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT
);
CREATE TABLE amthal_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    proverb TEXT NOT NULL,
    meaning TEXT,
    story TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES amthal_books(id)
);
CREATE INDEX idx_amthal_proverb ON amthal_entries(proverb);
