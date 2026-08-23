CREATE TABLE arud_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT
);
CREATE TABLE arud_buhur (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    bahr_name TEXT NOT NULL,
    pattern TEXT,
    feet TEXT
);
CREATE TABLE arud_terms (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    term_name TEXT NOT NULL,
    definition TEXT
);
CREATE INDEX idx_arud_book ON arud_books(book_title);
CREATE INDEX idx_arud_bahr ON arud_buhur(bahr_name);
