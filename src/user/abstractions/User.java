package user.abstractions;

public interface User {
	void login();
	void logout();
	String getUserName();
	String getRegistrationDate();

}
//I. Да се създаде интерфейс User –
//o юзърите трябва да могат да се логват(метод, който променя state-a на логнат)
//o да се логаутват(метод, който променя state-a на логаутнат)
//o да се взима username на всеки юзър(метод, който връща String съдържащ username-a, на потребителя)
//o да се взима датата, на която се е регистрирал(метод, който връща String съдържащ
//датата, на която потребителя е бил създаден)