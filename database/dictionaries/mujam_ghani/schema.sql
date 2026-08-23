CREATE TABLE mujam_ghani_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_mujam_ghani_word ON mujam_ghani_entries(word);
CREATE INDEX idx_mujam_ghani_root ON mujam_ghani_entries(root);
