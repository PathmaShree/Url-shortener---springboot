package com.example.url.util;

import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UserAgent {

    
    public static String getBrowser(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        if (ua == null) return "Unknown";

        if (ua.contains("Chrome")) return "Chrome";
        if (ua.contains("Firefox")) return "Firefox";
        if (ua.contains("Edge")) return "Edge";
        if (ua.contains("Safari") && !ua.contains("Chrome")) return "Safari";
        if (ua.contains("OPR") || ua.contains("Opera")) return "Opera";

        return "Unknown";
    }

   
    public static String getOs(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        if (ua == null) return "Unknown";

        if (ua.contains("Windows")) return "Windows";
        if (ua.contains("Mac OS")) return "Mac OS";
        if (ua.contains("X11")) return "Unix";
        if (ua.contains("Android")) return "Android";
        if (ua.contains("iPhone") || ua.contains("iPad")) return "iOS";

        return "Unknown";
    }

   
    public static String getDeviceType(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        if (ua == null) return "Unknown";

        if (ua.contains("Mobile")) return "Mobile";
        if (ua.contains("Tablet")) return "Tablet";

        return "Desktop";
    }

    
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr(); // fallback
        }

        // If multiple IPs, take the first one
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }

        return ip;
    }

   
    public static String getCountry(String ip) {
        try {
            URL url = new URL("https://ipinfo.io/" + ip + "/country");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.readLine();
        } catch (Exception e) {
            return "Unknown";
        }
    }
}
