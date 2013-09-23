package com.talios;

import org.fest.assertions.core.Condition;

import java.util.List;
import java.util.regex.Pattern;

public class RegexMatch extends Condition {

    private Pattern pattern;

    RegexMatch(String pattern) {
        this.pattern = Pattern.compile(pattern);
        as("matches of contains a match for " + pattern);
    }

    public static RegexMatch regexMatch(String pattern) {
        return new RegexMatch(pattern);
    }

    @Override
    public boolean matches(Object value) {
        if (value instanceof List) {
            List list = (List) value;
            for (Object o : list) {
                if (pattern.matcher(o.toString()).matches()) {
                    return true;
                }
            }
            return false;
        }


        return pattern.matcher(value.toString()).matches();
    }
}
