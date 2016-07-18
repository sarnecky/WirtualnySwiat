#ifndef Organizm_h
#define Organizm_h
#include "Polozenie.h"
#include <iostream>

class Swiat;

class Organizm
{
protected:
	int sila,_id;
	int x, y;
	char wyglad;
	int wiek;
	int inicjatywa;
	Swiat *swiat;
public:
	virtual void akcja(Swiat &swiat, int i, int j)=0;
	virtual void kolizja(Swiat &swiat, int i, int j)=0;
	void zabijOrganizm(Swiat &swiat, int x, int y);
	void dodajOrganizm(Swiat &swiat, int i, int j);
	Polozenie losuj();
	char rysowanie();
	int getx();
	int gety();
	int getSila();
	int getId();
	int getInicjatywa();
	int getWiek();
	void setWiek(int w);
	void setId(int id);
	void setSila(int x); // x - liczba o jaka zostaje powiekszona sila

};

#endif