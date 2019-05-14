package pojo;

public class User extends Entity{
	
	private String name;
	private String surname;
	private String username;
	private String password;
	private double balance;
	private double profit;
	private String securityQuestion;
	private String securityAnswer;

	public User(String name, String surname, String username, String password, double balance, double profit,
			String securityQuestion, String securityAnswer) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.profit = profit;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public User(int id, String date, String name, String surname, String username, String password, double balance, double profit,
			String securityQuestion, String securityAnswer) {
		super(id, date);
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.profit = profit;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	@Override
	public String toString() {
		return super.toString() + name + "___" + surname + "___" + username + "___" + password + "___" + balance + " ___ " + profit + " ___ "
				+ securityQuestion + " ___ " + securityAnswer;
	}


}
