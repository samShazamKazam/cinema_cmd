package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parse() {
    }

    @Test
    public void getFilters() {
        Parser parser = new Parser();

        String[] tokens = new String[3];
        tokens[0] = "filter1=value1";
        tokens[1] = "filter2=value2";
        tokens[2] = "filter3=value3";
        List<Filter> filters = parser.getFilters(tokens, 0);

        assertEquals(3, filters.size());
        assertEquals(filters.get(0).getName(), "filter1");
        assertEquals(filters.get(0).getValue(), "value1");

        assertEquals(filters.get(1).getName(), "filter2");
        assertEquals(filters.get(1).getValue(), "value2");

        assertEquals(filters.get(2).getName(), "filter3");
        assertEquals(filters.get(2).getValue(), "value3");
    }
}