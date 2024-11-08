package proxy;

import java.util.ArrayList;

import model.ISinhVienRepository;
import model.sinhvien;

public class sinhvienHienThi {
	private ISinhVienRepository api;
	public sinhvienHienThi(ISinhVienRepository api) {
		this.api = api;
	}
	public void renderSinhVienList(String keyword) {
		ArrayList<sinhvien> svien = api.searchByKeyword(keyword);
		for(sinhvien s : svien) {
			System.out.println("\n-------------------------------");
			System.out.println("SinhVien List");
			System.out.println("MaSV: " + s.getMsv());
			System.out.println("HoDem: " + s.getHodem());
			System.out.println("Ten: " + s.getTen());
			System.out.println("-------------------------------\n");
		}
		
	}

}
