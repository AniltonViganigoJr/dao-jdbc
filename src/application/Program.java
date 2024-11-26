package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
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
		seller = new Seller(null, "Quixote Cusco de Souza", "quixote@gmail.com", sdf.parse("22/12/2012"), 3000.00, new Department(3,null));
		sellerDao.insert(seller);
		System.out.println("Inserted New Id: " + seller.getId());
		
		System.out.println("\n=== TEST #5: Seller - Update Seller ===");
		seller = sellerDao.findById(1);
		seller.setName("Ronaldo Nazário de Lima");
		seller.setEmail("nazario@hotmail.com");
		seller.setBaseSalary(350000.00);
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST #6: Seller - Delete By Id ===");
		System.out.print("Enter ID to Delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		
		sc.close();
	}
}