package Organizmy;

public enum Zasoby {
	
	CZLOWIEK('C'),
	WILK('W'),
	ZOLW('Z'),
	ANTYLOPA('A'),
	LIS('L'),
    OWCA('O'),
	GUARANA('G'),
    MLECZ('M'),
	TRAWA('T'),
	WILCZAJAGODA('J'),
	WIELKOSC(20),
	RUNDY(40);
	
	private char z;
	private int l;
	
	Zasoby (char z)
	{
		this.z = z;
	}
	
	Zasoby (int l)
	{
		this.l = l;
	}
	
	public char kto(Zasoby z)
	{
		if(z==CZLOWIEK) return 'C';
		
		return 0;
	}
	
	public int ile(Zasoby l)
	{
		if(l.equals(WIELKOSC))
		    return 20;
		else if(l.equals(RUNDY))
			return 40;
		else 
			return 0;
	}
}
