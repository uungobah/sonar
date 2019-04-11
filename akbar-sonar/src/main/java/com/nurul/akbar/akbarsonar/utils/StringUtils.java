package com.nurul.akbar.akbarsonar.utils;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean hasValue(Object var0) {
        return var0 != null && hasValue(var0.toString(), false);
    }

    public static boolean hasValue(String var0) {
        return hasValue(var0, false);
    }

    public static boolean hasValue(String var0, boolean var1) {
        if (var1) {
            return var0 != null && !var0.trim().equals("");
        } else {
            return var0 != null && !var0.equals("");
        }
    }

}
