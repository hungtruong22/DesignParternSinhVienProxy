package proxy;

import java.util.ArrayList;
import java.util.HashMap;

import dao.SinhVienRepository;
import model.ISinhVienRepository;
import model.sinhvien;

public class sinhvienCacheProxy implements ISinhVienRepository{
	private ISinhVienRepository sv;
	private HashMap<String, ArrayList<sinhvien>> cacheAll = new HashMap<String, ArrayList<sinhvien>>();
	
	public sinhvienCacheProxy() {
		this.sv = new SinhVienRepository();
	}
	@Override
	public ArrayList<sinhvien> searchByKeyword(String keyword) {
		ArrayList<sinhvien> svien = cacheAll.get(keyword);
		if(svien == null) {
			// dùng sv kết nối máy chủ và lấy sinhvien
			svien = sv.searchByKeyword(keyword);
			// sau khi lấy thì lưu vào cache
			cacheAll.put(keyword, svien);
		}
		else {
			// đã có sẵn trong cache rồi
			System.out.println("Retrieved sinhvien '" + keyword + "' from cache.");
		}
		return svien;
	}
	
	public void reset() {
		cacheAll.clear();
	}
	
}
