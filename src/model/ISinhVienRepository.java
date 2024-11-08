package model;

import java.util.ArrayList;

public interface ISinhVienRepository {
	 ArrayList<sinhvien> searchByKeyword(String keyword);
}
