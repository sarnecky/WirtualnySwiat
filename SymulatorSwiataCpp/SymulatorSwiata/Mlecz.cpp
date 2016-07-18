#include "Mlecz.h"
#include "zasoby.h"
#include <time.h>
#include "Swiat.h"

void Mlecz::akcja(Swiat &swiat, int i, int j)
{
	//3 proby rozmnozenia 
	int a;
	int n = 0;
	Polozenie nowe;
	while (n<3)
	{
		a = rand() % 100;
		if (a <1)
		{
			nowe = losuj();
			if (swiat.getSymbol(nowe.x,nowe.y) != ' '){}
			else
			{
				swiat.stworzOrganizm(swiat, MLECZ, nowe.x, nowe.y);
			}
		}

		n++;
	}

}
void Mlecz::kolizja(Swiat &swiat, int i, int j){}
Mlecz::Mlecz(int x, int y)
{
	this->wiek = 0;
	this->sila = 0;
	this->wyglad = MLECZ;
	this->inicjatywa = 0;
	this->x = x;
	this->y = y;
}