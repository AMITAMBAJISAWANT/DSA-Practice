class Solution {
    public String makeFancyString(String s) {
        char c = s.charAt(0);
        int C = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        for( int i = 1; i < s.length(); i++ ){
            if(c != s.charAt(i)){
                c = s.charAt(i);
                C = 0;
            }
            C++;
            if(C > 2){
                continue;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

public class FancyString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "aaabaaaa";
        String result = sol.makeFancyString(input);
        System.out.println("Result: " + result);
    }
}
