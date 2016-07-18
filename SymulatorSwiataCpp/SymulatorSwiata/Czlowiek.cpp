#include "Czlowiek.h"
#include "Swiat.h"
#include "zasoby.h"
#include <conio.h>

#define GORA 0x48 
#define DOL 0x50 
#define LEWA 0x4b 
#define PRAWA 0x4d 
#define ENTER 0x0d

using namespace std;
void Czlowiek::calopalenie(Swiat &swiat, int i, int j)
{
	if (_calopalenie)
	{
		if (this->getx() + 1< WIELKOSC && swiat.getSymbol(this->getx() + 1, this->gety()) != ' ')
		{
			swiat.zabijStworzenie(swiat, this->getx() + 1, this->gety());
		}
		if (this->getx() - 1 > 0 && swiat.getSymbol(this->getx() - 1, this->gety()) != ' ')
		{
			swiat.zabijStworzenie(swiat, this->getx() - 1, this->gety());
		}
		if (this->gety() + 1 > 0 && swiat.getSymbol(this->getx(), this->gety() + 1) != ' ')
		{
			swiat.zabijStworzenie(swiat, this->getx(), this->gety() + 1);
		}
		if (this->gety() - 1 <WIELKOSC && swiat.getSymbol(this->getx(), this->gety() - 1) != ' ')
		{
			swiat.zabijStworzenie(swiat, this->getx(), this->gety() - 1);
		}
		_tury++;
		_pauza = 0;
	}
	if (_tury == 5) //calopalenie dziala 5 rund
	{
		_calopalenie = false;

	}
	if (_pauza <5 && _tury == 5 && _calopalenie == false) //warunek przerwy 5 rund 
	{
		_pauza++;
	}
	else if (_pauza == 5) //po minieciu 10 rund, znowu mozna uruchomic moc
	{
		_pauza = 0;
		_tury = 0;
	}
}
void Czlowiek::kolizja(Swiat &swiat, int i, int j)
{
	//i,j indexy pola na ktore wchodzi czlowiek
	int oldX, oldY;
	//calopalenie
	calopalenie(swiat,i,j);

		if (swiat.getSymbol(i,j) != ' ') //trafienie na inny organizm
		{
			if (this->getSila() > swiat.getSilaOrganizmu(i,j))
			{
				if (swiat.getSymbol(i, j) == GUARANA)
				{
					swiat.wywolajKolizje(swiat, i, j,this->getx(), this->gety() );
				}

				swiat.logi(this->rysowanie(), " zabija ", swiat.getSymbol(i, j));
				zabijOrganizm(swiat, i, j);

				oldX = this->getx();
				oldY = this->gety();
				this->set(i, j);
				zmianaMiejsca(swiat, oldX, oldY);
			}
			else
			{
				swiat.logi(this->rysowanie(), " zostaje zabity przez ", swiat.getSymbol(i, j));
				swiat.zabijStworzenie(swiat, this->getx(),this->gety());
			}
		}
		else  //trafienie na puste pole
		{
			oldX = this->getx();
			oldY = this->gety();
			this->set(i, j);
			zmianaMiejsca(swiat, oldX, oldY);
		}
}
void Czlowiek::akcja(Swiat &swiat, int i, int j)
{
	    int zn;
		zn = _getch();
		if (_kbhit())
		{
			zn = _getch();
			if (zn == PRAWA && this->getx()<WIELKOSC-1)
			{
				kolizja(swiat, this->getx() + 1, this->gety());
			}
			else if (zn == LEWA && this->getx() >0)
			{
				kolizja(swiat, this->getx() - 1, this->gety());
			}
			else if (zn == GORA && this->gety() > 0)
			{
				kolizja(swiat, this->getx(), this->gety() - 1);
			}
			else if (zn == DOL && this->gety() < WIELKOSC-1)
			{
				kolizja(swiat, this->getx(), this->gety() + 1);
			}
			if (zn == ENTER && _tury == 0)
			{
				swiat.logi('$', " dostal supermoc ", ' ');
				swiat.wyswietlLogi();
				this->_calopalenie = true;
			}
		}
			if (zn == ENTER && _tury == 0)
			{
				swiat.logi('$', " dostal supermoc ", ' ');
				swiat.wyswietlLogi();
				this->_calopalenie = true;
			}
			
	
		swiat.rysujSwiat();
		wiek++;
}
				

Czlowiek::Czlowiek(int x, int y)
{
	this->wiek = 0;
	this->sila = 5;
	this->inicjatywa = 4;
	this->wyglad = CZLOWIEK;
	this->x = x;
	this->y = y;
	this->_calopalenie = false;
	this->_tury = 0;
	this->_id = 0;
	this->_pauza = 0;
}


