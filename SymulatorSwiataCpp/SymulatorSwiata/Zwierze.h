#ifndef Zwierze_h
#define Zwierze_h
#include "Organizm.h"

class Zwierze : public Organizm
{
public:
	void set(int x, int y);
protected:
	Polozenie nowe;
	void zmianaMiejsca(Swiat &swiat, int i, int j); //zmiana miejsca planszy, w stare wstawiamy NULL
	void kolizja(Swiat &swiat, int i, int j);
	void rozmnazanie(Swiat &swiat, int i, int j);
	virtual void akcja(Swiat &swiat, int i, int j) = 0;
};

#endif