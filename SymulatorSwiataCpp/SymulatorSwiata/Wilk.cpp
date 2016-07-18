#include "Wilk.h"
#include "zasoby.h"
#include "Swiat.h"

Wilk::Wilk(int x, int y)
{
	this->wiek = 0;
	this->x = x;
	this->y = y;
	this->wyglad = WILK;
	this->inicjatywa = 5;
	this->sila = 9;
}

void Wilk::akcja(Swiat &swiat, int i, int j)
{
	nowe = losuj();
	this->kolizja(swiat, i, j);
	wiek++;
}