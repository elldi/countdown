/**
 * Created by elliot on 20/11/2017.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindWordsQuicker {

    private static String removeLetter2(String letters, String word){

        int startCount = letters.length();
        int index = 0;
        while(index < startCount)
            word = word.replaceFirst(((Character) letters.charAt(index++)).toString(), "");
        return word;

    }

    public static void main(String[] args) {

        String fileName = "./Words/words_alpha.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(list.size());

        String theLetters = "xigafoben";
        java.util.UUID.fromString("234234werwer");

        System.out.println("Length of input word: " + theLetters.length());

        List<String> output = new ArrayList<>();
        int check = Integer.MIN_VALUE;

        list.forEach(x -> removeLetter2(theLetters,x));

        StringBuilder testing = new StringBuilder();
        list.forEach(x -> testing.append(x));


        for(String element : list) {
            String leftOver = removeLetter2(theLetters, element);

            if(leftOver.length() == 0){

                if(element.length() > check){
                    output.clear();
                    output.add(element);
                    check = element.length();
                }
                else if(element.length() == check)
                    output.add(element);
            }
        }

        System.out.println("------------");
        output.forEach(System.out::println);
        if(output.size() > 0 ) System.out.println(output.get(0).length() + " letters");
    }
}