/**
 * longestNonRepeatingSubstring
 * String = "ABCBC";

Return the longest non repeating substring
(Sliding window pattern)
 */
public class longestNonRepeatingSubstring {

    private static String getNonRepeatingString(String str){

        StringBuilder longestNonRepeatingSubstring = new StringBuilder();
        StringBuilder currentNonRepeatingString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println(ch);
            int characterIndex = currentNonRepeatingString.toString().indexOf(ch);
            System.out.println("characterIndex : "+characterIndex);
            if (characterIndex != -1){
                currentNonRepeatingString = (characterIndex == 0) ? currentNonRepeatingString.deleteCharAt(0) : currentNonRepeatingString.delete(0, characterIndex+1);
                currentNonRepeatingString.append(ch);
            }
            else {
                currentNonRepeatingString = currentNonRepeatingString.append(ch);
            }
            if (currentNonRepeatingString.length() > longestNonRepeatingSubstring.length()){
                longestNonRepeatingSubstring = new StringBuilder(currentNonRepeatingString.toString());
            }
            System.out.println("currentNonRepeatingString : "+currentNonRepeatingString);
            System.out.println("longestNonRepeatingSubstring : "+longestNonRepeatingSubstring);
        }
        return longestNonRepeatingSubstring.toString();
    
        
    }
    public static void main(String[] args) {
        System.out.println("Longest Non Repeating Substring : "+ getNonRepeatingString("abcbac"));
    }
}