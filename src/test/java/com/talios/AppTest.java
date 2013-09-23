package com.talios;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.talios.RegexMatch.regexMatch;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest  {

    @Test
    public static void testHasReturns() {

        List<String> strings = Arrays.asList("one", "two", "three");

        assertThat(strings).describedAs("test")
                .isNotEmpty()
                .has(regexMatch("th.*"))
                .hasSize(3);

    }

    @Test
    public static void testDoesNotHaveReturns() {

        List<String> strings = Arrays.asList("one", "two", "three");

        assertThat(strings).describedAs("test")
                .isNotEmpty()
                .has(regexMatch("th.*"))
                .doesNotHave(regexMatch("moo.*"))
                .hasSize(3);

    }

}
