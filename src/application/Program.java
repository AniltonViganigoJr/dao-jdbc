package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST #1: Seller - FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST #2: Seller - FindBy Department ===");
		List<Seller> sellers = sellerDao.findByDepartment(new Department(1, null));
		
		for(Seller s : sellers) {
			System.out.println(s.getName() + " | Department: " + s.getDepartment().getName() );
		}
	}
}