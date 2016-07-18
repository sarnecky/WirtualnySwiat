#include "Organizm.h"
#include "Swiat.h"
#include <time.h>
#include "zasoby.h"

using namespace std;

char Organizm::rysowanie()
{
   return this->wyglad;
}
void Organizm::setWiek(int w)
{
	wiek = w;
}
int Organizm::getx()
{
	return this->x;
}

int Organizm::getInicjatywa()
{
	return this->inicjatywa;
}

int Organizm::getWiek()
{
	return this->wiek;
}

int Organizm::gety()
{
	return this->y;
}

int Organizm::getId()
{
	return this->_id;
}

void Organizm::setId(int id)
{
	this->_id = id;
}

void Organizm::setSila(int x)
{
	this->sila += x;
}

int Organizm::getSila()
{
	return this->sila;
}

void Organizm::zabijOrganizm(Swiat &swiat, int x, int y)
{
	swiat.zabijStworzenie(swiat, x, y);
}
Polozenie Organizm::losuj()
{
	int ch_x=0, ch_y=0, flaga = 0;
	int wybor=0; //liczby 0-7
	while (flaga == 0)
	{
		wybor = rand() % 4; //0-3
		if (wybor == 0) //w prawo
		{
			ch_x = 1;
			ch_y = 0;

		}
		else if (wybor == 1) //w lewo
		{
			ch_x = -1;
			ch_y = 0;
	
		}
		else if (wybor == 2) //w dol
		{
			ch_x = 0;
			ch_y = 1;
	
		}
		else if (wybor == 3) // do gory
		{
			ch_x = 0;
			ch_y = -1;
		}

		//warunki zapobiegajace wyjsciu poza tablice
		if ((this->getx() + ch_x) >= 0 &&
			(this->getx() + ch_x) < 20 &&
			(this->gety() + ch_y) >= 0 &&
			(this->gety() + ch_y) < 20) flaga = 1;
	}

	Polozenie nowa;
	nowa.x = this->getx() + ch_x;
	nowa.y = this->gety() + ch_y;

	return nowa;

}

void Organizm::dodajOrganizm(Swiat &swiat, int i, int j)
{
	swiat.dodajStworzenie(swiat, x, y);
}
