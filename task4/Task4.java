import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {

    private static List<Integer> getElements(String file) {

        List<Integer> elements = new ArrayList<>();

        try (BufferedReader elementsFile = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = elementsFile.readLine()) != null) {
                elements.add(Integer.parseInt(line));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return elements;
    }

    public static void main(String[] args) {

        List<Integer> elements = getElements(args[0]);
        Collections.sort(elements);

        int midIndex = elements.size() / 2;
        int turns = 0;

        for (Integer element : elements) {
            turns += Math.abs(element - elements.get(midIndex));
        }
        System.out.print(turns);
    }
}
