#ifndef WilczaJagoda_h
#define WilczaJagoda_h
#include "Organizm.h"
#include "Roslina.h"

class WilczaJagoda : public Roslina
{
public:
	void akcja(Swiat &swiat, int i, int j);
	void kolizja(Swiat &swiat, int i, int j);
	WilczaJagoda(int x, int y);
};
#endif
