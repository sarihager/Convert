import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to currency converter");
		ArrayList<Double> result=new ArrayList<Double>();
		char ch='Y';
		while(ch=='Y'||ch=='y'){

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
				enumCoin=Coins.USD;
			}
			else{
				enumCoin=Coins.ILS;
			}
			Coin coin;
			coin=new CoinFactory().getCoinInstance(enumCoin);
			System.out.println(coin.getValue());
			System.out.println("the calculate is: "+coin.calculate(sum));
			result.add(coin.calculate(sum));
			System.out.println("enter Y – to start cycle again and N – to show end screen:");
			ch=sc.next().charAt(0);
		}
		System.out.println("Thanks for using our currency converter");
		System.out.println("The results of your converter are: "+result);

		try {
		//כתיבה לקובץ
			Date date=new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String var10002 = dateFormat.format(date);
			FileWriter writer= new FileWriter( var10002 + "results.txt");
			Iterator var5 = result.iterator();
			while (var5.hasNext()) {
				double str = (double)var5.next();
				writer.write(str + System.lineSeparator());

			}
			writer.close();




		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
