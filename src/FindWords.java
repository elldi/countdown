/**
 * Created by elliot on 20/11/2017.
 */
import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindWords {

    static Pair<String,String> myTemp;

    public static int removeLetter(String letters, String word) {
        myTemp = new Pair<>(letters,word);

        for (int x = 0; x < letters.length(); x++) {
            if (word.contains(((Character) letters.charAt(x)).toString())) {

                String tempLetters = letters.replaceFirst(((Character) letters.charAt(x)).toString(), "");

                String tempWord = word.replaceFirst(((Character) letters.charAt(x)).toString(), "");

                if (letters.length() != 0) {
                    removeLetter(tempLetters, tempWord);
                }
            }
        }
        return 0;
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

        //String[] dictionary = {"dog", "toes", "toe", "god", "banana", "testing", "elliot", "nana", "ell"};

        List<Pair<String,String>> finRes = new ArrayList<>();

        double counter = 0;
        double mySize = list.size();
        for(String element : list){
            removeLetter("adam", element);
            finRes.add(new Pair<>(element, myTemp.getValue()));
            counter++;
            if(counter % 10000 == 0)
                System.out.println((counter/mySize)*100);
        }

        List<String> output = new ArrayList<>();
        int check = Integer.MIN_VALUE;

        for(Pair<String,String> element : finRes){

            if(element.getValue().length() == 0){

                if(element.getKey().length() > check){
                    output.clear();
                    output.add(element.getKey());
                    check = element.getKey().length();
                }
                else if(element.getKey().length() == check)
                    output.add(element.getKey());

            }
        }

        System.out.println("------------");
        output.forEach(System.out::println);


    }

}