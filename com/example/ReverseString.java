import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reverses the string.
 *
 * @author Kevin Csiffary
 * @version 1.0
 * @since 2024-04-30
 */

// ReverseString class
public final class ReverseString {

  /** Private constructor to prevent instantiation. */
  private ReverseString() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    try {
      // Setup scanner on file.
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);
      // Setup writer for output file.
      FileWriter Writer = new FileWriter("output.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(Writer);

      while (sc.hasNextLine()) {
        // Read the line from file.
        String line = sc.nextLine();

        // Call reverseString and write to file.
        String test = reverseString(line);
        bufferedWriter.write(test);
        bufferedWriter.newLine();
      }

      // Close all writers and scanner.
      bufferedWriter.close();
      Writer.close();
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String reverseString(final String string) {
    // If the string is only one character, return that character.
    if (string.length() <= 1) {
      return string;
    } else {
      // Remove last character of the string
      final String shortString = string.substring(0, string.length() - 1);
      // Return, last character in string + Recursive call (with short string).
      return string.charAt(string.length() - 1) + reverseString(shortString);
    }
  }
}
