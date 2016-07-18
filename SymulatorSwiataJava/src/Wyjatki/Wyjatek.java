package Wyjatki;

public class Wyjatek extends Exception
{

	public Wyjatek(char z, int x, int y)
	{
		super("$eb@stian $@rnecki twierdzi, ¿e "+z+" nie jest poprawnym zwierzeciem ani roslina. Pozycja "+ x +" " + y);
	}
};
