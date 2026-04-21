class Solution {
    public int characterReplacement(String s, int k) {
        int freq [] = new int[26];
        int max = 0;
        int left = 0;
        int right = 0;
        int lenght = 0;
        
        for(right = 0;right < s.length();right++){
            freq[s.charAt(right) - 'A']++;
            if(freq[s.charAt(right) - 'A'] > max){
                max = freq[s.charAt(right) - 'A'];
            }
            while((right - left + 1 - max) > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            lenght = Math.max(lenght , right - left + 1);
        }
        return lenght;
    }
}
