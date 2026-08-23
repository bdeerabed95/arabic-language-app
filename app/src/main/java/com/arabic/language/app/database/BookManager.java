package com.arabic.language.app.database;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookManager {
    
    private static final Map<String, String> BOOK_CATEGORIES = new LinkedHashMap<>();
    
    static {
        BOOK_CATEGORIES.put("nahw_sarf", "كتب النحو والصرف");
        BOOK_CATEGORIES.put("balagha", "كتب البلاغة");
        BOOK_CATEGORIES.put("adab", "كتب الأدب والاختيارات");
        BOOK_CATEGORIES.put("arud", "كتب العروض والقوافي");
        BOOK_CATEGORIES.put("fiqh_lugha", "كتب فقه اللغة");
        BOOK_CATEGORIES.put("mawdui", "المعاجم الموضوعية");
        BOOK_CATEGORIES.put("gharib", "كتب غريب القرآن والحديث");
        BOOK_CATEGORIES.put("amali", "كتب الأمالي والمجالس");
        BOOK_CATEGORIES.put("khat", "كتب الخط والإملاء");
        BOOK_CATEGORIES.put("addad", "كتب الأضداد");
        BOOK_CATEGORIES.put("tashih", "كتب التصحيح اللغوي");
        BOOK_CATEGORIES.put("amthal", "كتب الأمثال");
    }
    
    public static List<String> getCategories() {
        return new ArrayList<>(BOOK_CATEGORIES.values());
    }
    
    public static Map<String, String> getAllCategories() {
        return BOOK_CATEGORIES;
    }
}
