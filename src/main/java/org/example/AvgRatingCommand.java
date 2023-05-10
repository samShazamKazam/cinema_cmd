package org.example;

import java.util.List;
import java.util.function.Predicate;

public class AvgRatingCommand implements Command {

    private final List<Filter> filters;

    public AvgRatingCommand(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public Double execute(String[] cols, List<String[]> rows) {
        FilterToPredicate filterToPredicate = new FilterToPredicate();
        Predicate<String[]> predicate = filterToPredicate.createPredicate(cols, filters);

        long numerator = rows.stream().filter(predicate).mapToLong(row -> Integer.parseInt(row[3])).sum();
        long denominator = rows.size();
        return (double) numerator / denominator;
    }
}
