#ifndef Czlowiek_h
#define Czlowiek_h
#include "Zwierze.h"

class Czlowiek : public Zwierze
{
public:
	Czlowiek(int x, int y);
	void kolizja(Swiat &swiat, int i, int j);
	void akcja(Swiat &swiat, int i, int j);
	void calopalenie(Swiat &swiat, int i, int j);
private:
	bool _calopalenie;
	int _tury;
	int _pauza;

};

#endif