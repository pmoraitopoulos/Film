/**
 * @author Moraitopoulos, Panagiotis
 * @version 2022.06.04
 * @class MIS2022
 */
package Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Film film1 = new Film("Star Trek IV The Voyage Home","Leonard Nimoy",159,"26-11-1986");
		
		Film film2 = new Film("Star Trek III The Search for Spock","Leonard Nimoy",149,"01-06-1984");
		
		Film film3 = new Film("Star Trek V The Final Frontier","William Shatner",128,"09-06-1989");
		
		film1.setCandidacy(false);
		film2.setCandidacy(true);
		
		FilmProgram Films = new FilmProgram();
		Films.store(film1);
		Films.store(film2);
		Films.store(film3);
		
		Films.showFilms();
		
		Films.showMonthFilms(12);
		
		System.out.println("The mean playing time of all the films in the collection is "+Films.filmsMeanTime());
		System.out.println();
		Films.findFilm("Star Trek IV The Voyage Home");
		System.out.println();
		Films.findFilm("Home Alone 3");
		
		Films.showMonthFilms(06);
		
		
		FilmProgram newCollection = new FilmProgram();
		
		System.out.println("\nΕισαγωγή Νέων Ταινιών στη Λίστα  New Collection\n");
		
		newCollection.massOccupation();
		
		newCollection.showFilms();
		
		newCollection.showMonthFilms(06);
		
		newCollection.showCandidateFilms();
	}

}
