import com.google.gson.Gson;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) {
        String csvFile = "D:\\фотографии\\проекты\\RRR";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> allData = reader.readAll();
            List<Employee> employees = new ArrayList<>();

            for (String[] row : allData) {
                Employee emp = new Employee(
                        Integer.parseInt(row[0]),
                        row[1],
                        row[2],
                        row[3],
                        Integer.parseInt(row[4])
                );
                employees.add(emp);
            }

            Gson gson = new Gson();
            String json = gson.toJson(employees);
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
