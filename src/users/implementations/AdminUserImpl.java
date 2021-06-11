package users.implementations;

import database.DataBase;
import user.abstractions.AbstractUser;
import user.abstractions.AdminUser;
import user.abstractions.User;

public class AdminUserImpl extends AbstractUser implements AdminUser {

	private DataBase database = new DataBase(10);

	public AdminUserImpl(String userName) {
		super(userName, true);
	}

	@Override
	public void deleteUser(String userName) {
		
		User[] allUsers = database.getDataBase();
		
		for (int i = 0; i < allUsers.length; i++) {
			if(allUsers[i] != null) {
				if(allUsers[i].getUserName().equalsIgnoreCase(userName)) {
					allUsers[i] = null;
					return;
				}
			}
		}
		
		System.out.println("The database is emtpy, there is nothing to delete.");
	}

	@Override
	public User createUser(String userName, boolean isAdmin) {
		User[] allUsers = database.getDataBase();

		if (isAdmin) {
			AdminUser adminUser = null;

			//finding if that user already exists anywhere in the database, if it does no need to continue try adding it
			if(checkIfUserExists(userName)) {
				System.out.println("There is already a user registered with userName=" + userName + ", returning null");
				return null;
			}
			
			//finding the first empty slot in the database to create a new user into it
			for (int i = 0; i < allUsers.length; i++) {
				if (allUsers[i] == null) {
					adminUser = new AdminUserImpl(userName);
					allUsers[i] = adminUser;
					return adminUser;
				}
			}

			//returning null, because there are no empty slots, the database is full already
			System.out.println("Database is full no more place for users, returning null.");
			return null;
		} else {
			User normalUser = null;

			//finding if that user already exists anywhere in the database, if it does no need to continue try adding it
			if(checkIfUserExists(userName)) {
				System.out.println("There is already a user registered with userName=" + userName + ", returning null");
				return null;
			}
			
			//finding the first empty slot in the database to create a new user into it
			for (int i = 0; i < allUsers.length; i++) {
				if(allUsers[i] == null) {
					normalUser = new UserImpl(userName);
					allUsers[i] = normalUser;
					return normalUser;
				}
			}

			System.out.println("Database is full no more place for users, returning null");
			return normalUser;
		}
	}

	
	@Override
	public void viewAllUsers() {
		User[] allUsers = database.getDataBase();

		for (int i = 0; i < allUsers.length; i++) {
			if(allUsers[i] != null) {
				System.out.println(allUsers[i].toString());
			}
		}
	}
	
	
	//private method for reusability to check if a user with specific name already exists
	private boolean checkIfUserExists(String userName) {
		User[] allUsers = database.getDataBase();

		for (int i = 0; i < allUsers.length; i++) {
			if (allUsers[i] != null) {
				if(allUsers[i].getUserName().equalsIgnoreCase(userName)) {
					return true;
				}
			}
		}
		
		// there was no such user, we can continue with adding it
		return false;
	}
}
//VI. Да се създаде AdminUserImpl клас, който е User(AbstractUser) и AdminUser
//o Всеки AdminUser ще си има собствена база от данни(DataBase) с хардкодната
//стойност по подразбиране за големината на броя потребители, които могат да
//бъдат създавани.(например всеки AdminUser има възможност да създава по
//максимум 10 потребителя).
//o Методът, който ще създава потребител, ще се съобразява с това дали да създаде
//нормален потребител или админ, в зависимост от подадените параметри.
//▪ Ако вече има съществуващ потребител с такова име, той НЕ се добавя и се
//изписва съобщение в конзолата, че е вече съществуващ
//▪ Ако базата данни е вече пълна, ще изписва съобщение, че няма повече
//място за нови потребители
//o Методът, който ще изтрива потребители от базата, просто ще го прави null.
//▪ Ако базата е празна и се опита да изтрие потребител, ще изкарва
//съобщение в конзолата, че няма какво да се трие от празна база данни.
