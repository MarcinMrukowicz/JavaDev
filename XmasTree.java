//import java.math.*;
import java.util.Scanner;

public class XmasTree 
{

	
	
	public static String setchar(String where, int howmany,char c)
	{
		String temp=where;
		
		for (int i=0; i<howmany; i++)
			temp+=c;
		
		return temp;
	}
	
	public static String XmasTreeLevel(int NumberOfLevels, int currentLevel, char c, String type)
	{
		String temp=new String();	
		
	if (type.equals("up")||(type.equals("down")))	
	{
		
		int ilespacji=Math.round(((float)NumberOfLevels*2-1)/2)-currentLevel;
		//System.out.println(ilespacji+","+currentLevel);
		
		temp=setchar("", ilespacji,' ');
		
		temp=setchar(temp,currentLevel*2-1,c);
		
		temp+='\n';
		
	} 
	
	if (type.equals("left"))
	{
		int ilespacji=Math.round(((float)NumberOfLevels*2-1)/2)-currentLevel;
		temp=setchar("", Math.abs(ilespacji),' ');
		if (ilespacji>=0)
			temp=setchar(temp,currentLevel,c);
		else
			temp=setchar(temp,currentLevel-2*(Math.abs(ilespacji)),c);
		
		temp+='\n';
		
	}
	
	if (type.equals("right"))
	{
		//System.out.println(-(Math.round(((float)NumberOfLevels*2-1)/2)-currentLevel)+","+currentLevel);
		
		if (currentLevel<=(Math.round(((float)NumberOfLevels*2-1)/2)))
			temp=setchar("",currentLevel,c);
		else
			temp=setchar(temp,currentLevel-2*(currentLevel-Math.round(((float)NumberOfLevels*2-1)/2)),c);
			
		temp+='\n';
	}
	
		
		return temp;
	}
	
	public static String XmasTreePrint(int NumberOfLevels, String type, char c)
	{
		String temp="";
		
		switch(type)
		{
		case "down":
			for (int i=1; i<=NumberOfLevels; i++)
				temp+=XmasTreeLevel(NumberOfLevels, i, c,type);
			break;
		
		case "up":
			for (int i=NumberOfLevels; i>0; i--)
				temp+=XmasTreeLevel(NumberOfLevels, i, c,type);
		break;
		
		case "left":
			for (int i=1; i<=(NumberOfLevels*2)-1; i++)
				temp+=XmasTreeLevel(NumberOfLevels,i,c,type);
		break;	
		
		case "right":
			for (int i=(NumberOfLevels*2)-1; i>0; i--)
				temp+=XmasTreeLevel(NumberOfLevels,i,c,type);
		break;	
			
		}
		
		
		
		return temp;
	}
	
	
	public static void main(String [] args)
	{
		
		Scanner pobierz=new Scanner(System.in);
		
		System.out.println("Witaj w programie, rysuj¹cym choinkê");
		
		System.out.println("Podaj liczbê poziomów choinki");
		int NumberOfLevels=pobierz.nextInt();
		
		System.out.println("Teraz wybierz kierunek choinki spoœród: up, down, left, right");
		
		String direction=new String();
		
		do
		{
			direction=pobierz.nextLine();
			
		}while(!direction.equals("up") && !direction.equals("down") && !direction.equals("left") && !direction.equals("right"));
		
		System.out.println("Na koniec podaj znak, jaki ma byæ wyœwietlany na choince");
		char c=pobierz.nextLine().charAt(0);
		
		
		String choinka=XmasTreePrint(NumberOfLevels,direction,c);
		
		System.out.print(choinka);
		pobierz.close();
	}
	
}
