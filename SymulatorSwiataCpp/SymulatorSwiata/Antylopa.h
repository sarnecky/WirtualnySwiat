#ifndef Antylopa_h
#define Antylopa_h
#include "Zwierze.h"

class Antylopa : public Zwierze
{
public:
	Antylopa(int x, int y);
	void akcja(Swiat &swiat, int i, int j);
};

#endif