CREATE TABLE qamus_muhit_entries (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    root TEXT NOT NULL,
    word TEXT NOT NULL,
    definition TEXT NOT NULL,
    page_number INTEGER
);
CREATE INDEX idx_qamus_muhit_word ON qamus_muhit_entries(word);
CREATE INDEX idx_qamus_muhit_root ON qamus_muhit_entries(root);
