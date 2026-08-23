CREATE TABLE mukhtar_sihah_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_mukhtar_sihah_word ON mukhtar_sihah_entries(word);
CREATE INDEX idx_mukhtar_sihah_root ON mukhtar_sihah_entries(root);
