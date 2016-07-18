#ifndef Mlecz_h
#define Mlecz_h
#include "Organizm.h"
#include "Roslina.h"

class Mlecz : public Roslina
{
public:
	void akcja(Swiat &swiat, int i, int j);
	void kolizja(Swiat &swiat, int i, int j);
	Mlecz(int x, int y);
};

#endif