CREATE TABLE amali_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT
);
CREATE TABLE amali_sessions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    session_number INTEGER,
    session_date TEXT,
    topic TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES amali_books(id)
);
CREATE INDEX idx_amali_book ON amali_books(book_title);
