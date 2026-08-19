

import java.io.*; 
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
 
public class GradeAnalyzer {
    static int invalidLines = 0;
    public static void main(String[] args) {
        // Step 1: read scores from file
        String filename = "scores.txt";
        String outputFile = "report.txt";
        
        ArrayList<Integer> scores = readScores(filename);
        if (scores.isEmpty()) {
            System.out.println("No valid scores found in the file.");
            return;
        }
        // } catch (IOException E){
        //     System.out.println("file error:" + E.getMessage());
        // }
        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        // Step 3: write and print report
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }
        writeReport(scores,invalidLines, avg, highest, lowest, outputFile);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null){
                line = line.trim();
                if (line.isEmpty()){
                    continue;
                }
                System.out.println(line);
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                }
                catch (NumberFormatException E){
                    System.out.println("invalid score:" + line);
                    invalidLines++;
                }
            }
        } catch (IOException E) {
            System.out.println("file error:" + E.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, int invalidLines,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }
        String report = String.format("=== Grade Analysis Report ===\nTotal scores processed:  %d\nInvalid lines skipped:  %d\n\n" +
            "Average score: %.2f\nHighest score: %d\nLowest score:  %d\n\nGrade distribution:\nA (100-90):  %d\nB (89-80):  %d\nC (79-70):  %d\nD (69-60):  %d\nF (<60):  %d",
            scores.size(), invalidLines, avg, high, low, countA, countB, countC, countD, countF);
        System.out.println(report);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
} 