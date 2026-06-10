public class JITCompiler {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 100_000_000; i++) {
			calculate();
		}
		
		System.out.println("Time : " + (System.currentTimeMillis() - start));
	}
	
	static int calculate() {
		return 10 * 20;
	}
}

