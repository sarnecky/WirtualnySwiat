#ifndef Lis_h
#define Lis_h
#include "Zwierze.h"
#include "Organizm.h"
using namespace std;

class Lis : public Zwierze
{
public:
	Lis( int x, int y);
	void akcja(Swiat &swiat, int i, int j);
};

#endif