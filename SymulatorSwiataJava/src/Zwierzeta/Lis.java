package Zwierzeta;
import java.awt.Color;

import Organizmy.*;

public class Lis extends Zwierze{

	private Zasoby a;
	
	@Override
	public void akcja(Swiat swiat, int i, int j) {
		
		nowe = losuj();
		int przeciwnicy = 0;
		
		if (swiat.getSymbol(nowe.x, nowe.y) != ' ')
		{
			while (przeciwnicy < 12) //sprawdza pola dookola lisa, czy jest ktos slabszy
			{						//max 12 iteracji powinno wyczerpac wszystkie mozliwosci
									//istnieje mozliwosc ze lis nie ruszy sie wgl
				if (swiat.getSymbol(nowe.x, nowe.y) != ' ' && getSila() < swiat.getSilaOrganizmu(nowe.x,nowe.y))
				{
					nowe = losuj();
					przeciwnicy++;
				}
				else if (swiat.getSymbol(nowe.x, nowe.y) != ' ' && getSila() > swiat.getSilaOrganizmu(nowe.x, nowe.y))
				{
					set(nowe.x, nowe.y);
					zmianaMiejsca(swiat, i, j);
					przeciwnicy = 12;
				}
				else if (swiat.getSymbol(nowe.x, nowe.y) == ' ')
				{
					set(nowe.x, nowe.y);
					zmianaMiejsca(swiat, i, j);
					przeciwnicy = 12;
				}		
			}
				
			//jezeli rowna to rozmnazanko
			//jezeli mniejsza to lis zabija
		}
		else
		{
			set(nowe.x, nowe.y);
			zmianaMiejsca(swiat, i, j);
		}

		wiek++;
		
	}
	
	public Lis(int x1, int y1)
	{
		wiek = 0;
		x = x1;
		y = y1;
		wyglad = 'L';
		inicjatywa = 7;
		sila = 3;
		color = Color.ORANGE;
	}

}
