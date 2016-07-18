#ifndef Guarana_h
#define Guarana_h
#include "Organizm.h"
#include "Roslina.h"
class Guarana : public Roslina
{
public:
	void akcja(Swiat &swiat, int i, int j);
	void kolizja(Swiat &swiat, int i, int j);
	Guarana(int x, int y );
};

#endif