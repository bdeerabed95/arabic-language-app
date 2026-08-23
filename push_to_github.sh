#!/bin/bash

echo "========================================="
echo "   Pushing to GitHub                     "
echo "========================================="

cd ~/arabic-language-app

# طلب اسم المستخدم
echo "Enter your GitHub username:"
read USERNAME

# تغيير الفرع إلى main
git branch -M main

# إضافة remote
git remote remove origin 2>/dev/null
git remote add origin "https://github.com/$USERNAME/arabic-language-app.git"

# رفع المشروع
echo "Pushing to GitHub..."
git push -u origin main

echo ""
echo "========================================="
echo "   Done! Check your GitHub repository    "
echo "========================================="
echo "URL: https://github.com/$USERNAME/arabic-language-app"
