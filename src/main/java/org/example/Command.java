package org.example;

import java.util.List;

public interface Command {
    Double execute(String[] cols, List<String[]> rows);
}
