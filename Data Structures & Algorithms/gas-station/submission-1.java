class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        for(int i = 0;i < gas.length;i++){
            totalTank += gas[i] - cost[i];
        }
        if(totalTank < 0){
            return -1;
        }
        int currentTank = 0;
        int startIndex = 0;
        for(int i = 0;i < gas.length;i++){
            currentTank += gas[i] - cost[i];
            if(currentTank < 0){
                currentTank = 0;
                startIndex = i + 1;
            }
        }
        return startIndex;
    }
}
