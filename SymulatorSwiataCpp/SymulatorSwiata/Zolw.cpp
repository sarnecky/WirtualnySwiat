#include "Zolw.h"
#include "Polozenie.h"
#include "zasoby.h"

Zolw::Zolw(int x, int y)
{
	this->wiek = 0;
	this->x = x;
	this->y = y;
	this->wyglad = ZOLW;
	this->inicjatywa = 1;
	this->sila = 2;
	przypadki = 0;
}

void Zolw::akcja(Swiat &swiat, int i, int j)
{
	//w przypadku zolwia, rusza sie on co 4 wejscie do akcja()

	if (przypadki < 3) przypadki++;
	else
	{
		nowe = losuj();
		przypadki = 0;
		kolizja(swiat, i, j);
		/*set(nowe.x, nowe.y);
		zmianaMiejsca(swiat, i, j);*/
	}
	wiek++;
}
