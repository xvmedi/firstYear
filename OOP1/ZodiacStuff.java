import java.util.Scanner;

public class ZodiacStuff 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("enter your birthyear to see your chinese zodiac animal: ");
		int year = input.nextInt();
		
		switch (year%12) 
		{
			case 0: System.out.println("year of monkey"); break;
			case 1: System.out.println("year of rooster"); break;
			case 2: System.out.println("year of dog"); break;
			case 3: System.out.println("year of pig"); break;
			case 4: System.out.println("year of rat"); break;
			case 5: System.out.println("year of ox"); break;
			case 6: System.out.println("year of tiger"); break;
			case 7: System.out.println("year of rabbit"); break;
			case 8: System.out.println("year of dragon"); break;
			case 9: System.out.println("year of snake"); break;
			case 10: System.out.println("year of horse"); break;
			case 11: System.out.println("year of goat"); break;
		}
		
		int number = 1;
		System.out.println(number++);
		System.out.println(++number);
		
	}
}