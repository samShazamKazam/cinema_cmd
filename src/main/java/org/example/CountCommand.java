package org.example;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CountCommand implements Command {

    private final List<Filter> filters;

    public CountCommand(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public Double execute(String[] cols, List<String[]> rows) {
        FilterToPredicate filterToPredicate = new FilterToPredicate();
        Predicate<String[]> predicate = filterToPredicate.createPredicate(cols, filters);

        return (double) rows.stream().filter(predicate).count();
    }
}
