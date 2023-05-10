package org.example;

import java.util.List;

public class CsvData {
    private String[] cols;
    private List<String[]> rows;

    public CsvData(String[] cols, List<String[]> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public String[] getCols() {
        return cols;
    }

    public List<String[]> getRows() {
        return rows;
    }
}
