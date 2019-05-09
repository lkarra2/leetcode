package main.java.leetcode;

public class LongestSubString {

    String s, t;

    public LongestSubString(String s, String t) {
        this.s = s;
        this.t = t;
    }

    // Function to find longest substring using memoization
    private int findLCS(int length1, int length2) {
        int[][] mem = new int[length1+1][length2+1];
        int max = 0;
        for(int i = 0; i <= length1; i++) {
            for(int j = 0; j <= length2; j++) {
                if(i == 0 || j == 0)
                    mem[i][j] = 0;
                else if(s.charAt(i-1) == t.charAt(j-1)) {
                    mem[i][j] = mem[i - 1][j - 1] + 1;
                    if(mem[i][j] > max)
                        max = mem[i][j];
                }
                else
                    mem[i][j] = 0;
            }
        }
        return max;
    }

    // Function to find longest substring using recursion
    private int findLongestSubString(int slen, int tlen, int max) {
        if(slen == 0 || tlen == 0) {
            return max;
        }
        if(s.charAt(slen-1) == t.charAt(tlen-1)) {
            max = findLongestSubString(slen - 1, tlen - 1, max + 1);
        }
        max = Math.max(max, Math.max(findLongestSubString(slen-1, tlen, 0), findLongestSubString(slen, tlen-1, 0)));
        return max;
    }


    public static void main(String[] args) {
        String s = "yasbxuecdiabcdefghij";
        String t = "scxiuwdbcyyabcdefghijisaywh";
        LongestSubString ls = new LongestSubString(s, t);
        //System.out.println("Longest substring = " + ls.findLongestSubString(s.length(), t.length(), 0));
        System.out.println("Longest Common Substring using memoization: " + ls.findLCS(s.length(), t.length()));
    }
}
