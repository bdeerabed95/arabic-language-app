package com.arabic.language.app.database;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class DictionaryManager {
    private static final Map<String, String> DICTIONARIES = new LinkedHashMap<>();
    static {
        DICTIONARIES.put("lisan_arab", "لسان العرب - ابن منظور");
        DICTIONARIES.put("qamus_muhit", "القاموس المحيط - الفيروزآبادي");
        DICTIONARIES.put("taj_arus", "تاج العروس - الزبيدي");
        DICTIONARIES.put("mukhtar_sihah", "مختار الصحاح - الرازي");
        DICTIONARIES.put("mujam_wasit", "المعجم الوسيط");
        DICTIONARIES.put("mujam_ghani", "المعجم الغني");
        DICTIONARIES.put("maqayis_lugha", "معجم مقاييس اللغة - ابن فارس");
        DICTIONARIES.put("asas_balagha", "أساس البلاغة - الزمخشري");
        DICTIONARIES.put("sihah_jawhari", "الصحاح في اللغة - الجوهري");
    }
    public static List<String> getDictionaryNames() { return new ArrayList<>(DICTIONARIES.values()); }
    public static Map<String, String> getAllDictionaries() { return DICTIONARIES; }
}
