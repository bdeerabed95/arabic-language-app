CREATE TABLE mujam_wasit_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_mujam_wasit_word ON mujam_wasit_entries(word);
CREATE INDEX idx_mujam_wasit_root ON mujam_wasit_entries(root);
