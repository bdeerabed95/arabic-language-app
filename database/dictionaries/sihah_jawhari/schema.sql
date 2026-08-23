CREATE TABLE sihah_jawhari_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_sihah_jawhari_word ON sihah_jawhari_entries(word);
CREATE INDEX idx_sihah_jawhari_root ON sihah_jawhari_entries(root);
