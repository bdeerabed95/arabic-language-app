-- Arabic Language Database
CREATE TABLE words (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    word TEXT NOT NULL,
    root TEXT,
    type TEXT,
    meaning TEXT
);
