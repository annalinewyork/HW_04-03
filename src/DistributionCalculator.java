/**
 * Created by c4q-nali on 4/6/15.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DistributionCalculator {
    public static ArrayList<Double> calculate(File textFile) throws FileNotFoundException {

        int totalNumberOfCharacters = 0;
        int[] count = new int[26];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        Scanner input = new Scanner(textFile);

        ArrayList<Double> percentages = new ArrayList<Double>();

        while (input.hasNext()) {
            String word = input.next();
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) {
                    char letter = Character.toLowerCase(word.charAt(i));
                    totalNumberOfCharacters++;
                    count[(int) letter - 97]++;
                }
            }

        }

        for (int i = 0; i < count.length; i++) {
            double percentage;
            if (count[i] == 0) {
                percentage = 0;
            }
            else {
                percentage = (count[i]*100) / totalNumberOfCharacters;
            }
            percentages.add(percentage);
        }
        return percentages;
    }

    public static void main(String[] args) throws FileNotFoundException {


        String fileName = "~/Desktop/accesscode/HW_20150403/src/nyc.c4q.annalinewyork/babysick.txt";
        //this is the file inside this project, but the link seems not working.
        File file = new File(fileName);

        ArrayList<Double> percentage = calculate(file);

        int letter = 97;
        for (Double probability : percentage) {
            System.out.print((char) letter + " = ");
            System.out.println(probability);
            letter++;
        }


    }
}
