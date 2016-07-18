#include "Lis.h"
#include "Polozenie.h"
#include "zasoby.h"
#include "Swiat.h"

Lis::Lis(int x, int y)
{
	this->wiek = 0;
	this->x = x;
	this->y = y;
	this->wyglad = LIS;
	this->inicjatywa = 7;
	this->sila = 3;
}

void Lis::akcja(Swiat &swiat, int i, int j)
{
	nowe = losuj();
	int przeciwnicy = 0;
	
	if (swiat.getSymbol(nowe.x, nowe.y) != ' ')
	{
		while (przeciwnicy < 12) //sprawdza pola dookola lisa, czy jest ktos slabszy
		{						//max 12 iteracji powinno wyczerpac wszystkie mozliwosci
								//istnieje mozliwosc ze lis nie ruszy sie wgl
			if (swiat.getSymbol(nowe.x, nowe.y) != ' ' && this->getSila() < swiat.getSilaOrganizmu(nowe.x,nowe.y))
			{
				nowe = losuj();
				przeciwnicy++;
			}
			else if (swiat.getSymbol(nowe.x, nowe.y) != ' ' && this->getSila() > swiat.getSilaOrganizmu(nowe.x, nowe.y))
			{
				set(nowe.x, nowe.y);
				zmianaMiejsca(swiat, i, j);
				przeciwnicy = 12;
			}
			else if (swiat.getSymbol(nowe.x, nowe.y) == ' ')
			{
				set(nowe.x, nowe.y);
				zmianaMiejsca(swiat, i, j);
				przeciwnicy = 12;
			}		
		}
			
		//jezeli rowna to rozmnazanko
		//jezeli mniejsza to lis zabija
	}
	else
	{
		set(nowe.x, nowe.y);
		zmianaMiejsca(swiat, i, j);
	}

	wiek++;
}
