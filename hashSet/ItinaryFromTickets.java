package hashSet;

import java.util.HashMap;

public class ItinaryFromTickets {
	public static String getStart(HashMap<String,String> tickets) {
		HashMap<String,String> revMap=new HashMap<>();
		for(String key:tickets.keySet()) {
			revMap.put(tickets.get(key), key);
		}
		for(String key:tickets.keySet()) {
			if(!revMap.containsKey(key)) {
				return key;
			}
		}
		return "";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> map=new HashMap<>();
		map.put("Chennai", "Bengaluru");
		map.put("Mumbai", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");

		String sp=getStart(map);
		System.out.print(sp+" ");
		while(map.containsKey(sp)) {
			System.out.print(map.get(sp)+" ");
			sp=map.get(sp);
		}
	}

}
