package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LocalizationUtil {
    static String currentLang = "Ru";
    
    static Map<String, JSONObject> langs = new HashMap<>();
    
    public static void getLang() {
        JSONParser parser = new JSONParser();

        try {
            Object rawObject = parser.parse(new FileReader("resources/localization.json"));
            JSONObject jsonObject = (JSONObject) rawObject;
            langs.put("Ru", (JSONObject)jsonObject.get("ru"));
            langs.put("En", (JSONObject)jsonObject.get("en"));
        } catch (IOException | ParseException e) {
            System.out.println(e);
        }
    }
    
    public static void setLang(String lang) {
        currentLang = lang;
    }
    
    public static String getLocalizationStr(String key) {
        return (String)langs.get(currentLang).get(key);
    }
}
