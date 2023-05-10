package org.example;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class FilterToPredicate {
    public Predicate<String[]> createPredicate(String[] cols, List<Filter> filters) {
        FilterToColMapper mapper = new FilterToColMapper();
        Map<Integer, String> colIdxs = mapper.map(cols, filters);

        Predicate<String[]> predicate = row -> true;
        for (Map.Entry<Integer, String> entry: colIdxs.entrySet()) {
            int i  = entry.getKey();
            String value = entry.getValue();
            predicate = predicate.and(row ->  row[i].equals(value));
        }

        return predicate;
    }
}
