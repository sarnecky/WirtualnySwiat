#include "Guarana.h"
#include "Swiat.h"
#include "zasoby.h"

void Guarana::akcja(Swiat &swiat, int i, int j)
{
	zasiew(swiat, i, j);
}
void Guarana::kolizja(Swiat &swiat, int i, int j)
{
	//+3 do sily
	swiat.setSila(3, i, j); //zwiekszenie sily o 3
}
Guarana::Guarana(int x, int y)
{
	this->wiek = 0;
	this->sila = 0;
	this->wyglad = GUARANA;
	this->inicjatywa = 0;
	this->x = x;
	this->y = y;
}