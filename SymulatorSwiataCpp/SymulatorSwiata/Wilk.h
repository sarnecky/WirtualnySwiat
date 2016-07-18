#ifndef Wilk_h
#define Wilk_h
#include "Zwierze.h"

class Wilk : public Zwierze
{
public:
	Wilk(int x, int y);
	void akcja(Swiat &swiat, int i, int j);
};

#endif