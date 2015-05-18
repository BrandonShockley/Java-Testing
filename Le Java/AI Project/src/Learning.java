import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Learning {
	
	private static Scanner input = new Scanner(System.in);
	private static Animal idealBun = new Animal(0);
	private static Animal idealGir = new Animal(1);
	private static List<Animal> bunList = new ArrayList<Animal>();
	private static List<Animal> girList = new ArrayList<Animal>();
	
	private static Animal ideal(List<Animal> list, int type)
	{
		int idCol;
		int idHei;
		int sum=0;
		for(int i=0;i<list.size();i++)
			sum+=list.get(i).color;
		idCol=sum/list.size();
		sum=0;
		for(int i=0;i<list.size();i++)
			sum+=list.get(i).height;
		idHei=sum/list.size();
		return new Animal(type,idCol,idHei);
	}
	
	public static void main(String[] args)
	{	
		//bunList.add(new Animal(0,0,0));
		//girList.add(new Animal(1,100,100));
		while(true)
		{
			idealBun=ideal(bunList,0);
			idealGir=ideal(girList,1);
			System.out.println("Ideal Bunny - Color: " + idealBun.color + ", Height: " + idealBun.height);
			System.out.println("Ideal Giraffe - Color: " + idealGir.color + ", Height: " + idealGir.height);
			int typeGuess;
			int height = (int)(Math.random()*101);
			int color = (int)(Math.random()*101);
			int distToIdealBun = (int)(Math.sqrt(Math.pow(idealBun.color-color,2)+Math.pow(idealBun.height-height, 2)));
			int distToIdealGir = (int)(Math.sqrt(Math.pow(idealGir.color-color,2)+Math.pow(idealGir.height-height, 2)));
			
			System.out.println("This animal has a height of " + height + " and a color of " + color + ".");
			
			if (distToIdealBun<distToIdealGir)
				typeGuess = 0;
			else
				typeGuess = 1;
			if (typeGuess == 0)
				System.out.println("It is a bunny, yes?");
			else
				System.out.println("It is a giraffe, yes?");
			
			if (input.nextLine().equalsIgnoreCase("yes")){
				if (typeGuess==0)
					bunList.add(new Animal(0,color,height));
				else
					girList.add(new Animal(1,color,height));
			}else{
				if (typeGuess==0)
					girList.add(new Animal(1,color,height));
				else
					bunList.add(new Animal(0,color,height));
			}
		}
	}
	
}

//Color is x, height is y
//Bunnies usually have a height of ~10 and a color of ~0 (Type 0)
//Giraffes usually have a height of ~100 and a color of ~60 (Type 1)
//Write program that makes a guess as to what the provided animal is (giraffe or bunny), you correct it, and it learns.