package com.madadipouya.mira.util;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class UrlUtil {

    private UrlUtil() {

    }

    public static String getBaseUrl(HttpServletRequest request) {
        return StringUtils.removeEnd(request.getRequestURL().toString(), request.getRequestURI());
    }

    public static String generateFullyQualifiedDownloadUrl(String baseUrl, String downloadPath) {
        return baseUrl + downloadPath;
    }

    public static String generateDownloadPath(String fileName) {
        return "/%s/%s".formatted(RandomStringUtils.randomAlphabetic(5), fileName);
    }
}
