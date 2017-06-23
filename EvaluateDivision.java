public class Solution{
	public double[] calcEquation(String[][] equations, double[]values, String[][]queries){
		double[] res = new double[queries.length];
		if(equations.length == 0) return res;
		Map<String,List<Edge>> adjs = new HashMap();
		for(int i=0;i<equations.length;i++){
			String v = equations[i][0];
			String u = equations[i][1];
			Edge ef = new Edge(u,values[i]);
			Edge eb = new Edge(v,1.0/values[i]);
			if(adjs.containsKey(v)){
				adjs.get(v).add(ef);
			}else{
				List<Edge> adjsV = new ArrayList<>();
				adjsV.add(ef);
				adjs.put(v,adjsV);
			}
			if(adjs.containsKey(u)){
				adjs.get(u).add(eb);
			}else{
				List<Edge> adjsV = new ArrayList<>();
				adjsV.add(eb);
				adjs.put(u,adjsU);
			}
		}

		for(int i=0; i<queries.length;i++){
			String s = queries[i][0];
			String t = queries[i][1];
			Set<String> visited = new HashSet<>();
			dfs(adjs,visited,s,t,1.0,i,res);
			if(res[i]==0 && s!=t) res[i] = -1.0;
		}
		return res;
	}

	private void dfs(Map<String,List<Edge>>adjs, Set<String>visited,String s, String t
		double distance, int index, double[] res){
		if(s.equals(t)){
			return distance;
		}
		if(visited.contains(s)) return;
		visited.add(s);
		if(!adjs.containsKey(s) || !adjs.containsKey(t)){
			res[index] = -1.0;
		}
		List<Edge> adjsV = adjs.get(s);
		Iterator<Edge> iter = adjsV.iterator();
		while(iter.hasNext()){
			Edge e = iter.next();
			dfs(adjs,visited,e.to,t,distance*e.weight,index,res);
		}
	}
}

class Edge{
	String to;
	double weigh;
	public Edge(String t, double w){
		to = t;
		weigh =w;
	}
}