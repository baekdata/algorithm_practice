import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


public class test151 {
	public static void main(String[] arts){ 
		Set set = new HashSet(); // set�� �ߺ��� �ȵǰ�, ������ ����.
		set.add("lee");
		set.add("lee");
		set.add(new Integer(23));
		set.add("add");
		System.out.println(set);
		
		List list = new ArrayList();
		list.add("lee");
		list.add("lee");
//		list.set(0, "cho");
		System.out.println(list); // ����Ʈ�� ������ �ְ�, �ߺ� ����
		
		Vector v = new Vector(5);
		v.addElement("lee");
		v.add("lee");
		v.set(1, "cho");
		v.setElementAt("kim", 0);
		System.out.println(v);
		
		Map map = new HashMap(); // map�� ����ã��� ���, key�� �̿��Ͽ� value�� ã�� �� ������ key�� �ߺ� �ȵ�
		map.put("1", new Integer(3));
		map.put("2", "cho");
		map.put("10", "cho");
		System.out.println(map);
		System.out.println(map.containsKey("1"));
	}
}
