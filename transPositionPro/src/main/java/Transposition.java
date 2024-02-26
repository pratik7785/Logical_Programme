import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Transposition {

    public static int[][] readJSONFile(String fileName) throws IOException {
        int[][] musicalPiece = null;

        try (FileReader fileReader = new FileReader(fileName)) {

            String jsonString = new Scanner(fileReader).useDelimiter("\\A").next();

            JSONArray jsonArray = new JSONArray(new JSONTokener(jsonString));

            int length = jsonArray.length();
            musicalPiece = new int[length][2];

            for (int i = 0; i < length; i++) {
                JSONArray jsonArrayElement = jsonArray.getJSONArray(i);
                int[] note = new int[2];
                note[0] = jsonArrayElement.getInt(0);
                note[1] = jsonArrayElement.getInt(1);
                musicalPiece[i] = note;
            }
        } catch (JSONException e) {
            throw new IOException("Error reading JSON file", e);
        }

        return musicalPiece;
    }

    public static void writeJSONFile(String fileName, int[][] musicalPiece) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            JSONArray jsonArray = new JSONArray();

            for (int[] note : musicalPiece) {
                JSONArray jsonArrayElement = new JSONArray(note);
                jsonArray.put(jsonArrayElement);
            }

            fileWriter.write(jsonArray.toString());
        } catch (JSONException e) {
            throw new IOException("Error writing JSON file", e);
        }
    }

    public static int[][] transposeMusicalPiece(int[][] musicalPiece, int semitones) {
        int[][] transposedMusicalPiece = new int[musicalPiece.length][2];

        for (int i = 0; i < musicalPiece.length; i++) {
            int[] transposedNote = transposeNote(musicalPiece[i], semitones);
            if (transposedNote != null) {
                transposedMusicalPiece[i] = transposedNote;
            } else {

                System.err.println("Error: Transposed note is out of range. Check input musical piece.");
                return null;
            }
        }

        return transposedMusicalPiece;
    }

    public static int[] transposeNote(int[] note, int semitones) {
        int totalNoteNumber = note[0] * 12 + note[1];
        int transposedNoteNumber = totalNoteNumber + semitones;

        if (0 <= transposedNoteNumber && transposedNoteNumber <= 87) {
            int transposedOctave = transposedNoteNumber / 12;
            int transposedNote = transposedNoteNumber % 12;
            return new int[]{transposedOctave, transposedNote};
        } else {

            return null;
        }
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the input JSON file name: ");
            String inputFileName = scanner.nextLine();

            System.out.print("Enter the number of semitones to transpose: ");
            int semitones = scanner.nextInt();


            int[][] musicalPiece = readJSONFile(inputFileName);

            if (musicalPiece != null) {
                int[][] transposedMusicalPiece = transposeMusicalPiece(musicalPiece, semitones);

                if (transposedMusicalPiece != null) {
                    System.out.print("Enter the output JSON file name: ");
                    String outputFileName = scanner.next();

                    try {
                        writeJSONFile(outputFileName, transposedMusicalPiece);
                        System.out.println("Transposition successful. Output written to " + outputFileName);
                    } catch (IOException e) {
                        System.err.println("Error writing JSON file: " + e.getMessage());
                    }
                } else {
                    System.err.println("Error during transposition. Check input musical piece.");
                }
            } else {
                System.err.println("Error reading JSON file. Check file format and content.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
