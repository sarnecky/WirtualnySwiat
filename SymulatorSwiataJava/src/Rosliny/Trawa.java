package Rosliny;
import java.awt.Color;

import Organizmy.*;

public class Trawa extends Roslina{
	
	private Zasoby a;

	@Override
	public void akcja(Swiat swiat, int i, int j) {
		// TODO Auto-generated method stub
		zasiew(swiat,i,j);
	}

	@Override
	public void kolizja(Swiat swiat, int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	public Trawa(int x1, int y1)
	{
		wiek = 0;
		sila = 0;
		wyglad = 'T';
		inicjatywa = 0;
		x = x1;
		y = y1;
		color = Color.GREEN;
	}
}
