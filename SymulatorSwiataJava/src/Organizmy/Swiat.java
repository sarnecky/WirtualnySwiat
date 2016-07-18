package Organizmy;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import Wyjatki.*;
import Rosliny.*;
import Zwierzeta.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
public class Swiat{
	
	private Zasoby a;
	private int iloscOrganizmow;
	private Organizm [][] plansza = new Organizm [20][20];
	private	Organizm []organizmy = new Organizm[400];
	private String zdanie;
	private String [] Logi = new String [400];
	private	int iloscLogow;
	private	int runda;
	private File file;
	private Scanner in;
	private PrintWriter zapis;
	public int getSila(int x, int y)
	{
		return plansza[x][y].getSila();
	}
	
	public int getWiek(int x, int y)
	{
		return plansza[x][y].getWiek();
	}
	
	public void zmianaMiejsca(int i, int j, int x, int y)
	{
		plansza[x][y] = plansza[i][j];
		plansza[i][j] = null;
	}
	
	public int getId(int x, int y)
	{
		return plansza[x][y].getId();
	}
	
	public void setSila(int ile, int x, int y)
	{
		plansza[x][y].setSila(ile);
	}
	
	public char getSymbol(int x, int y)
	{
		if (plansza[x][y] == null)
			return ' ';
		else return plansza[x][y].rysowanie();
	}
	
	public int getSilaOrganizmu(int x, int y)
	{
		return plansza[x][y].getSila();
	}
	
	public void wywolajKolizje(Swiat swiat, int x, int y, int x2, int y2)
	{
		plansza[x][y].kolizja(swiat, x2, y2);
	}
	
	public int getIloscOrganizmow()
	{
		return iloscOrganizmow;
	}
	
	public void rysujSwiat(Graphics2D g2d)
	{
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (plansza[i][j] != null)
				{
					g2d.setColor(plansza[i][j].color);
					g2d.fillRect(plansza[i][j].getx()*15, plansza[i][j].gety()*15 , 15, 15);
				}
			}
		}
		wyswietlLogi();
	}

	public void zabijStworzenie(Swiat swiat, int x, int y)
	{
		//usuwam ten organizm z tablicy organizmow i przesowam wszystkie o 1 do gory
		organizmy[plansza[x][y].getId()] = null;
		for (int i = plansza[x][y].getId(); i < getIloscOrganizmow() - 1; i++)
		{
			organizmy[i] = organizmy[i + 1];
		}

		organizmy[iloscOrganizmow - 1] = null;
		iloscOrganizmow--;

		//delete[] plansza[x][y];
		plansza[x][y] = null;
	}
	
	public void dodajStworzenie(Swiat swiat, int i, int j)
	{
		organizmy[swiat.iloscOrganizmow] = plansza[i][j];
		organizmy[swiat.iloscOrganizmow].setId(iloscOrganizmow);
		iloscOrganizmow++;
	}
	
	public void usunOrganizm(Swiat swiat,int i, int j)
	{
		plansza[i][j].zabijOrganizm(swiat, i, j);
	}
	
	public String wyswietlLogi()
	{
		String tmp="";
		for (int i = 0; i < iloscLogow; i++)
		{
			tmp+=(Logi[i]+ "\n");
			Logi[i] = " ";
		}
		iloscLogow = 0;
		return tmp;
	}
	
	public void stworzOrganizm(Swiat swiat, char z, int j, int i)
	{
		if (z == 'C')
			plansza[j][i] = new Czlowiek(j, i);
		if (z == 'W')
			plansza[j][i] = new Wilk(j, i);
		if (z == 'Z')
			plansza[j][i] = new Zolw(j, i);
		if (z == 'A')
			plansza[j][i] = new Antylopa(j, i);
		if (z == 'L')
			plansza[j][i] = new Lis(j, i);
		if (z =='O')
			plansza[j][i] = new Owca(j, i);
		if (z == 'G')
			plansza[j][i] = new Guarana(j, i);
		if (z == 'M')
			plansza[j][i] = new Mlecz(j, i);
		if (z == 'T')
			plansza[j][i] = new Trawa(j, i);
		if (z == 'J')
			plansza[j][i] = new WilczaJagoda(j, i);
		
		dodajStworzenie(swiat, j, i);
	}
    
	public void transport(Swiat swiat, int id)  //transport obiektow miedzy swiatami
	{
		iloscOrganizmow = 0;
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				if (swiat.getSymbol(j,i) == ' ')
				{
					plansza[j][i] = null;
				}
				else if (swiat.getId(j,i)== id)
				{
					plansza[j][i] = swiat.plansza[j][i];
					swiat.plansza[j][i] = null;
					swiat.iloscOrganizmow--;
					organizmy[iloscOrganizmow] = plansza[j][i];
					organizmy[iloscOrganizmow].setId(iloscOrganizmow);
					iloscOrganizmow++;
				}

			}
		}
	}
	
	public Swiat()
	{
		//addKeyListener(this);
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				plansza[i][j] = null;
			}
		}
		iloscLogow = 0;
	}
	
	public Swiat(Swiat swiat)
	{
		iloscLogow = 0;
		iloscOrganizmow = 0;
		//addKeyListener(this);
		char z;
		for (int i = 0; i < iloscOrganizmow; i++)
		{
			for (int j = 0; j < iloscOrganizmow; j++)
			{

				if (swiat.plansza[j][i] == null)
				{
					plansza[j][i] = null;
				}
				else
				{
					z = swiat.plansza[j][i].rysowanie();
					if (z == a.kto(Zasoby.CZLOWIEK))
						plansza[j][i] = new Czlowiek(j, i);
					if (z == a.kto(Zasoby.WILK))
						plansza[j][i] = new Wilk(j, i);
					if (z == a.kto(Zasoby.ZOLW))
						plansza[j][i] = new Zolw(j, i);
					if (z == a.kto(Zasoby.ANTYLOPA))
						plansza[j][i] = new Antylopa(j, i);
					if (z == a.kto(Zasoby.LIS))
						plansza[j][i] = new Lis(j, i);
					if (z == a.kto(Zasoby.OWCA))
						plansza[j][i] = new Owca(j, i);
					if (z == a.kto(Zasoby.GUARANA))
						plansza[j][i] = new Guarana(j, i);
					if (z == a.kto(Zasoby.MLECZ))
						plansza[j][i] = new Mlecz(j, i);
					if (z == a.kto(Zasoby.TRAWA))
						plansza[j][i] = new Trawa(j, i);
					if (z == a.kto(Zasoby.WILCZAJAGODA))
						plansza[j][i] = new WilczaJagoda(j, i);

					if (z == a.kto(Zasoby.CZLOWIEK) ||z == a.kto(Zasoby.WILK) || z == a.kto(Zasoby.ZOLW) || z == a.kto(Zasoby.ANTYLOPA) ||
						z == a.kto(Zasoby.LIS) || z == a.kto(Zasoby.OWCA) || z == a.kto(Zasoby.GUARANA)
						|| z == a.kto(Zasoby.MLECZ) || z == a.kto(Zasoby.TRAWA) || z == a.kto(Zasoby.WILCZAJAGODA))
					{
						swiat.dodajStworzenie(swiat, j, i);
					}
					z = ' ';
				}
				
			}
		}
	}
	
	public void sortowanie(Swiat swiat)
	{
		int id1, id2, wiek, wiek2;
		for (int j = 0; j < swiat.iloscOrganizmow - 1; j++)
		{
			for (int i = 0; i < swiat.iloscOrganizmow - 1; i++)
			if (swiat.organizmy[i].getInicjatywa() < swiat.organizmy[i + 1].getInicjatywa())
			{
				swap(swiat.organizmy[i],swiat.organizmy[i + 1]); // zamieniam organizmy miejscami
				id1 = swiat.organizmy[i].getId();
				id2 = swiat.organizmy[i+1].getId();
				wiek = swiat.organizmy[i].getWiek();
				wiek2 = swiat.organizmy[i+1].getWiek();
			    swiat.organizmy[i].setId(id2);
				swiat.organizmy[i + 1].setId(id1);
				swiat.organizmy[i].setWiek(wiek2);
				swiat.organizmy[i + 1].setWiek(wiek);
			}	
			else if (swiat.organizmy[i].getInicjatywa() == swiat.organizmy[i + 1].getInicjatywa() && swiat.organizmy[i].getInicjatywa()!=0)
			{
				if (swiat.organizmy[i].getWiek() < swiat.organizmy[i + 1].getWiek())
				{
					swap(swiat.organizmy[i], swiat.organizmy[i + 1]);
					id1 = swiat.organizmy[i].getId();
					id2 = swiat.organizmy[i + 1].getId();
					wiek = swiat.organizmy[i].getWiek();
					wiek2 = swiat.organizmy[i + 1].getWiek();
					swiat.organizmy[i].setId(id2);
					swiat.organizmy[i + 1].setId(id1);
					swiat.organizmy[i].setWiek(wiek2);
					swiat.organizmy[i + 1].setWiek(wiek);
				}
			}
		}

	}

	private void swap(Organizm organizm, Organizm organizm2) {
		  Organizm t = organizm;
		  organizm = organizm2;
		  organizm2 = t;
		
	}
	
	public void logi(char kto, String log, char kogo)
	{
		Logi[iloscLogow] = kto +" "+ log+" " + kogo;
		iloscLogow++;
	}

	public void wykonajTure(Swiat swiat, int zn)
	{
		    runda = 0;
			for (int i = 0; i < iloscOrganizmow; i++)
			{
	      		if(czy(organizmy[i]))
	      		{
	      			if(organizmy[i].rysowanie()=='C')
	      			{
	      				if (zn == KeyEvent.VK_RIGHT && organizmy[i].getx()<19)
	    				{
	      					organizmy[i].akcja(swiat, organizmy[i].getx() + 1, organizmy[i].gety());
	    				}
	    				else if (zn == KeyEvent.VK_LEFT && organizmy[i].getx() >0)
	    				{
	    					organizmy[i].akcja(swiat, organizmy[i].getx() - 1, organizmy[i].gety());
	    				}
	    				else if (zn == KeyEvent.VK_UP && organizmy[i].gety() > 0)
	    				{
	    					organizmy[i].akcja(swiat, organizmy[i].getx(), organizmy[i].gety() - 1);
	    				}
	    				else if (zn == KeyEvent.VK_DOWN && organizmy[i].gety() < 19)
	    				{
	    					organizmy[i].akcja(swiat, organizmy[i].getx(), organizmy[i].gety() + 1);
	    				}
	    				else if (zn == KeyEvent.VK_ENTER && organizmy[i].getTury() == 0)
	    				{
	    					    System.out.println("Moc");
	    						logi('C', " dostal supermoc ", ' ');
	    						swiat.wyswietlLogi();
	    						organizmy[i].moc();
	    				}
	      			}
	      			else
	      			{
                       organizmy[i].akcja(swiat, organizmy[i].getx(), organizmy[i].gety());
	      			}

	      		}
	      			
			}
				
			swiat.sortowanie(swiat); //sortuje tablice wzgledem ktorej poruszaja sie obiekty

			runda++;
	}
	
	public boolean czy(Organizm w)
	{
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
					if (plansza[i][j] == w)return true;
				
			}
		}
		return false;
	}
	
	public void Odczyt(Swiat swiat) throws FileNotFoundException, Wyjatek
	 { 
		int y=0;
		 file = new File("odczyt.txt");
		 in = new Scanner(file);
		 //dodac wczyt sily
		 while(in.hasNext())
		 {
			 zdanie = in.nextLine();
			 System.out.println(zdanie);
			 for(int x = 0; x < zdanie.length(); x++)
			 {
				 if(zdanie.charAt(x) == 'W')
				 {
					 plansza[x][y] = new Wilk(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'O')
				 {
					 plansza[x][y] = new Owca(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'L')
				 {
					 plansza[x][y] = new Lis(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'Z')
				 {
					 plansza[x][y] = new Zolw(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'A')
				 {
					 plansza[x][y] = new Antylopa(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'T')
				 {
					 plansza[x][y] = new Trawa(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'M')
				 {
					 plansza[x][y] = new Mlecz(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'G')
				 {
					 plansza[x][y] = new Guarana(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'J')
				 {
					 plansza[x][y] = new WilczaJagoda(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == 'C')
				 {
					 plansza[x][y] = new Czlowiek(x, y);
					 dodajStworzenie(swiat, x, y);
				 }
				 else if(zdanie.charAt(x) == ' '){}
				 else
				 {
					 throw new Wyjatek(zdanie.charAt(x), x, y);
				 }
			 }
			 y++;
			 
		 }
		 in.close();
	 }
	
	public void Zapis() throws FileNotFoundException 
	 {
		String zdanie="";
		String sila="";
		zapis = new PrintWriter("zapis.txt");
		zapis.println("Plansza             Si³y");
		for(int y = 0; y < 20; y++)
		{
			 for(int x = 0; x < 20; x++)
			 {
				 if(plansza[x][y] != null)
				 {
					 if(plansza[x][y].rysowanie() == 'W')
					 {
						zdanie +="W";
					 }
					 else if(plansza[x][y].rysowanie() == 'O')
					 {
						 zdanie +="O";
					 }
					 else if(plansza[x][y].rysowanie() == 'L')
					 {
						 zdanie +="L";
					 }
					 else if(plansza[x][y].rysowanie() == 'Z')
					 {
						 zdanie +="Z";
					 }
					 else if(plansza[x][y].rysowanie() == 'A')
					 {
						 zdanie +="A";
					 }
					 else if(plansza[x][y].rysowanie() == 'T')
					 {
						 zdanie +="T";
					 }
					 else if(plansza[x][y].rysowanie() == 'M')
					 {
						 zdanie +="M";
					 }
					 else if(plansza[x][y].rysowanie() == 'G')
					 {
						 zdanie +="G";
					 }
					 else if(plansza[x][y].rysowanie() == 'J')
					 {
						 zdanie +="J";
					 }
					 else if(plansza[x][y].rysowanie() == 'C')
					 {
						 zdanie +="C";
					 }
					 sila += plansza[x][y].getSila();
				 }
				 else
				 {
					 zdanie +=" ";
					 sila +=" ";
				 }
			 }
			 
			 zapis.println(zdanie + sila );
			 zdanie="";
			 sila = "";
		 }
		zapis.close();
	 }

	
}
