package Zwierzeta;
import java.awt.Color;

import Organizmy.*;

public class Zolw extends Zwierze{

	private Zasoby a;
	private int przypadki;
	
	@Override
	public void akcja(Swiat swiat, int i, int j) {
		//w przypadku zolwia, rusza sie on co 4 wejscie do akcja()

		if (przypadki < 3) przypadki++;
		else
		{
			nowe = losuj();
			przypadki = 0;
			kolizja(swiat, i, j);
			/*set(nowe.x, nowe.y);
			zmianaMiejsca(swiat, i, j);*/
		}
		wiek++;
	}
	
	public Zolw(int x1, int y1)
	{
		wiek = 0;
		x = x1;
	    y = y1;
		wyglad = 'Z';
		inicjatywa = 1;
		sila = 2;
		przypadki = 0;
		color = Color.LIGHT_GRAY;
	}

}
