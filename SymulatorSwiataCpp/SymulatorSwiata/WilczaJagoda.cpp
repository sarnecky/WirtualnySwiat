#include "WilczaJagoda.h"
#include "zasoby.h"

void WilczaJagoda::akcja(Swiat &swiat, int i, int j)
{
	zasiew(swiat, i, j);
}

void WilczaJagoda::kolizja(Swiat &swiat, int i, int j)
{
	//zabija 
}

WilczaJagoda::WilczaJagoda(int x, int y)
{
	this->wiek = 0;
	this->sila = 99;
	this->wyglad = WILCZAJAGODA; 
	this->inicjatywa = 0;
	this->x = x;
	this->y = y;
}