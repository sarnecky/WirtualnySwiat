#ifndef Trawa_h
#define Trawa_h
#include "Organizm.h"
#include "Roslina.h"

class Trawa : public Roslina
{
public:
	void akcja(Swiat &swiat, int i, int j);
	void kolizja(Swiat &swiat, int i, int j);
	Trawa(int x, int y);
};

#endif