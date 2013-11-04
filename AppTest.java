package com.talios;

import org.fest.assertions.core.Condition;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest  {

    public static class RegexMatch extends Condition {

        private Pattern pattern;

        RegexMatch(String pattern) {
            this.pattern = Pattern.compile(pattern);
            as("matches of contains a match for " + pattern);
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

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("one", "two", "three");

        assertThat(strings).describedAs("test")
                .isNotEmpty()
                .has(new RegexMatch("th.*"))
                .doesNotHave(new RegexMatch("moo.*"))
                .hasSize(3);

    }

}
