#ifndef Roslina_h
#define Roslina_h
#include "Organizm.h"

class Roslina : public Organizm
{
public:
	virtual void akcja(Swiat &swiat, int i, int j)=0;
	virtual void kolizja(Swiat &swiat, int i, int j) = 0;
    void zasiew(Swiat &swiat, int i, int j);
};

#endif