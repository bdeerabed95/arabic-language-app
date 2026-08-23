CREATE TABLE asas_balagha_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_asas_balagha_word ON asas_balagha_entries(word);
CREATE INDEX idx_asas_balagha_root ON asas_balagha_entries(root);
