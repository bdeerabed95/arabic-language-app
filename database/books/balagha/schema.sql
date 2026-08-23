CREATE TABLE balagha_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT,
    description TEXT
);
CREATE TABLE balagha_topics (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    topic_name TEXT NOT NULL,
    topic_type TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES balagha_books(id)
);
CREATE INDEX idx_balagha_book ON balagha_books(book_title);
