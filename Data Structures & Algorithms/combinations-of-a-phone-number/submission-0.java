class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<>();
        
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()){
            return list;
        }
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        DFS(map,digits,0,list,"");

        return list;
    }
    public static void DFS(Map<Integer,String> map ,String digits ,int i ,List<String> list ,String s){
        if(i == digits.length()){
            list.add(s);
            return;
        }
        String str = map.get(digits.charAt(i) - '0');
        for(int j = 0;j < str.length();j++){
            s += str.charAt(j);
            DFS(map,digits,i + 1,list, s);
            s = s.substring(0, s.length() - 1);
        }

    }
}
