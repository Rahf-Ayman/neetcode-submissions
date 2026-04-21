class Solution {
    public static String minWindow(String s, String t) {
        int l = 0;
        int minL = 0;
        int minR = 0;
        int minLen = Integer.MAX_VALUE;
        int num = 0;
        if (t.isEmpty()) return "";
        Map<Character ,Integer> freq = new HashMap<>();
        for(int i = 0;i < t.length();i++){
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i) , 0) + 1);
        }
        int required = freq.size();
        Map<Character ,Integer> freqW = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            freqW.put(s.charAt(i), freqW.getOrDefault(s.charAt(i) , 0) + 1);
            if(freq.containsKey(s.charAt(i)) && freqW.get(s.charAt(i)).equals(freq.get(s.charAt(i)))){
                num++;
            }
            while(required == num){
                if((i - l + 1) < minLen){
                    minLen = i - l + 1;
                    minL = l;
                    minR = i;
                }
                freqW.put(s.charAt(l), freqW.getOrDefault(s.charAt(l) , 0) - 1);
                if(freq.containsKey(s.charAt(l)) && freqW.get(s.charAt(l)) < freq.get(s.charAt(l))){
                    num--;
                } 
                l++;
            }

        }
    
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }
}
