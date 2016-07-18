#ifndef Zolw_h
#define Zolw_h
#include "Zwierze.h"

class Zolw : public Zwierze
{
private:
	int przypadki;
public:
	Zolw(int x, int y);
	void akcja(Swiat &swiat, int i, int j);
};

#endif