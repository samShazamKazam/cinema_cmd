package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class FilterToPredicateTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createPredicate() {
        FilterToPredicate filterToPredicate = new FilterToPredicate();

        Predicate predicate = filterToPredicate.createPredicate(new String[]{"duration"}, List.of(new Filter("filter_duration", "2")));

    }
}