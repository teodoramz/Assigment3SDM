package com.google.android.calculator;

import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public int a;

    public long b;

    public String c;

    public List d = new LinkedList();

    public static void a(URLConnection paramURLConnection, String paramString1, String paramString2) {
        if (!a(paramString2))
            paramURLConnection.addRequestProperty("User-Agent", paramString2);
        for (String paramString : paramString1.split("\r\n")) {
            if (!a(paramString2)) {
                String[] arrayOfString = paramString2.split(": ", 2);
                if (arrayOfString.length == 2 && !a(arrayOfString[0]) && !a(arrayOfString[1]))
                    paramURLConnection.addRequestProperty(arrayOfString[0], arrayOfString[1]);
            }
        }
    }

    private static boolean a(String paramString) {
        return (paramString == null || "".equals(paramString));
    }
}
