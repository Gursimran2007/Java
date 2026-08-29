/**
 * Problem 2 - CSV Student Record Parser (T&P Registration Data)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class CsvStudentRecordParser {

    /* Splits a CSV line into exactly 3 fields and prints a formatted record. */
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name       = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        String[] lines = {
                "Ananya Verma,RA2211003010123,CSE",
                "Ananya Verma,CSE",
                "Gursimran Bajwa,RA2511003011289,CSE"
        };

        for (String line : lines) {
            System.out.println("Input: \"" + line + "\"");
            parseStudentRecord(line);
            System.out.println();
        }
    }
}
