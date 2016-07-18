#include "Antylopa.h"
#include "zasoby.h"
Antylopa::Antylopa(int x, int y)
{
	this->wiek = 0;
	this->x = x;
	this->y = y;
	this->wyglad = ANTYLOPA;
	this->inicjatywa = 4;
	this->sila = 4;
}

void Antylopa::akcja(Swiat &swiat, int i, int j)
{
	int ch_x = 0, ch_y = 0, flaga = 0;
	int wybor = 0; //liczby 0-7
	while (flaga == 0)
	{
		wybor = rand() % 4; //0-3
		if (wybor == 0) //w prawo
		{
			ch_x = 2;
			ch_y = 0;
		}
		else if (wybor == 1) //w lewo
		{
			ch_x = -2;
			ch_y = 0;
		}
		else if (wybor == 2) //w dol
		{
			ch_x = 0;
			ch_y = 2;
		}
		else if (wybor == 3) // do gory
		{
			ch_x = 0;
			ch_y = -2;
		}

		
		//warunki zapobiegajace wyjsciu poza tablice
		if ((this->getx() + ch_x) >= 0 &&
			(this->getx() + ch_x) < 20 &&
			(this->gety() + ch_y) >= 0 &&
			(this->gety() + ch_y) < 20)
		{
			flaga = 1;
			//this->set(this->getx() + ch_x, this->gety()+ch_y);
			//zmianaMiejsca(swiat, nowe.x, nowe.y);
			nowe.x = this->getx() + ch_x;
			nowe.y = this->gety() + ch_y;
			kolizja(swiat, i, j);
		}
		
	}
	//nowe = losuj();
	wiek++;
}