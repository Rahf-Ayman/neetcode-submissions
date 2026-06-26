class Solution {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> table = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            table.put(s.charAt(i) , i + 1);
        }
        int maxsub = 0;
        int len = 0;
        for(int i = 0;i < s.length();i++){
            len++;
            maxsub = Math.max(maxsub, table.get(s.charAt(i)));
            if(maxsub == i + 1){
                list.add(len);
                len = 0;
            }

        }
        return list;
    }
}
