package com.happyfinger.eatertime.utils;

import android.text.TextUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by jiaoyang on 9/26/15.
 */
public class NetworkUtils {
    public static String get(String url, Map<String, ? extends Object> params) throws IOException {
        String paramStr = toString(params, true);
        url = url + (TextUtils.isEmpty(paramStr) ? "" : "?" + paramStr);
        UU.j("url", url);

        return send("GET", url, null);
    }

    public static String post(String url, Map<String, ? extends Object> params) throws IOException {
        return send("POST", url, toString(params, false));
    }

    public static String post(String url, String content) throws IOException {
        return send("POST", url, content);
    }

    public static String toString(Map<String, ? extends Object> params, boolean needEncode) {
        StringBuilder builder = new StringBuilder();
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                try {
                    String value = needEncode ? URLEncoder.encode(String.valueOf(params.get(key)), "UTF-8")
                            : String.valueOf(params.get(key));
                    builder.append(key).append('=').append(value).append('&');
                } catch (UnsupportedEncodingException e) {
                }
            }
            builder.setLength(builder.length() - 1);
        }

        return builder.toString();
    }

    public static String send(String method, String url, String content) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        try {
            urlConnection.setRequestMethod(method);
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setChunkedStreamingMode(0);
            urlConnection.setInstanceFollowRedirects(true);

            if (content != null) {
                OutputStream out = urlConnection.getOutputStream();
                IOUtils.write(content, out);
            }

            InputStream in = urlConnection.getInputStream();
            return IOUtils.toString(in);

        } finally {
            urlConnection.disconnect();
        }
    }

}
