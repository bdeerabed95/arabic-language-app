#!/bin/bash
cd ~/arabic-language-app
git add .
git commit -m "Update: $(date '+%Y-%m-%d %H:%M:%S')"
git push origin main
echo "✅ Done!"
