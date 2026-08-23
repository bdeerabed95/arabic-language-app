CREATE TABLE khat_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT
);
CREATE TABLE khat_rules (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    rule_name TEXT NOT NULL,
    rule_text TEXT,
    examples TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES khat_books(id)
);
CREATE INDEX idx_khat_book ON khat_books(book_title);
