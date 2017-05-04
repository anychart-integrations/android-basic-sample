package android.anychart.com.anychart.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * (c) Anychart 2010–2017. All rights reserved.
 */
public class Utils {

    private static final String HTML_FILE = "base.html";

    public static String readHtmlFile(Context context) throws Exception {
        return readFile(context, HTML_FILE);
    }

    private static String readFile(Context context, String fileName) throws Exception {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName), "UTF-8"));

            // do reading, usually loop until end of file reading
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            return sb.toString();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ignore) {

                }
            }
        }
    }
}
