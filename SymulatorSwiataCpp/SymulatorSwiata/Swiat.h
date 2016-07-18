#ifndef Swiat_h
#define Swiat_h
#include "Polozenie.h"
#include "Czlowiek.h"
#include "Zwierze.h"
#include "Lis.h"
#include "Wilk.h"
#include "Owca.h"
#include "Zolw.h"
#include "Antylopa.h"
#include "Trawa.h"
#include "Mlecz.h"
#include "Guarana.h"
#include "WilczaJagoda.h"

class Swiat
{
private:
	int iloscOrganizmow;
	Organizm *plansza[20][20];
	Organizm *organizmy[400];
	Swiat *swiat;
	string Logi[400];
	int iloscLogow;
	int runda;
public:
	Swiat();
	~Swiat();
	void rysujSwiat();
	void wykonajTure(Swiat &swiat);
	Swiat(Swiat &swiat);
	void zapis(Swiat &swiat);
	friend ostream & operator<<(ostream &out, Swiat &swiat);
	friend ifstream & operator>>(ifstream &in, Swiat &l);
	void logi(char kto, string log, char kogo);
	void wyswietlLogi();
	void transport(Swiat &swiat, int id);
	void usunOrganizm(Swiat &swiat, int i, int j);
	void stworzOrganizm(Swiat &swiat, char z, int j, int i);
	void sortowanie(Swiat &swiat);
	char getSymbol(int x, int y);
	int getSilaOrganizmu(int x, int y);
	void wywolajKolizje(Swiat &swiat, int x, int y, int x2, int y2);
	int getIloscOrganizmow();
	void zabijStworzenie(Swiat &swiat, int x, int y);
	void dodajStworzenie(Swiat &swiat, int i, int j);
	int getSila(int x, int y);
	int getWiek(int x, int y);
	void zmianaMiejsca(int i, int j, int x, int y);
	int getId(int x, int y);
	void setSila(int ile, int x, int y);
	bool czy(Organizm *w);
	void gotoxy(int x, int y);
	
	
};

#endif