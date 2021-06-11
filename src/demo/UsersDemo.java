package demo;

import user.abstractions.AdminUser;
import user.abstractions.User;
import users.implementations.AdminUserImpl;

public class UsersDemo {

	public static void main(String[] args) throws InterruptedException {
		AdminUser milen = new AdminUserImpl("milen");
		
		System.out.println("--------------------CREATIONS--------------------------");
		
		milen.createUser("gosho", true);
		User ivan = milen.createUser("ivan", false);
		ivan.login();
		milen.createUser("maria", false);
		milen.createUser("stefcho", false);
		milen.createUser("stefcho1", false);
		milen.createUser("stefcho2", false);
		milen.createUser("stefcho3", false);
		milen.createUser("stefcho4", false);
		milen.createUser("stefcho5", false);
		milen.createUser("stefcho6", false);
		milen.createUser("stefcho7", false);
		
		milen.viewAllUsers();
		
		System.out.println("----------------------DELETION------------------------");
		
		milen.deleteUser("stefcho3");
		
		milen.viewAllUsers();
	}
}
//VII. Създайте Demo клас с main метод, в който:
//o Създайте един AdminUser
//o Създайте N на брой потребителя извиквайки метода за създаване на потребител на
//AdminUser(и админи и нормални потребители)
//o Поиграйте си и с граничните стойности дали са покрити(т.е. да не може да
//създадете повече потребители от колкото са заложени, и дали можете да изтриете
//потребител от празна база данни)