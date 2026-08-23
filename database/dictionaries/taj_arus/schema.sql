CREATE TABLE taj_arus_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_taj_arus_word ON taj_arus_entries(word);
CREATE INDEX idx_taj_arus_root ON taj_arus_entries(root);
