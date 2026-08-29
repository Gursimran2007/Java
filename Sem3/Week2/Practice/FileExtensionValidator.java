/**
 * Problem 3 - File Extension Validator (Assignment Upload Portal)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class FileExtensionValidator {

    static final String[] ACCEPTED = { "pdf", "docx", "zip" };

    /* Extracts the extension after the last dot and matches it case-insensitively. */
    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected - invalid file type";      // no dot, or nothing after it
        }

        String extension = filename.substring(dotIndex + 1);

        for (String accepted : ACCEPTED) {
            if (extension.equalsIgnoreCase(accepted)) {
                return "Accepted";
            }
        }
        return "Rejected - invalid file type";
    }

    public static void main(String[] args) {
        String[] uploads = { "Assignment1.PDF", "notes.txt", "report.docx",
                             "archive.ZIP", "README" };

        for (String filename : uploads) {
            System.out.println(filename + "  ->  " + validateFileExtension(filename));
        }
    }
}
