import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to currency converter");
		System.out.println("Please choose an option (1/2)");
		System.out.println("1. Dollars to Shekels");
		System.out.println("2. Shekels to Dollars");
		int ds =0;
		while(ds!=1&&ds!=2){
			try {
				ds=sc.nextInt();
				if(ds != 1 && ds != 2) {
					System.out.println("Invalid Choice, please try again");
				}
			}
			catch(Exception e){
				System.out.println("Invalid Choice, please try again");
				sc.next();
			}
		}
		System.out.println("Please enter an amount to convert:");
		double sum = -1;
		while(sum < 0){
			try {
				sum=sc.nextDouble();
				if(sum < 0) {
					System.out.println("Invalid input, please try again");
				}
			}
			catch(Exception e){
				System.out.println("Invalid input, please try again");
				sc.next();
			}
		}
		Coins enumCoin;
		if(ds==1){
			enumCoin=Coins.ILS;
		}
		else{
			enumCoin=Coins.USD;
		}
		Coin coin;

		coin=new CoinFactory().getCoinInstance(enumCoin);
		//	System.out.println(coin.getValue());
		System.out.println(coin.calculate(sum));
	}

}
