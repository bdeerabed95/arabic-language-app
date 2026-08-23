CREATE TABLE mawdui_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT
);
CREATE TABLE mawdui_topics (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    topic_name TEXT NOT NULL,
    topic_type TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES mawdui_books(id)
);
CREATE INDEX idx_mawdui_book ON mawdui_books(book_title);
