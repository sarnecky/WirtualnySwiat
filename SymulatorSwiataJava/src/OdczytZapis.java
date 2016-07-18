import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class OdczytZapis {
	
	 File file;
	 Scanner in;
	 PrintWriter zapis;
	 String zdanie;
	 char[][] tab = new char[20][20];
	 public int y, x;
	 
	 public OdczytZapis() throws FileNotFoundException
	 {
		 file = new File("ala.txt");
		 in = new Scanner(file);
		 zapis = new PrintWriter("zapis.txt");
		 y=0;
		 x=0;
	 }
	 
	 public void Odczyt() 
	 { 
		 //dodac wczyt sily
		 while(in.hasNext())
		 {
			 zdanie = in.nextLine();
			 System.out.println(zdanie);
			 System.out.println(zdanie.length());
			 for(int i = 0;i<zdanie.length();i++)
			 {
				 if(zdanie.charAt(i) == 'W')
				 {
					 tab[y][i]='W';
				 }
				 else if(zdanie.charAt(i) == 'O')
				 {
					 tab[y][i]='O';
				 }
				 else if(zdanie.charAt(i) == 'L')
				 {
					 
				 }
				 else if(zdanie.charAt(i) == 'Z')
				 {
					 
				 }
				 else if(zdanie.charAt(i) == 'A')
				 {
					 
				 }
				 else if(zdanie.charAt(i) == 'T')
				 {
					 tab[y][i]='T';
				 }
				 else if(zdanie.charAt(i) == 'M')
				 {
					 
				 }
				 else if(zdanie.charAt(i) == 'G')
				 {
					 
				 }
				 else if(zdanie.charAt(i) == 'J')
				 {
					 
				 }
				 else
				 {
					 //czlowiek
				 }
			 }
			 y++;
			 
		 }
		 in.close();
	 }
	 
	 public void Zapis() 
	 {
		for(int y = 0; y<20;y++)
		{
			 for(int x = 0; x<20; x++)
			 {
				 if(tab[y][x] == 'W')
				 {
                     zapis.println("W");
				 }
				 else if(tab[y][x] == 'O')
				 {
					 zapis.println("O");
				 }
				 else if(tab[y][x] == 'L')
				 {
					 zapis.println("L");
				 }
				 else if(tab[y][x] == 'Z')
				 {
					 zapis.println("Z");
				 }
				 else if(tab[y][x] == 'A')
				 {
					 zapis.println("A");
				 }
				 else if(tab[y][x] == 'T')
				 {
					 zapis.println("T");
				 }
				 else if(tab[y][x] == 'M')
				 {
					 zapis.println("M");
				 }
				 else if(tab[y][x] == 'G')
				 {
					 zapis.println("G");
				 }
				 else if(tab[y][x] == 'J')
				 {
					 zapis.println("J");
				 }
				 else
				 {
					 //czlowiek
				 }
			 }

		 }
		zapis.close();
	 }
	 
}
