/**
 * Given a string S and a constant K remove all the occurrence of consecutive K characters from the string.
Note that after removal of k consecutively repeating characters, if remnant string has consecutive K repeating characters, those should also be removed.
example: S = "abbcccb" and K = 3
output: "a"
example: S = "abbdcccb" and K = 3
output: "abbdb"

Solution :
1. get first k consecutive str and remove
2. remove all 

 */
public class removeAllOccurenceOfConsecutiveK {
    
    private static String removeOccurenceOfConsecutiveK(String str, int k){
        StringBuilder tempStringBuilder = new StringBuilder();
        int i=0;
        while(i < str.length()){
            System.out.println("Index i : "+i);
            char ch = str.charAt(i);
            System.out.println("Char : "+ ch);
            System.out.println("tempStringBuilder : "+tempStringBuilder);
            System.out.println("String : "+str);
            if(tempStringBuilder.isEmpty()){
                tempStringBuilder.append(ch);
            }
            else if(tempStringBuilder.charAt(0) == ch){
                tempStringBuilder.append(ch);
                if(tempStringBuilder.length()==k){
                    // remove substring
                    str = removeKSubstring(str, i, k);
                    i = i>k ? i-k-1 :-1;
                    tempStringBuilder = new StringBuilder().append(str.charAt(i+1));
                }
            }
            else {
                tempStringBuilder = new StringBuilder().append(ch);
            }
            i++;
        }

        return str;
    }

    private static String removeKSubstring(String str, int currentIndex,int k){
        return str.substring(0, currentIndex-k+1) + str.substring(currentIndex+1, str.length());
    }

    public static void main(String[] args) {
        System.out.println("Remove Occurence Of Consecutive K : "+ removeOccurenceOfConsecutiveK("abbcccb", 3));
    }
}
