#include "Trawa.h"
#include "zasoby.h"
void Trawa::akcja(Swiat &swiat, int i, int j)
{	
	zasiew(swiat,i,j);
}
void Trawa::kolizja(Swiat &swiat, int i, int j){}
Trawa::Trawa(int x, int y)
{
	this->wiek = 0;
	this->sila=0;
	this->wyglad=TRAWA;
	this->inicjatywa = 0;
	this->x=x;
	this->y=y;
}