package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Parser {
    public Command parse(String line) {
        String[] tokens = line.split(" ");

        if (tokens.length < 1) return new NullCommand();

        if (tokens[0].equals("COUNT")) {
            return new CountCommand(getFilters(tokens, 1));
        }
        if (tokens[0].equals("AVERAGE_RATING")) {
            return new AvgRatingCommand(getFilters(tokens, 1));
        }
        if (tokens[0].equals("AVERAGE_DURATION")) {
            return new AvgDurationCommand(getFilters(tokens, 1));
        }

        return new NullCommand();
    }

    public List<Filter> getFilters(String[] tokens, int start) {
        List<Filter> filters = new ArrayList<>();
        if (tokens.length > 1) {
            for (int i = start; i < tokens.length ; i++) {
                String str = tokens[i];
                String[] nameAndValue = str.split("=");
                filters.add(new Filter(nameAndValue[0].toLowerCase(), nameAndValue[1]));
            }
        }
        return filters;
    }
}
