import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    public static void main(String[] args) throws IOException {
        int challenge1Answer = challenge1("InputOneTwo.txt");
        System.out.println(challenge1Answer);
        int challenge2Answer = challenge2("InputOneTwo.txt");
        System.out.println(challenge2Answer);
        int challenge3Answer = challenge3("InputThreeFour.txt");
        System.out.println(challenge3Answer);
        int challenge4Answer = challenge4("InputThreeFour.txt");
        System.out.println(challenge4Answer);

        writeAllAnswersToFile("AdventureTime.txt", challenge1Answer, challenge2Answer, challenge3Answer, challenge4Answer);
    }

    public static int challenge1(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int count = 0;
        int lastNumber = -1;
        while(scanner.hasNextLine()){
            int currentNumber = scanner.nextInt();
            if(lastNumber == -1) {

            }else{
                if(currentNumber > lastNumber) {
                    count++;
                }
            }
            lastNumber = currentNumber;
        }
        return count;
    }

    public static int challenge2(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int num1 = 0, num2 = 0, num3 = 0;
        int lastSum = 0;
        int pos = 0;
        int count = 0;
        while(scanner.hasNextLine()){
            num1 = num2;
            num2 = num3;
            num3 = scanner.nextInt();
            if(pos > 2){
                if(num1 + num2 + num3 > lastSum){
                    count++;
                }
                lastSum = num1 + num2 + num3;
            }
            pos++;
        }
        return count;
    }

    public static int challenge3(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int horizontal = 0, vertical = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String word = "";
            int distance = 0;
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){
                    distance = distance * 10 + line.charAt(i) - '0';
                }else if(line.charAt(i) != ' '){
                    word += line.charAt(i);
                }
            }
            if(word.equals("forward")) horizontal += distance;
            else if(word.equals("up")) vertical -= distance;
            else if(word.equals("down")) vertical += distance;
        }
        return horizontal * vertical;
    }

    public static int challenge4(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int horizontal = 0, vertical = 0, aim = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String word = "";
            int distance = 0;
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){
                    distance = distance * 10 + line.charAt(i) - '0';
                }else if(line.charAt(i) != ' '){
                    word += line.charAt(i);
                }
            }
            if(word.equals("forward")){
                horizontal += distance;
                vertical += distance * aim;
            }else if(word.equals("down")) aim += distance;
            else if(word.equals("up")) aim -= distance;
        }
        return horizontal * vertical;
    }

    private static void writeAllAnswersToFile(String outputFilename, int challenge1, int challenge2, int challenge3, int challenge4) throws IOException {
        File file = new File(outputFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challenge1 + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challenge2 + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challenge3 + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challenge4 + "\n");
        bufferedWriter.close();
    }

    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}