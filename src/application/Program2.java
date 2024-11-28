package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST #1: Department - FindById ===");
		Department dept = departmentDao.findById(4);
		System.out.println(dept);
		
		System.out.println("\n=== TEST #2: Department - Find All ===");
		List<Department> departments = departmentDao.findAll();
		for(Department d : departments) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST #3: Department - Insert One ===");
		System.out.print("Enter Department name: ");
		String deptname = sc.nextLine();
		Department newDept = new Department();
		
		if (!deptname.isEmpty()) {
			newDept.setName(deptname);
			departmentDao.insert(newDept);
		}
		
		System.out.println("\n=== TEST #4: Department - DeleteById ===");
		System.out.print("Enter Id that will be deleted: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);

		System.out.println("\n=== TEST #5: Department - Update One ===");
		System.out.print("Enter Id that will be updated: ");
		id = sc.nextInt();
		System.out.print("Enter new Department name: ");
		sc.nextLine();
		deptname = sc.nextLine();
		
		dept = departmentDao.findById(id);
		if (dept != null) {
			dept.setName(deptname);
			departmentDao.update(dept);
		}else {
			System.out.println("Sorry! Department not found!");
		}
		
		sc.close();
	}
}