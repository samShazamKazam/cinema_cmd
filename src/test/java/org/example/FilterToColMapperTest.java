package org.example;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FilterToColMapperTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void map() {
        FilterToColMapper mapper = new FilterToColMapper();

        Map<Integer, String> m = mapper.map(new String[]{"duration"}, List.of(new Filter("filter_duration", "2")));
        assertEquals("2", m.get(0));
    }

    @org.junit.Test
    public void mapWithMultipleValues() {
        FilterToColMapper mapper = new FilterToColMapper();

        Map<Integer, String> m = mapper.map(new String[]{"duration", "rating"},
                List.of(new Filter("filter_rating", "4"), new Filter("filter_duration", "2")));
        assertEquals(m.size(), 2);
        assertEquals("2", m.get(0));
        assertEquals("4", m.get(1));
    }
}