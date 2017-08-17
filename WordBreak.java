/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author kailabillie
 */
public class WordBreak {

    public static void main(String[] args) {

        ArrayList<String> dictionary = new ArrayList<String>();
        dictionary.add("pear");
        dictionary.add("salmon");
        dictionary.add("foot");
        dictionary.add("prints");
        dictionary.add("footprints");
        dictionary.add("leave");
        dictionary.add("you");
        dictionary.add("sun");
        dictionary.add("girl");
        dictionary.add("enjoy");
        
        System.out.println(canSegment("youenjoy", dictionary));
        System.out.println(canSegment("youleavefootprints", dictionary));
        System.out.println(canSegment("salmonenjoyapples", dictionary));

    }

    public static boolean canSegment(String sentence, ArrayList<String> dictionary) {

        sentence = sentence.toLowerCase();
        
        if (dictionary.contains(sentence)) {
            return true;
        }
        
        int length = sentence.length();
        String finalSentence;
        
        for (int i = 1; i<length; i++) {
            String prefix = sentence.substring(0, i);
            if (dictionary.contains(prefix)) {
                String suffix = sentence.substring(i, length);
                boolean nextWords = canSegment(suffix, dictionary);
                if (nextWords != false) {
                    finalSentence = prefix + " " + nextWords;
                    return true;
                }
            }
        }

        return false;
    }

}
