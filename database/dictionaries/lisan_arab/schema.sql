CREATE TABLE lisan_arab_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_lisan_arab_word ON lisan_arab_entries(word);
CREATE INDEX idx_lisan_arab_root ON lisan_arab_entries(root);
