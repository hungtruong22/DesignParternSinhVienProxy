package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ISinhVienRepository;
import model.sinhvien;

public class SinhVienRepository implements ISinhVienRepository{

	@Override
	public ArrayList<sinhvien> searchByKeyword(String keyword) {
			ArrayList<sinhvien> ds = new ArrayList<sinhvien>();
			try {
				//B1: ket noi vao csdl sinhvien
	    		KetNoi kn = new KetNoi();
	    		kn.KetNoi();
	    		
	    		//B2: lay du lieu ve
	    		String sql = "select * from sinhvien\r\n"
	    				+ "where ten like ?;";
	    		PreparedStatement cmd = null;
	    		cmd = kn.cn.prepareStatement(sql);
	    		cmd.setString(1, "%"+keyword+"%");				
	    		ResultSet rs = cmd.executeQuery();
	    		
	    		//B3: Duyet rs de luu vao
	    		while(rs.next()) {
	    			String masv = rs.getString("masv");
	    			String hodem = rs.getString("hodem");
	    			String ten = rs.getString("ten");
	    			ds.add(new sinhvien(masv, hodem, ten));
	    		}
	    		
	    		//B4: Dong cac doi tuong
	    		rs.close();
				kn.cn.close();
				return ds;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
	}
//	public static void main(String[] args) {
//		SinhVienRepository s = new SinhVienRepository();
//		System.out.println(s.searchByKeyword("Hùng"));
//	}
}
