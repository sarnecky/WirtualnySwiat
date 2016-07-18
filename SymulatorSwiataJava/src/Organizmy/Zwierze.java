package Organizmy;

import java.util.Random;

public abstract class Zwierze extends Organizm{
	
    private Zasoby a;
	protected Polozenie nowe;
	
	protected void zmianaMiejsca(Swiat swiat, int i, int j) //zmiana miejsca planszy, w stare wstawiamy NULL
	{
		swiat.zmianaMiejsca(i, j, getx(), gety());
	}
	
	protected void rozmnazanie(Swiat swiat, int i, int j)
	{
		char zn = swiat.getSymbol(i, j);
		Polozenie nowe;
		boolean flaga = false;
		int ilosc = 0;
		while ((flaga==false) && ilosc<2)
		{
			nowe = losuj();

			if (swiat.getSymbol(nowe.x, nowe.y) == ' ')
			{
				i = nowe.x;
				j = nowe.y;

				swiat.stworzOrganizm(swiat, zn, i, j);
				flaga = true;
			}

			ilosc++;
		}
	}
	
	public void kolizja(Swiat swiat, int i, int j)
	{
		Random gen = new Random();
		int szansaAntylopy = gen.nextInt(2); //jezeli 0 walczy, jezeli 1 unika walki 50% szans

		if (swiat.getSymbol(nowe.x, nowe.y) == ' ')
		{
			set(nowe.x, nowe.y);
			zmianaMiejsca(swiat, i, j);
		}
		else if (swiat.getSila(nowe.x, nowe.y) < getSila())
		{
			//zabija
			if (swiat.getSymbol(i,j) == 'G')
			{
				swiat.wywolajKolizje(swiat, i, j, getx(), gety());  // wchodzi na guarane zeby zwiekszyc sile
			}
			else if (getSila() < 5 && swiat.getSymbol(nowe.x, nowe.y) == 'Z')
			{
				set(i, j);  //zolw nie pozwala wejsc jezeli preciwnik ma sile < 5
			}
			else
			{
				if (swiat.getSymbol(i,j) == 'A' && szansaAntylopy == 1)
				{		
					//ANTYLOPA UNIKA WALKI, jezeli 3 sasiedznie pola nie sa wolne to zostaje na domyslnym
					if (j + 1<20 && swiat.getSymbol(i, j + 1) == ' '){ set(i, j + 1); }
					else if (j-1>=0 && swiat.getSymbol(i, j-1) == ' '){ set(i,j-1); }
					else if (i - 1 >= 0 && swiat.getSymbol(i-1, j) == ' '){ set(i - 1, j); }
					else if (i + i<20 && swiat.getSymbol(i+1, j ) == ' '){ set(i + 1, j); }
					else set(i, j); //jezeli zadne pole obok Antylopy nie jest wolne zostaje na starym
				}
				else  //jezeli wchodzi na slabszy organizm zabija go
				{
					swiat.logi(rysowanie(), " zabija ", swiat.getSymbol(nowe.x, nowe.y));
					zabijOrganizm(swiat, nowe.x, nowe.y);

					//ustawiam nowe miejsce i przesuwam w planszy
					set(nowe.x, nowe.y);
				}
			}
			
			zmianaMiejsca(swiat, i, j);
		}
		else if (swiat.getSila(nowe.x, nowe.y) > getSila())
		{
			// zwierze wchodzi na organizm silniejszy i ginie

			if (rysowanie() == 'A' && szansaAntylopy == 1)
			{
				//ANTYLOPA UNIKA WALKI, jezeli 3 sasiedznie pola nie sa wolne to zostaje na domyslnym
				if (swiat.getSymbol(i, j + 1) == ' '){ set(nowe.x, nowe.y); }
				else if (swiat.getSymbol(i, j - 1) == ' '){ set(nowe.x, nowe.y); }
				else if (swiat.getSymbol(i - 1, j) == ' '){ set(nowe.x, nowe.y); }
				else if (swiat.getSymbol(i + 1, j) == ' '){ set(nowe.x, nowe.y); }
				else set(i, j); //jezeli zadne pole obok Antylopy nie jest wolne zostaje na starym
			}
			else //reszta zwierzat oprocz antylopy
			{
				swiat.logi(rysowanie(), " ginie, zabite przez ", swiat.getSymbol(nowe.x, nowe.y));
				zabijOrganizm(swiat, i,j);
			}

		}
		else if (swiat.getSymbol(nowe.x, nowe.y) == rysowanie())
		{
			//rozmnazanie	
			if (swiat.getWiek(i,j) < 10 || getWiek() < 10)
			{
				swiat.logi(rysowanie(), " jest jeszcze za mloda/y ", ' ');
			}
			else
			{
				swiat.logi(rysowanie(), " kopuluje( :) ) z ", swiat.getSymbol(nowe.x, nowe.y));
			    rozmnazanie(swiat, nowe.x, nowe.y);
			}
		
		}
	}
	
	public abstract void akcja(Swiat swiat, int i, int j);
		
	public void set(int x1, int y1)
	{
		x = x1;
		y = y1;
	}
		
}
