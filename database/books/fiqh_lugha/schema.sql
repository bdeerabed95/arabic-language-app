CREATE TABLE fiqh_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT,
    description TEXT
);
CREATE TABLE fiqh_topics (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    topic_name TEXT NOT NULL,
    details TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES fiqh_books(id)
);
CREATE INDEX idx_fiqh_book ON fiqh_books(book_title);
