import java.io.*;
import java.util.*;

public class Task2 {

    private static Map<String, Double> getCircle(String file) {

        Map<String, Double> circle = new LinkedHashMap<>();

        try (BufferedReader circleFile = new BufferedReader(new FileReader(file))) {
            String[] line = circleFile.readLine().split(" ");

            circle.put("x", Double.parseDouble(line[0]));
            circle.put("y", Double.parseDouble(line[1]));
            circle.put("r2", Math.pow(Double.parseDouble(circleFile.readLine()), 2));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return circle;
    }

    private static List<double[]> getPoints(String file) {

        List<double[]> points = new LinkedList<>();

        try (BufferedReader pointsFile = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = pointsFile.readLine()) != null) {
                double[] point = new double[]{
                        Double.parseDouble(line.split(" ")[0]),
                        Double.parseDouble(line.split(" ")[1])
                };
                points.add(point);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return points;
    }

    private static List<Integer> createPositions(Map<String, Double> circle, List<double[]> points) {

        List<Integer> positionList = new LinkedList<>();

        for (double[] point : points) {

            double diff = Math.pow(point[0] - circle.get("x"), 2) +
                    Math.pow(point[1] - circle.get("y"), 2) -
                    circle.get("r2");

            if (diff > 0) positionList.add(2);
            else if (diff == 0) positionList.add(0);
            else positionList.add(1);
        }
        return positionList;
    }

    public static void main(String[] args) {

        Map<String, Double> circle = getCircle(args[0]);
//        System.out.printf("circleX = %f\ncircleY = %f\ncircleR2 = %f\n", circle.get("x"), circle.get("y"), circle.get("r2"));

        List<double[]> points = getPoints(args[1]);
//        for (double[] point : points) System.out.println(Arrays.toString(point));

        List<Integer> positionList = createPositions(circle, points);
        positionList.forEach(System.out::println);
    }
}
