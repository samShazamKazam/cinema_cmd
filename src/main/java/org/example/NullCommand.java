package org.example;

import java.util.List;

public class NullCommand implements Command {
    @Override
    public Double execute(String[] cols, List<String[]> rows) {
        return null;
    }
}
