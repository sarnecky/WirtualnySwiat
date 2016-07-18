#include "Owca.h"
#include "zasoby.h"

Owca::Owca(int x, int y)
{
	this->wiek = 0;
	this->x = x;
	this->y = y;
	this->wyglad = OWCA;
	this->inicjatywa = 4;
	this->sila = 4;
}

void Owca::akcja(Swiat &swiat, int i, int j)
{
	nowe = losuj();
	this->kolizja(swiat, i, j);
	wiek++;
}