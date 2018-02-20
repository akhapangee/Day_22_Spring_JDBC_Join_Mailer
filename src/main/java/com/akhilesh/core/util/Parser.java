package com.akhilesh.core.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Akhilesh
 */
public class Parser {

    private Map<String, String> data;
    private String leftDelimiter="[", rightDelimiter="]";

    public Parser() {
        data = new HashMap<>();
    }

    
    public Parser(String leftDelimiter, String rightDelimiter) {
        data = new HashMap<>();
        this.leftDelimiter = leftDelimiter;
        this.rightDelimiter = rightDelimiter;
    }

    public Parser addData(String key, String value) {
        data.put(key, value);
        return this;
    }

    public String parse(String content) {

        for (Map.Entry pair : data.entrySet()) {
            content = content.replace(leftDelimiter + pair.getKey() + rightDelimiter,
                    pair.getValue().toString());
        }

        return content;
    }

}
