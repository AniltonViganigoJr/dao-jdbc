package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST #1: Seller - FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST #2: Seller - FindBy Department ===");
		List<Seller> sellers = sellerDao.findByDepartment(new Department(4, null));
		
		for(Seller s : sellers) {
			System.out.println(s.getName() + " | Department: " + s.getDepartment().getName() );
		}
		
		System.out.println("\n=== TEST #3: Seller - Find All ===");
		sellers = sellerDao.findAll();
		
		for(Seller s : sellers) {
			System.out.println(s.getName() + " | Department: " + s.getDepartment().getName() );
		}
		
		System.out.println("\n=== TEST #4: Seller - Insert One ===");
		seller = new Seller(null, "João Alfredo", "alfredo@gmail.com", sdf.parse("29/11/1953"), 1200.00, new Department(4,null));
		sellerDao.insert(seller);
		System.out.println("Inserted New Id: " + seller.getId());
	}
}