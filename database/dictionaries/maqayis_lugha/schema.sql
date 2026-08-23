CREATE TABLE maqayis_lugha_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_maqayis_lugha_word ON maqayis_lugha_entries(word);
CREATE INDEX idx_maqayis_lugha_root ON maqayis_lugha_entries(root);
