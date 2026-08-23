// ============================================
// بيانات القواميس
// ============================================
const dictionaries = [
    { icon: '📖', title: 'لسان العرب', author: 'ابن منظور', desc: 'أوسع القواميس العربية، 80,000+ مادة' },
    { icon: '📗', title: 'القاموس المحيط', author: 'الفيروزآبادي', desc: 'مختصر شامل، 60,000+ مادة' },
    { icon: '📘', title: 'تاج العروس', author: 'الزبيدي', desc: 'شرح القاموس المحيط، 40 مجلد' },
    { icon: '📙', title: 'مختار الصحاح', author: 'الرازي', desc: 'مختصر سهل للطلاب' },
    { icon: '📕', title: 'المعجم الوسيط', author: 'مجمع اللغة العربية', desc: 'يشمل المصطلحات الحديثة' },
    { icon: '📔', title: 'المعجم الغني', author: 'معاصر', desc: 'معجم معاصر شامل' },
    { icon: '📓', title: 'مقاييس اللغة', author: 'ابن فارس', desc: 'يهتم بجذور الكلمات' },
    { icon: '📒', title: 'أساس البلاغة', author: 'الزمخشري', desc: 'يهتم بالاستعمال البلاغي' },
    { icon: '📚', title: 'الصحاح', author: 'الجوهري', desc: 'يهتم بالصحيح من الكلام' }
];

// ============================================
// بيانات الكتب
// ============================================
const books = [
    { icon: '📝', title: 'النحو والصرف', count: '7 كتب', desc: 'الكتاب لسيبويه، ألفية ابن مالك، مغني اللبيب' },
    { icon: '🎨', title: 'البلاغة', count: '6 كتب', desc: 'أسرار البلاغة، مفتاح العلوم، البيان والتبيين' },
    { icon: '📜', title: 'الأدب', count: '5 كتب', desc: 'الأغاني، العقد الفريد، الشعر والشعراء' },
    { icon: '🎵', title: 'العروض', count: '2 كتاب', desc: 'علم العروض للخليل، ميزان الذهب' },
    { icon: '🗣️', title: 'فقه اللغة', count: '6 كتب', desc: 'الخصائص، المزهر، فقه اللغة' },
    { icon: '📊', title: 'معاجم موضوعية', count: '3 كتب', desc: 'المخصص، الألفاظ الكتابية' },
    { icon: '🕌', title: 'غريب القرآن', count: '3 كتب', desc: 'مفردات الراغب، النهاية لابن الأثير' },
    { icon: '💺', title: 'الأمالي', count: '3 كتب', desc: 'أمالي القالي، مجالس ثعلب' },
    { icon: '✍️', title: 'الخط والإملاء', count: '2 كتاب', desc: 'أدب الكاتب، الإملاء والترقيم' },
    { icon: '🔄', title: 'الأضداد', count: '2 كتاب', desc: 'الأضداد لابن الأنباري' },
    { icon: '✅', title: 'التصحيح', count: '3 كتب', desc: 'إصلاح المنطق، معجم الأخطاء الشائعة' },
    { icon: '💬', title: 'الأمثال', count: '3 كتب', desc: 'مجمع الأمثال، جمهرة الأمثال' }
];

// ============================================
// عرض القواميس
// ============================================
function renderDictionaries() {
    const grid = document.getElementById('dictionariesGrid');
    grid.innerHTML = dictionaries.map(d => `
        <div class="card" onclick="showResult('${d.title}', '${d.author}', '${d.desc}')">
            <div class="card-icon">${d.icon}</div>
            <div class="card-title">${d.title}</div>
            <div class="card-desc">${d.author}</div>
            <div class="card-desc">${d.desc}</div>
        </div>
    `).join('');
}

// ============================================
// عرض الكتب
// ============================================
function renderBooks() {
    const grid = document.getElementById('booksGrid');
    grid.innerHTML = books.map(b => `
        <div class="card" onclick="showResult('${b.title}', '${b.count}', '${b.desc}')">
            <div class="card-icon">${b.icon}</div>
            <div class="card-title">${b.title}</div>
            <div class="card-desc">${b.count}</div>
            <div class="card-desc">${b.desc}</div>
        </div>
    `).join('');
}

// ============================================
// البحث الشامل
// ============================================
function searchAll() {
    const query = document.getElementById('searchInput').value || 
                  document.getElementById('heroSearch').value;
    
    if (query.trim().length < 2) {
        document.getElementById('results').style.display = 'none';
        return;
    }
    
    const queryLower = query.trim().toLowerCase();
    const results = [];
    
    // البحث في القواميس
    dictionaries.forEach(d => {
        if (d.title.includes(query) || d.author.includes(query) || d.desc.includes(query)) {
            results.push({ type: 'قاموس', title: d.title, desc: d.author + ' - ' + d.desc });
        }
    });
    
    // البحث في الكتب
    books.forEach(b => {
        if (b.title.includes(query) || b.desc.includes(query)) {
            results.push({ type: 'كتاب', title: b.title, desc: b.count + ' - ' + b.desc });
        }
    });
    
    displayResults(results);
}

// ============================================
// عرض النتائج
// ============================================
function displayResults(results) {
    const resultsSection = document.getElementById('results');
    const resultsContainer = document.getElementById('searchResults');
    
    if (results.length === 0) {
        resultsContainer.innerHTML = '<p style="text-align:center;color:#757575;">لا توجد نتائج للبحث</p>';
    } else {
        resultsContainer.innerHTML = results.map(r => `
            <div class="result-item">
                <div class="result-title">${r.type}: ${r.title}</div>
                <div class="result-desc">${r.desc}</div>
            </div>
        `).join('');
    }
    
    resultsSection.style.display = 'block';
    resultsSection.scrollIntoView({ behavior: 'smooth' });
}

// ============================================
// عرض نتيجة واحدة
// ============================================
function showResult(title, subtitle, desc) {
    displayResults([{ type: 'معلومة', title: title, desc: subtitle + ' - ' + desc }]);
}

// ============================================
// تبديل القائمة
// ============================================
function toggleMenu() {
    const navLinks = document.querySelector('.nav-links');
    navLinks.classList.toggle('show');
}

// ============================================
// التهيئة
// ============================================
document.addEventListener('DOMContentLoaded', () => {
    renderDictionaries();
    renderBooks();
    
    // تفعيل روابط التنقل
    document.querySelectorAll('.nav-links a').forEach(link => {
        link.addEventListener('click', function(e) {
            document.querySelectorAll('.nav-links a').forEach(l => l.classList.remove('active'));
            this.classList.add('active');
        });
    });
    
    // البحث بزر Enter
    document.getElementById('searchInput').addEventListener('keypress', (e) => {
        if (e.key === 'Enter') searchAll();
    });
    
    document.getElementById('heroSearch').addEventListener('keypress', (e) => {
        if (e.key === 'Enter') searchAll();
    });
});
