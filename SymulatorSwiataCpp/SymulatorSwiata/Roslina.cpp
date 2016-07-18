#include "Roslina.h"
#include "zasoby.h"
#include "Mlecz.h"
#include "Guarana.h"
#include "Trawa.h"
#include "WilczaJagoda.h"
#include "Swiat.h"

void Roslina::zasiew(Swiat &swiat, int i, int j)
{
	int a = rand() % 100;
	Polozenie nowe;
	if (a <3)
	{
		nowe = losuj();
		if (this->rysowanie() == GUARANA)
		{
			if (swiat.getSymbol(nowe.x,nowe.y) != ' '){} // jezeli wylosuje miejsce zajete to nie urosnie nowa
			else
			{
				swiat.stworzOrganizm(swiat, GUARANA, nowe.x, nowe.y);
			}

		}
		else if (this->rysowanie() == TRAWA)
		{
			if (swiat.getSymbol(nowe.x, nowe.y) != ' '){} // jezeli wylosuje miejsce zajete to nie urosnie nowa
			else
			{
				swiat.stworzOrganizm(swiat, TRAWA, nowe.x, nowe.y);
			}

		}
		else if (this->rysowanie() == WILCZAJAGODA)
		{
			if (swiat.getSymbol(nowe.x, nowe.y) != ' '){} // jezeli wylosuje miejsce zajete to nie urosnie nowa
			else
			{
				swiat.stworzOrganizm(swiat, WILCZAJAGODA, nowe.x, nowe.y);
			}


		}
		swiat.logi(this->rysowanie(), " rozmnaza sie ", swiat.getSymbol(nowe.x, nowe.y));
	}
}
