/**
1614. Maximum Nesting Depth of the Parentheses

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation:
Digit 8 is inside of 3 nested parentheses in the string.

Example 2:
Input: s = "(1)+((2))+(((3)))"
Output: 3
Explanation:
Digit 3 is inside of 3 nested parentheses in the string.

Example 3:
Input: s = "()(())((()()))"
Output: 3
*/
public class MaximumNestingDepth {
    
    public static int maxDepth(String s) {

        int maximumDepth = 0;
        int temp = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                temp+=1;
            }
            else if(ch == ')'){
                if(temp > maximumDepth){
                    maximumDepth = temp;
                }
                if(temp > 0){
                    temp-=1;
                }
            }
        }
        return maximumDepth;
    }

    public static void main(String[] args) {
        System.out.println("Maximum Depth : "+ maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
