package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public CsvData readFile() {
        String[] cols = new String[0];
        List<String[]> rows = new ArrayList<>();

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("movies.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try(BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
            cols = bufferedReader.lines().findFirst().get().toLowerCase().split(";");

            bufferedReader.lines().forEach(line -> {
                String[] fields = (line.split(";"));
                rows.add(fields);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new CsvData(cols, rows);
    }
}
