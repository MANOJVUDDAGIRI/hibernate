package hibernate2;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class logincontroller {

	public static void main(String[] args) {
		
		Scanner src = new Scanner(System.in);
		
		int ch;
		
		do {
			
			displaymenu();
			ch = Integer.parseInt(src.nextLine());
			
			switch (ch) {
			case 1:
				insertion(null, null,null);
				break;
			case 2:
				delete(0);
				break;
			case 3:
				update();
				break;
			case 4:
				getall();
				break;
			case 5:
				getbyid();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("invalid operation");
				break;
				
			}
		}
		while(ch>0);
	}

	private static void getbyid() {
		
		Scanner src = new Scanner(System.in);

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		
		System.out.println("Enter transaction id: ");
		int id = src.nextInt();

		Transaction t = s.beginTransaction();
		
		login l = s.get(login.class, id);
		if (l!=null) {
			System.out.println("id: "+l.getId());
			System.out.println("name:"+l.getName());
			System.out.println("email: "+l.getEmail());
			System.out.println("password: "+l.getPassword());
			
		}
		else {
			
			System.out.println("error");
		}
		t.commit();
	}

	public static List<login> getall() {
		
		Scanner src = new Scanner(System.in);
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		List<login> li = s.createQuery("from login",login.class).list();
		
		t.commit();
		return li;
		
//		for(devi d:li) {
//			
//			System.out.println("Id: "+d.getId());
//			
//			System.out.println("Name: "+d.getName());
//			
//			System.out.println("Email: "+d.getEmail());
//		}
		
	}

	public static void update() {

		Scanner src = new Scanner(System.in);
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("enter id :");
		int id = src.nextInt();
		Transaction t = s.beginTransaction();
		login l = s.get(login.class, id);
		if(l!=null) {
			System.out.println("enter new name: ");
			String name = src.next();
			System.out.println("enter new email: ");
			String email = src.next();
			System.out.println("enter new password");
			String password = src.next();
			l.setName(name);
			l.setEmail(email);
			l.setPassword(password);
			s.update(l);
			
			t.commit();
		}
		else {
			
			System.out.println("----data not updated----");
		}
		
	}

	public static void delete(int id) {
		Scanner src = new Scanner(System.in);
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		
//		System.out.println("Enter id: ");
//		
//		int id = src.nextInt();
	
		Transaction t = s.beginTransaction();
		
		login l = s.get(login.class, id);
		
		s.delete(l);
		
		t.commit();
		
		System.out.println("successfully Deleted");
		
	}

	public static void insertion(String name, String email, String password) {
		
		Scanner src = new Scanner(System.in);
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		login d = new login();
		
//		System.out.println("Enter name");
//		String name = src.nextLine();
		d.setName(name);
		
//		System.out.println("Enter email");
//		String email = src.nextLine();
		d.setEmail(email);
		
//		System.out.println("Enter password");
//		String password = src.nextLine();
		d.setPassword(email);
		
		s.save(d);
		
		t.commit();
		
		System.out.println("successfully Inserted");
		
	}

	private static void displaymenu() {
	
		System.out.println("\t1.insertion");
		System.out.println("\t2.delete");
		System.out.println("\t3.update");
		System.out.println("\t4.getall");
		System.out.println("\t5.getbyid");
		System.out.println("\t6.exit");
		
		
	}
}
