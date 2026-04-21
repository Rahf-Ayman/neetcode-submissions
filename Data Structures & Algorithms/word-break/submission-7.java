class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return dfsWordBreak(0,s,wordDict,memo);
    }

    public boolean dfsWordBreak(int i,String s, List<String> wordDict,Boolean[] memo){
        if(i >= s.length()) return true;
        if(memo[i] != null) return memo[i];
        for(String ss : wordDict){
            if(i + ss.length() <= s.length()){
                String sub = s.substring(i, i + ss.length());
                if(sub.equals(ss)){
                    if(dfsWordBreak(i + ss.length(),s,wordDict,memo)){
                        memo[i] = true;
                        return true;
                    }
                }
            }

        }
        memo[i] = false;
        return false;
    }
}
