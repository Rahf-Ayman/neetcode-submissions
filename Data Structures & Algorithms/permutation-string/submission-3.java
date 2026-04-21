class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int l = 0;
        Map<Character ,Integer> freq = new HashMap<>();
        for(int i = 0;i < s1.length();i++){
            freq.put(s1.charAt(i), freq.getOrDefault(s1.charAt(i) , 0) + 1);
        }
        Map<Character ,Integer> freqW = new HashMap<>();
        for(int i = 0;i < s2.length();i++){
            freqW.put(s2.charAt(i), freqW.getOrDefault(s2.charAt(i) , 0) + 1);
            while(freqW.get(s2.charAt(i)) > freq.getOrDefault(s2.charAt(i) , 0)){
                freqW.put(s2.charAt(l), freqW.getOrDefault(s2.charAt(l) , 0) - 1);
                l++;
            }
            if(i - l + 1 == s1.length()){
                return true;
            }
        }
        return false;
    }
}
