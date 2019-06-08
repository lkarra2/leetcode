package main.java.amazon;

import java.util.Arrays;

class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int prev = 0, maxlen = 1, curlen = 1;
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        int[] visited = new int[256];
        Arrays.fill(visited, -1);
        visited[s.charAt(0)] = 0;

        for(int i = 1; i < s.length(); i++) {
            prev = visited[s.charAt(i)];
            if(prev == -1 || i-curlen > prev) {
                curlen++;
            } else {
                if(curlen > maxlen)
                    maxlen = curlen;
                curlen = i-prev;
            }
            visited[s.charAt(i)] = i;
        }
        if(curlen > maxlen)
            maxlen = curlen;
        return maxlen;
    }

    public static void main(String[] args)
    {
        String str = "ABDEFGABEF";
        System.out.println("The input string is " + str);
        int len = lengthOfLongestSubstring(str);
        System.out.println("The length of "
                + "the longest non repeating character is " + len);
    }
}