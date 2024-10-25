import java.util.Scanner;
public class AtmMachine {
	private int balance;
	private int pin;

	public AtmMachine(int balance, int pin) {
		this.balance = balance;
		this.pin = pin;
	}

	public void displayMenu() {
		System.out.println("1: Check Your Balance");
		System.out.println("2: Deposit Money");
		System.out.println("3: Withdraw");
		System.out.println("4: Change New Pin");
		System.out.println("5: Exit");
	}

	public void deposit(int ammount) {
		this.balance += ammount;
	}

	public void withdrawMoney(int ammount) {
		if (balance < ammount) {
			System.out.println("insufficient balance !");
			return;
		}
		balance -= ammount;
	}

	public int getBalance() {
		return balance;
	}

	public boolean validatePin(int pin) {
		return this.pin == pin;
	}

	public void changePin(int newPin) {
		pin = newPin;
		System.out.println("Pin Changed succesfully");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AtmMachine atm = new AtmMachine(1000, 2356);
		System.out.println("Enter the pin");
		int pin = Integer.parseInt(scanner.nextLine());
		if (atm.validatePin(pin)) {
			int option = 0;
			while (option != 5) {
				atm.displayMenu();
				System.out.print("Choose an option: ");
				option = Integer.parseInt(scanner.nextLine());
				switch (option) {
				case 1:
					System.out.println("Balance :" + atm.getBalance());
					break;
				case 2:
					System.out.println("Enter Ammout :");
					int ammount = Integer.parseInt(scanner.nextLine());
					atm.deposit(ammount);
					break;
				case 3:
					System.out.println("Enter Ammount :");
					ammount = Integer.parseInt(scanner.nextLine());
					atm.withdrawMoney(ammount);
					break;
				case 4:
					System.out.println("Enter New Pin");
					int newPin = Integer.parseInt(scanner.nextLine());
					atm.changePin(newPin);
					break;
				case 5:
					System.out.println("Thank you for using ATM ");
					break;

				default:
					break;
				}

			}

		}else{
			System.out.println("You have Entered wrong Pin !!");
		}
	}
}
