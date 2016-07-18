#include "Swiat.h"
#include "zasoby.h"
#include <fstream>
#include <string>
#include "Wilk.h"
#include "Wyjatek.h"
#include "Wyjatek2.h"
#include <Windows.h>

using namespace std;
Swiat::~Swiat()
{}
void Swiat::gotoxy(int x, int y)
{
	COORD c;

	c.X = x - 1;

	c.Y = y - 1;

	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), c);
}
void Swiat::rysujSwiat()
{
	system("cls");
	for (int i = 0; i < WIELKOSC; i++)
	{
		for (int j = 0; j < WIELKOSC; j++)
		{
			if (plansza[i][j] != NULL)
			{
				gotoxy(plansza[i][j]->getx() + 1, plansza[i][j]->gety() + 1);
				cout << plansza[i][j]->rysowanie();
			}
		}
	}
	wyswietlLogi();
}

bool Swiat::czy(Organizm *w)
{
	for (int i = 0; i < WIELKOSC; i++)
	{
		for (int j = 0; j < WIELKOSC; j++)
		{
				if (plansza[i][j] == w)return true;
			
		}
	}
	return false;
}
void Swiat::wykonajTure(Swiat &swiat)
{
	runda = 0;
	while (runda < RUNDY)  
	{
		for (int i = 0; i < iloscOrganizmow; i++)
		{
      		if(czy(organizmy[i]))organizmy[i]->akcja(swiat, organizmy[i]->getx(), organizmy[i]->gety());
		}
			
		swiat.sortowanie(swiat); //sortuje tablice wzgledem ktorej poruszaja sie obiekty

		runda++;
	}
}
Swiat::Swiat()
{
	for (int i = 0; i < WIELKOSC; i++)
	{
		for (int j = 0; j < WIELKOSC; j++)
		{
			plansza[i][j] = NULL;
		}
	}
	iloscLogow = 0;
}

ostream & operator<<(ostream &out, Swiat &swiat)
{
	out << "Plansza" << endl;
	out << endl;
	for (int i = 0; i < WIELKOSC; i++)
	{
		for (int j = 0; j < WIELKOSC; j++)
		{
			if (swiat.getSymbol(j,i) != ' ')
			{
				out << swiat.getSymbol(j, i);
			}
			else
			{
				out << " ";
			}
		}
		out << endl;
	}
	for (int i = 0; i < WIELKOSC; i++)
	{
		for (int j = 0; j < WIELKOSC; j++)
		{
			if (swiat.getSymbol(j, i) != ' ')
			{
				out << swiat.getSila(j,i);
			}
			else
			{
				out << " ";
			}
		}
		out << endl;
	}
	return out;
}
ifstream & operator>>(ifstream &in, Swiat &swiat)
{
	char znak[WIELKOSC];
	
	for (int i = 0; i < 20; i++)
	{
		in.getline(znak, WIELKOSC);
		for (int j = 0; j < 20; j++)
		{
			
			if (znak[j] == CZLOWIEK || znak[j] == WILK || znak[j] == ZOLW || znak[j] == ANTYLOPA ||
				znak[j] == LIS || znak[j] == OWCA || znak[j] == GUARANA 
				|| znak[j] == MLECZ || znak[j] == TRAWA || znak[j] == WILCZAJAGODA)
			{
				swiat.stworzOrganizm(swiat, znak[j], j, i);

				if (swiat.getIloscOrganizmow() >= 20)
				{
					throw Wyjatek("Za duzo organizmow, grozi niestabilnoscia !");
				}
			}
			if (znak[j] == WILK + 32 || znak[j] == ZOLW + 32 || znak[j] == ANTYLOPA + 32 ||
				znak[j] == LIS + 32 || znak[j] == OWCA + 32 || znak[j] == GUARANA + 32
				|| znak[j] == MLECZ + 32 || znak[j] == TRAWA + 32 || znak[j] == WILCZAJAGODA + 32)
			{
				throw Wyjatek2("W pliku z odczytu powinny byc tylko duze litery !", znak[j],j,i);
			}
			znak[j] = ' ';
		}
	}
	swiat.sortowanie(swiat);
	return in;

}

void Swiat::logi(char kto, string log, char kogo)
{
	Logi[iloscLogow] = kto + log + kogo;
	iloscLogow++;
}
void Swiat::sortowanie(Swiat &swiat)
{
	int id1, id2, wiek, wiek2;
	for (int j = 0; j < swiat.iloscOrganizmow - 1; j++)
	{
		for (int i = 0; i < swiat.iloscOrganizmow - 1; i++)
		if (swiat.organizmy[i]->getInicjatywa() < swiat.organizmy[i + 1]->getInicjatywa())
		{
			swap(swiat.organizmy[i],swiat.organizmy[i + 1]); // zamieniam organizmy miejscami
			id1 = swiat.organizmy[i]->getId();
			id2 = swiat.organizmy[i+1]->getId();
			wiek = swiat.organizmy[i]->getWiek();
			wiek2 = swiat.organizmy[i+1]->getWiek();
		    swiat.organizmy[i]->setId(id2);
			swiat.organizmy[i + 1]->setId(id1);
			swiat.organizmy[i]->setWiek(wiek2);
			swiat.organizmy[i + 1]->setWiek(wiek);
		}	
		else if (swiat.organizmy[i]->getInicjatywa() == swiat.organizmy[i + 1]->getInicjatywa() && swiat.organizmy[i]->getInicjatywa()!=0)
		{
			if (swiat.organizmy[i]->getWiek() < swiat.organizmy[i + 1]->getWiek())
			{
				swap(swiat.organizmy[i], swiat.organizmy[i + 1]);
				id1 = swiat.organizmy[i]->getId();
				id2 = swiat.organizmy[i + 1]->getId();
				wiek = swiat.organizmy[i]->getWiek();
				wiek2 = swiat.organizmy[i + 1]->getWiek();
				swiat.organizmy[i]->setId(id2);
				swiat.organizmy[i + 1]->setId(id1);
				swiat.organizmy[i]->setWiek(wiek2);
				swiat.organizmy[i + 1]->setWiek(wiek);
			}
		}
	}

}	
Swiat::Swiat(Swiat &swiat)
{
	this->iloscLogow = 0;
	this->iloscOrganizmow = 0;
	char z;
	for (int i = 0; i < iloscOrganizmow; i++)
	{
		for (int j = 0; j < iloscOrganizmow; j++)
		{

			if (swiat.plansza[j][i] == NULL)
			{
				this->plansza[j][i] = NULL;
			}
			else
			{
				z = swiat.plansza[j][i]->rysowanie();
				if (z == CZLOWIEK)
					this->plansza[j][i] = new Czlowiek(j, i);
				if (z == WILK)
					this->plansza[j][i] = new Wilk(j, i);
				if (z == ZOLW)
					this->plansza[j][i] = new Zolw(j, i);
				if (z == ANTYLOPA)
					this->plansza[j][i] = new Antylopa(j, i);
				if (z == LIS)
					this->plansza[j][i] = new Lis(j, i);
				if (z == OWCA)
					this->plansza[j][i] = new Owca(j, i);
				if (z == GUARANA)
					this->plansza[j][i] = new Guarana(j, i);
				if (z == MLECZ)
					this->plansza[j][i] = new Mlecz(j, i);
				if (z == TRAWA)
					this->plansza[j][i] = new Trawa(j, i);
				if (z == WILCZAJAGODA)
					this->plansza[j][i] = new WilczaJagoda(j, i);

				if (z == CZLOWIEK ||z == WILK || z == ZOLW || z == ANTYLOPA ||
					z == LIS || z == OWCA || z == GUARANA
					|| z == MLECZ || z == TRAWA || z == WILCZAJAGODA)
				{
					swiat.dodajStworzenie(swiat, j, i);
				}
				z = ' ';
			}
			
		}
	}
}
void Swiat::transport(Swiat &swiat, int id)  //transport obiektow miedzy swiatami
{
	this->iloscOrganizmow = 0;
	for (int i = 0; i <WIELKOSC; i++)
	{
		for (int j = 0; j < WIELKOSC; j++)
		{
			if (swiat.getSymbol(j,i) == ' ')
			{
				this->plansza[j][i] = NULL;
			}
			else if (swiat.getId(j,i)== id)
			{
				this->plansza[j][i] = swiat.plansza[j][i];
				swiat.plansza[j][i] = NULL;
				swiat.iloscOrganizmow--;
				this->organizmy[this->iloscOrganizmow] = this->plansza[j][i];
				this->organizmy[this->iloscOrganizmow]->setId(this->iloscOrganizmow);
				this->iloscOrganizmow++;
			}

		}
	}
}
void Swiat::stworzOrganizm(Swiat &swiat, char z, int j, int i)
{
	if (z == CZLOWIEK)
		this->plansza[j][i] = new Czlowiek(j, i);
	if (z == WILK)
		this->plansza[j][i] = new Wilk(j, i);
	if (z == ZOLW)
		this->plansza[j][i] = new Zolw(j, i);
	if (z == ANTYLOPA)
		this->plansza[j][i] = new Antylopa(j, i);
	if (z == LIS)
		this->plansza[j][i] = new Lis(j, i);
	if (z == OWCA)
		this->plansza[j][i] = new Owca(j, i);
	if (z == GUARANA)
		this->plansza[j][i] = new Guarana(j, i);
	if (z == MLECZ)
		this->plansza[j][i] = new Mlecz(j, i);
	if (z == TRAWA)
		this->plansza[j][i] = new Trawa(j, i);
	if (z == WILCZAJAGODA)
		this->plansza[j][i] = new WilczaJagoda(j, i);
	
	dodajStworzenie(swiat, j, i);
}
void Swiat::usunOrganizm(Swiat &swiat,int i, int j)
{
	this->plansza[i][j]->zabijOrganizm(swiat, i, j);
}
void Swiat::wyswietlLogi()
{
	gotoxy(30, 1);
	cout << "Zdarzenia tury: "<<runda;
	for (int i = 0; i < iloscLogow; i++)
	{
		gotoxy(30, i+2);
		cout << Logi[i] << endl;
		Logi[i] = " ";
	}
	iloscLogow = 0;
}
char Swiat::getSymbol(int x, int y)
{
	if (this->plansza[x][y] == NULL)
		return ' ';
	else return this->plansza[x][y]->rysowanie();
}
int Swiat::getSilaOrganizmu(int x, int y)
{
	return this->plansza[x][y]->getSila();
}
void Swiat::wywolajKolizje(Swiat &swiat, int x, int y, int x2, int y2)
{
	plansza[x][y]->kolizja(swiat, x2, y2);
}
int Swiat::getIloscOrganizmow()
{
	return iloscOrganizmow;
}
void Swiat::zabijStworzenie(Swiat &swiat, int x, int y)
{
	//usuwam ten organizm z tablicy organizmow i przesowam wszystkie o 1 do gory
	organizmy[plansza[x][y]->getId()] = NULL;
	for (int i = plansza[x][y]->getId(); i < getIloscOrganizmow() - 1; i++)
	{
		organizmy[i] = organizmy[i + 1];
	}

	organizmy[iloscOrganizmow - 1] = NULL;
	iloscOrganizmow--;

	plansza[x][y] = NULL;
	delete[] plansza[x][y];
	plansza[x][y] = NULL;
}
void Swiat::dodajStworzenie(Swiat &swiat, int i, int j)
{
	organizmy[swiat.iloscOrganizmow] = plansza[i][j];
	organizmy[swiat.iloscOrganizmow]->setId(iloscOrganizmow);
	iloscOrganizmow++;
}
int Swiat::getSila(int x, int y)
{
	return plansza[x][y]->getSila();
}
int Swiat::getWiek(int x, int y)
{
	return plansza[x][y]->getWiek();
}
void Swiat::zmianaMiejsca(int i, int j, int x, int y)
{
	plansza[x][y] = plansza[i][j];
	plansza[i][j] = NULL;
}
int Swiat::getId(int x, int y)
{
	return plansza[x][y]->getId();
}
void Swiat::setSila(int ile, int x, int y)
{
	plansza[x][y]->setSila(ile);
}