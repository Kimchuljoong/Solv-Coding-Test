import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<TestObj, Integer> tMap = new HashMap<>();
		
		tMap.put(new TestObj(), 1);
		
		for(TestObj t: tMap.keySet()) {
			System.out.println(t.hashCode());
			
			System.out.println(t);
			
			t.T = 2;
			System.out.println(t.hashCode());
			
			System.out.println(t);
			
		}
		
		
	}
	
	static class TestObj {
		
		private Integer T;
		
		public TestObj() {
			
		}
		
		public TestObj(Integer T) {
			this.T = T;
		}
		
		
	}

}
