#include "Zwierze.h"
#include <time.h>
#include "Polozenie.h"
#include "Swiat.h"
#include "zasoby.h"


void Zwierze::set(int x, int y)
{
	this->x = x;
	this->y = y;
}

void Zwierze::zmianaMiejsca(Swiat &swiat, int i, int j)
{
	swiat.zmianaMiejsca(i, j, this->getx(), this->gety());
}

void Zwierze::kolizja(Swiat &swiat,int i, int j)
{
	int szansaAntylopy = rand() % 2; //jezeli 0 walczy, jezeli 1 unika walki 50% szans

	if (swiat.getSymbol(nowe.x, nowe.y) == ' ')
	{
		this->set(nowe.x, nowe.y);
		zmianaMiejsca(swiat, i, j);
	}
	else if (swiat.getSila(nowe.x, nowe.y) < this->getSila())
	{
		//zabija
		if (swiat.getSymbol(i,j) == GUARANA)
		{
			swiat.wywolajKolizje(swiat, i, j, this->getx(), this->gety());  // wchodzi na guarane zeby zwiekszyc sile
		}
		else if (this->getSila() < 5 && swiat.getSymbol(nowe.x, nowe.y) == ZOLW)
		{
			this->set(i, j);  //zolw nie pozwala wejsc jezeli preciwnik ma sile < 5
		}
		else
		{
			if (swiat.getSymbol(i,j) == ANTYLOPA && szansaAntylopy == 1)
			{		
				//ANTYLOPA UNIKA WALKI, jezeli 3 sasiedznie pola nie sa wolne to zostaje na domyslnym
				if (j + 1<20 && swiat.getSymbol(i, j + 1) == ' '){ this->set(i, j + 1); }
				else if (j-1>=0 && swiat.getSymbol(i, j-1) == ' '){ this->set(i,j-1); }
				else if (i - 1 >= 0 && swiat.getSymbol(i-1, j) == ' '){ this->set(i - 1, j); }
				else if (i + i<20 && swiat.getSymbol(i+1, j ) == ' '){ this->set(i + 1, j); }
				else this->set(i, j); //jezeli zadne pole obok Antylopy nie jest wolne zostaje na starym
			}
			else  //jezeli wchodzi na slabszy organizm zabija go
			{
				swiat.logi(this->rysowanie(), " zabija ", swiat.getSymbol(nowe.x, nowe.y));
				zabijOrganizm(swiat, nowe.x, nowe.y);

				//ustawiam nowe miejsce i przesuwam w planszy
				this->set(nowe.x, nowe.y);
			}
		}
		
		zmianaMiejsca(swiat, i, j);
	}
	else if (swiat.getSila(nowe.x, nowe.y) > this->getSila())
	{
		// zwierze wchodzi na organizm silniejszy i ginie

		if (this->rysowanie() == ANTYLOPA && szansaAntylopy == 1)
		{
			//ANTYLOPA UNIKA WALKI, jezeli 3 sasiedznie pola nie sa wolne to zostaje na domyslnym
			if (swiat.getSymbol(i, j + 1) == ' '){ this->set(nowe.x, nowe.y); }
			else if (swiat.getSymbol(i, j - 1) == ' '){ this->set(nowe.x, nowe.y); }
			else if (swiat.getSymbol(i - 1, j) == ' '){ this->set(nowe.x, nowe.y); }
			else if (swiat.getSymbol(i + 1, j) == ' '){ this->set(nowe.x, nowe.y); }
			else this->set(i, j); //jezeli zadne pole obok Antylopy nie jest wolne zostaje na starym
		}
		else //reszta zwierzat oprocz antylopy
		{
			swiat.logi(this->rysowanie(), " ginie, zabite przez ", swiat.getSymbol(nowe.x, nowe.y));
			zabijOrganizm(swiat, i,j);
		}

	}
	else if (swiat.getSymbol(nowe.x, nowe.y) == this->rysowanie())
	{
		//rozmnazanie	
		if (swiat.getWiek(i,j) < 10 || this->getWiek() < 10)
		{
			swiat.logi(this->rysowanie(), " jest jeszcze za mloda/y ", ' ');
		}
		else
		{
			swiat.logi(this->rysowanie(), " kopuluje( :) ) z ", swiat.getSymbol(nowe.x, nowe.y));
		    rozmnazanie(swiat, nowe.x, nowe.y);
		}
	
	}

}

void Zwierze::rozmnazanie(Swiat &swiat, int i, int j)
{
	char zn = swiat.getSymbol(i, j);
	Polozenie nowe;
	bool flaga = false;
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
