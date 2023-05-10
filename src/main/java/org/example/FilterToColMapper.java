package org.example;

import java.util.*;

public class FilterToColMapper {
    // maps each filter name to a column index and the given filter value
    public Map<Integer, String> map(String[] cols, List<Filter> filters) {
        Map<Integer, String> map = new HashMap<>();

        for (Filter filter : filters) {
            String col = filter.getName().substring(filter.getName().indexOf("_") + 1);

            for (int idx = 0 ; idx < cols.length ; idx++) {
                if (cols[idx].equals(col)) {
                    map.put(idx, filter.getValue());
                }
            }
        }
        return map;
    }
}
