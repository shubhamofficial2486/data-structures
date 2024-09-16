import java.util.*;
import java.util.Map.Entry;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

 */
public class SortByFrequency {
    
    public static String frequencySort(String s) {
        
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(frequencyMap.containsKey(ch)){
                frequencyMap.replace(ch, frequencyMap.get(ch)+1);
            }
            else{
                frequencyMap.put(ch, 1);
            }
        }
        System.out.println("Frequency Map : "+ frequencyMap);

        StringBuilder result = new StringBuilder();
        sortByValueMapDesc(frequencyMap).forEach((key, value) -> {
            StringBuilder str = new StringBuilder();
            for(int i=0; i<value; i++){
                str.append(key);
            }
            result.append(str.toString());
        });

        return result.toString();
    }

    public static Map<Character, Integer> sortByValueMapDesc(Map<Character, Integer> map){
        List<Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<Character, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        System.out.println("Result : "+ frequencySort("abbcce"));
    }
}
