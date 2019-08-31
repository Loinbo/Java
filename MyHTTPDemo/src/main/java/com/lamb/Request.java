package com.lamb;

import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Loinbo
 * DATE:2019/8/30
 * TIME:10:43
 */

public class Request {
    public String method;  //请求方法
    private String url;  //网页地址
    private String version; //协议版本号
    public Map<String, String> params = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();

    public static Request parse(InputStream is) throws IOException {
        Request request = new Request();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        // 解析请求行
        parseRequestLine(reader, request);
        // 解析请求头
        parseRequestHeaders(reader, request);
        // 解析可能存在的请求体
        if (request.method.toUpperCase().equals("POST")) {
            parseRequestBody(reader, request);
        }

        return request;
    }

    private static void parseRequestBody(BufferedReader reader, Request request) throws IOException {
        int len = Integer.parseInt(request.headers.get("Content-Length"));
        char[] buf = new char[len];
        reader.read(buf, 0, len);
        request.setRequestParams(String.valueOf(buf));
    }

    private static void parseRequestHeaders(BufferedReader reader, Request request) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            request.headers.put(key, value);
        }
    }

    private static void parseRequestLine(BufferedReader reader, Request request) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IOException("读到 EOF");
        }

        String[] fragments = line.split(" ");

        // 解析方法
        request.setMethod(fragments[0]);
        // 解析 URL
        request.setUrl(fragments[1]);
        // 解析版本号
        request.setVersion(fragments[2]);
    }

    private void setUrl(String fragment) throws UnsupportedEncodingException {
        // index?name=lamb&times=3   QueryString
        // 先去判断 URL 中有没有 QueryString
        String[] group = fragment.split("\\?");
        url = group[0];
        if (group.length > 1) {
            setRequestParams(group[1]);
        }
    }

    private void setRequestParams(String s) throws UnsupportedEncodingException {
        for (String kv : s.split("&")) {
            String[] kvs = kv.split("=");
            String key = URLDecoder.decode(kvs[0], "UTF-8");
            String value = URLDecoder.decode(kvs[1], "UTF-8");
            params.put(key, value);
        }
    }

    private void setVersion(String fragment) {
        version = fragment;
    }

    private void setMethod(String fragment) {
        method = fragment;
    }

    public String getUrl() {
        return url;
    }
}
