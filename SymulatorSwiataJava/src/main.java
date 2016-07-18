import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import Organizmy.*;

public class main {
	  static Swiat swiat = new Swiat();
 public static void main(String[] args) throws FileNotFoundException{
	 
	 EventQueue.invokeLater(new Runnable(){
		 @Override
		 public void run(){
			 new MyFrame(swiat);
		 }
	 });
	 

 }
}
