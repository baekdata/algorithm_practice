import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


public class test151 {
	public static void main(String[] arts){ 
		Set set = new HashSet(); // set은 중복이 안되고, 순서도 없다.
		set.add("lee");
		set.add("lee");
		set.add(new Integer(23));
		set.add("add");
		System.out.println(set);
		
		List list = new ArrayList();
		list.add("lee");
		list.add("lee");
//		list.set(0, "cho");
		System.out.println(list); // 리스트는 순서가 있고, 중복 가능
		
		Vector v = new Vector(5);
		v.addElement("lee");
		v.add("lee");
		v.set(1, "cho");
		v.setElementAt("kim", 0);
		System.out.println(v);
		
		Map map = new HashMap(); // map은 사전찾기와 비슷, key를 이용하여 value를 찾을 수 있으나 key는 중복 안됨
		map.put("1", new Integer(3));
		map.put("2", "cho");
		map.put("10", "cho");
		System.out.println(map);
		System.out.println(map.containsKey("1"));
	}
}
