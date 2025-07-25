package hashMap;

import java.util.HashMap;
import java.util.Set;

public class HashMapIntro {

	public HashMapIntro() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating HashMap
		HashMap<String,Integer> map=new HashMap<>();
		//Insert O(1)
		map.put("india", 120);
		map.put("china ", 100);
		//Get O(1)
		System.out.println(map.get("india"));
		//Contains Key O(1)
		System.out.println(map.containsKey("india"));
		System.out.println(map.containsKey("usa"));
		
		//contains value 
		System.out.println(map.containsValue(120));
		//remove
		map.remove("india");
		System.out.println(map.get("india"));
		//size
		System.out.println(map.size());
		//isEmpty
		System.out.println(map.isEmpty());
		//clear - makes the map empty
		map.clear();
		map.put("india", 120);
		map.put("china ", 100);
		map.put("korea", 10);
		map.put("russia ", 50);
		
		//iteration on hashmap
		Set<String> keys=map.keySet();
		System.out.println(keys);
		for(String key:map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		

	}

}
