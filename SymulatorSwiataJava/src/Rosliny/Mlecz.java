package Rosliny;
import java.awt.Color;
import java.util.Random;

import Organizmy.*;

public class Mlecz extends Roslina{
	
	private Zasoby a1;

	@Override
	public void akcja(Swiat swiat, int i, int j) {
		// TODO Auto-generated method stub
		
		//3 proby rozmnozenia 
		int a;
		int n = 0;
		Polozenie nowe;
		Random gen = new Random();
		while (n<3)
		{
			a = gen.nextInt(100);
			if (a <1)
			{
				nowe = losuj();
				if (swiat.getSymbol(nowe.x,nowe.y) != ' '){}
				else
				{
					swiat.stworzOrganizm(swiat, 'M', nowe.x, nowe.y);
				}
			}

			n++;
		}
	}

	@Override
	public void kolizja(Swiat swiat, int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	public Mlecz(int x1, int y1)
	{
		wiek = 0;
		sila = 0;
		wyglad = 'M';
		inicjatywa = 0;
		x = x1;
		y = y1;
		color = Color.MAGENTA;
	}

}
