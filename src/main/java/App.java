import csvlib.CSVReader;

import java.io.File;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) {
        String lol = "looooo\noooool";
        System.out.println(lol);
        URL url = new App().getClass().getResource("/" + "data.csv");
        File file = new File(url.getFile());
        CSVReader reader;
        try {
            reader = new CSVReader.Builder(file)
                    .strictSeparator(false)
                    .deleteWhitespaces(true)
                    .setRawMode(false)
                    .build();
            String s;
            int i = 0;
            while (reader.hasNextRow() && i<50) {
                System.out.print(++i + ":");
                List<String> row = reader.getRow();
                for (String str : row) {
                    System.out.print(str+" ");
                }
                System.out.println(" | "+row.size()+" fields");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
