package OOP.HW2;

import java.util.HashSet;

public class StringCode {

    public static String blowup(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                int times = ch - '0';
                if (i + 1 < n) {
                    char next = str.charAt(i + 1);
                    for (int k = 0; k < times; k++) sb.append(next);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static int maxRun(String str) {
        if (str.isEmpty()) return 0;
        int best = 1, run = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                run++;
            } else {
                if (run > best) best = run;
                run = 1;
            }
        }
        return Math.max(best, run);
    }

    public static boolean stringIntersect(String a, String b, int len) {
        if (a.length() < len || b.length() < len) return false;

        String s1 = a, s2 = b;
        if (a.length() > b.length()) { s1 = b; s2 = a; }

        HashSet<String> parts = new HashSet<>();
        for (int i = 0; i + len <= s1.length(); i++) {
            parts.add(s1.substring(i, i + len));
        }
        for (int j = 0; j + len <= s2.length(); j++) {
            if (parts.contains(s2.substring(j, j + len))) return true;
        }
        return false;
    }
}
