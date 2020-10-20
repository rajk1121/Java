/*
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
*/
class is_subsequence{
	public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        if(s.length()==0)
            return true;
        if(s.length()>t.length())
            return false;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                if(i==s.length()-1)
                    return true;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return false;
    }
}