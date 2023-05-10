package org.example;

import java.util.List;

public class Main {
    public void start() {
        FileReader reader = new FileReader();
        CsvData csvData = reader.readFile();
        String[] cols = csvData.getCols();
        List<String[]> rows = csvData.getRows();

        CommandExecuter executer = new CommandExecuter(System.in, cols, rows);

        executer.start();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}