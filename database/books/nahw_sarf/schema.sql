CREATE TABLE nahw_books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_title TEXT NOT NULL,
    author TEXT NOT NULL,
    era TEXT,
    description TEXT,
    manuscript_location TEXT
);
CREATE TABLE nahw_topics (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    topic_name TEXT NOT NULL,
    topic_type TEXT,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES nahw_books(id)
);
CREATE TABLE nahw_rules (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    rule_name TEXT NOT NULL,
    rule_text TEXT,
    examples TEXT,
    topic_id INTEGER,
    FOREIGN KEY (topic_id) REFERENCES nahw_topics(id)
);
CREATE INDEX idx_nahw_book ON nahw_books(book_title);
CREATE INDEX idx_nahw_rule ON nahw_rules(rule_name);
