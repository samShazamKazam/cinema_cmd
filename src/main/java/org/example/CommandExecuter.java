package org.example;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class CommandExecuter {
    String[] cols;
    List<String[]> rows;

    // Create a Scanner to read from the InputStream
    Parser parser = new Parser();
    Scanner cmdScanner;

    public CommandExecuter(InputStream in, String[] cols, List<String[]> rows) {
        cmdScanner = new Scanner(in);
        this.cols = cols;
        this.rows = rows;
    }

    public void start() {
        // Read the contents of the file line by line
        while (cmdScanner.hasNextLine()) {
            String line = cmdScanner.nextLine();
            Command cmd = parser.parse(line);

            if (cmd instanceof CountCommand) {
                System.out.println("Count: " + cmd.execute(cols, rows).intValue());
            } else if (cmd instanceof AvgRatingCommand) {
                System.out.println("Average rating: " + cmd.execute(cols, rows));
            } else if (cmd instanceof AvgDurationCommand) {
                System.out.println("Average duration: " + cmd.execute(cols, rows));
            }
        }
    }
}
