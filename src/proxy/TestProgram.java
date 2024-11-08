package proxy;

import dao.SinhVienRepository;

public class TestProgram {
	public static void main(String[] args) {
		sinhvienHienThi svht = new sinhvienHienThi(new SinhVienRepository());
		sinhvienHienThi sinhvienht = new sinhvienHienThi(new sinhvienCacheProxy());
		long s1 = test(svht);
		long s2 = test(sinhvienht);
		
		System.out.println("Time saved by caching proxy: " + (s1 - s2) + "ms");
	}
	
	private static long test(sinhvienHienThi htsv) {
		long startTime = System.currentTimeMillis();
		// User behavior in our app:
		htsv.renderSinhVienList("Hiếu");
//		htsv.renderSinhVienList("Hùng");
		// Users might visit the same page quite often.
//		System.out.println("holaaahaloo");
		htsv.renderSinhVienList("Hùng");
//		htsv.renderSinhVienList("Tr");
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.print("Time elapsed: " + estimatedTime + "ms\n");
		return estimatedTime;
	}

}
