package Organizmy;

import java.util.Random;

public abstract class Roslina extends Organizm{

	private Zasoby a1;
	public abstract void akcja(Swiat swiat, int i, int j);
	public abstract void kolizja(Swiat swiat, int i, int j);
    public void zasiew(Swiat swiat, int i, int j)
    {
    	Random gen = new Random();
    	int a = gen.nextInt(100);
    	Polozenie nowe;
    	if (a <3)
    	{
    		nowe = losuj();
    		if (rysowanie() == 'G')
    		{
    			if (swiat.getSymbol(nowe.x,nowe.y) != ' '){} // jezeli wylosuje miejsce zajete to nie urosnie nowa
    			else
    			{
    				swiat.stworzOrganizm(swiat, 'G', nowe.x, nowe.y);
    			}

    		}
    		else if (rysowanie() == 'T')
    		{
    			if (swiat.getSymbol(nowe.x, nowe.y) != ' '){} // jezeli wylosuje miejsce zajete to nie urosnie nowa
    			else
    			{
    				swiat.stworzOrganizm(swiat, 'T', nowe.x, nowe.y);
    			}

    		}
    		else if (rysowanie() == 'J')
    		{
    			if (swiat.getSymbol(nowe.x, nowe.y) != ' '){} // jezeli wylosuje miejsce zajete to nie urosnie nowa
    			else
    			{
    				swiat.stworzOrganizm(swiat, 'J', nowe.x, nowe.y);
    			}


    		}
    		swiat.logi(rysowanie(), " rozmnaza sie ", swiat.getSymbol(nowe.x, nowe.y));
    	}
    }
	
}
