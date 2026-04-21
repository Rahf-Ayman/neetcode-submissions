class Solution {
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        List<String> path = new LinkedList<>();
        for(List<String> ticket: tickets){
            String from = ticket.getFirst();
            String to = ticket.getLast();
            if(!adj.containsKey(from)){
                adj.put(from,new PriorityQueue<>());
            }
            adj.get(from).add(to);
        }

        dfsFind(adj,"JFK",path);
        return path;
    }
    public static void dfsFind(Map<String,PriorityQueue<String>> adj ,String node ,List<String> path){
        
        while(adj.containsKey(node) && !adj.get(node).isEmpty()){
            String next = adj.get(node).poll();
            dfsFind(adj,next,path);
        }
        path.add(0,node);
    }

}

