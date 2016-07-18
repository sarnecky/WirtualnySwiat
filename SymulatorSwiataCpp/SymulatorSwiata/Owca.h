#ifndef Owca_h
#define Owca_h
#include "Zwierze.h"

class Owca : public Zwierze
{
public:
	Owca( int x, int y);
	void akcja(Swiat &swiat, int i, int j);
};

#endif