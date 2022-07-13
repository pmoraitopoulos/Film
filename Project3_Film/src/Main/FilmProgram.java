/**
 * The FilmProgram class represent a collection of Films programs. It takes items from Film Class.
 * @author Moraitopoulos, Panagiotis
 * @version 2022.06.04
 * @class MIS2022
 */
package Main;
import java.util.*;

public class FilmProgram {
	
	private ArrayList<Film> list;
	private ArrayList<Film> monthFilms;
	private Scanner in = new Scanner(System.in);
	
	//Constructor
	public FilmProgram() {
		list = new ArrayList<>();
		monthFilms = new ArrayList<>();
	}
	
	//It stores films in the main Array List
	public void store(Film film) {
		list.add(film);
	}
	
	
	public ArrayList<Film> getList() {
		return list;
	}
	
	public void showFilms() {
		System.out.println("******** Πλήρη Λίστα Ταινιών *********");
		for(Film film : list) {
			film.print();
		}
	}
	
	public void showMonthFilms(int month) {
		monthFilms(month);
		try {
			System.out.println("******** Λίστα Ταινιών Μήνα " + monthFilms.get(0).getDatePartMonth(monthFilms.get(0).getShowDate())+ " ***********");
			for(Film film : monthFilms) {
				film.print();
			}
		
		}
		catch (Exception e) {
			System.out.println("Η λίστα είναι κενή. Καμία ταινία αυτό το μήνα");
		}
	}
	
	public void showCandidateFilms() {
		for(Film film : list) {
			if(film.isCandidacy()) {
				film.print();
			}
		}
	}
	
	
	//Calculates Mean Time of all films
	public double filmsMeanTime() {
		double sumTime =0;
		for(Film film : list) {
			sumTime +=film.getPlayingTime();
		}
		return sumTime/list.size();		
	}
	
	//Calculate Mean time of Month List
	public double filmsMonthMeanTime() {
		double sumTime =0;
		for(Film film : monthFilms) {
			sumTime +=film.getPlayingTime();
		}
		return sumTime/monthFilms.size();		
	}
	
	//Search for a given title
	public void findFilm(String title) {
		boolean isFinded = false;
		for(Film film : list) {
			if(film.getTitle().equals(title)) {
				film.print();
				isFinded = true;
				break;
			}
		}
		if(!isFinded) {
			System.out.println("The film "+ title + " does not belong to the collection");
		}
	}
	
	//For given month store these films in a new List.
	private void monthFilms(int month)  {
		try {
			for(Film film : list) {
				if(film.convertMonth(film.getDatePartMonth(film.getShowDate())) == month) {
					monthFilms.add(film);
				}
			}
		} catch(Exception e) {
			System.out.println("Δεν έχετε περάσει όλες τις πληροφορίες μέσα στις ταινίες για να\nζητάτε ταινίες συγκεκριμένου μήνα"
					+ ". Ενημερώστε τις ταινίες\nκαι ζητήστε εκ νέου τις ταινίες του μήνα."); 
		}
	}
	
	//Procedure for Insert Films in the Main List
	public void massOccupation() {
		boolean more = true;
		Film tempFilm = null;
		while(more) {
			//Eisagogi Titlou Tainias
			System.out.println("Εισάγετε Τίτλο ταινίας");
			String title = in.nextLine();
			/*O xristis apofasizi an 8elei na valei kai alles plirofories. Antistixa 8a xrisimopoi8ei o protos i 
			 * o deuteros kataskeyastis.
			 * ginete elegxos gia sosti apantisi
			 */
			System.out.println("Θέλετε να εισάγετε περισσότερες Πληροφορίες για τη ταινία? y/n");
			String answer = in.nextLine();
			while(!answer.equals("y") && !answer.equals("n")) {
				System.out.println("Λάθος επιλογή. Θέλετε να εισάγετε περισσότερες Πληροφορίες για τη ταινία? y/n");
				answer = in.nextLine();
			}
			//code
			if(answer.equals("y")) {
				System.out.println("Εισάγετε όνομα Director");
				String director = in.nextLine();
				System.out.println("Εισάγετε Χρόνο");
				int playingTime = in.nextInt();
				in.nextLine();
				System.out.println("Εισάγετε Ημερομηνία Προβολής dd-mm-yyyy");
				String showTime = in.nextLine();
				tempFilm = new Film(title,director,playingTime,showTime);
				break;
			}else {
				tempFilm = new Film(title);
				}
			//candidacy
			System.out.println("Η ταινία είναι υποψήφια για όσκαρ; y/n");
			answer = in.nextLine();
			while(!answer.equals("y") && !answer.equals("n")) {
				System.out.println("Λάθος επιλογή. Η ταινία είναι υποψήφια για Όσκαρ. y/n");
				answer = in.nextLine();
			}
			tempFilm.setCandidacy(answer.equals("y"));
			//prosthiki tainias sti lista
			list.add(tempFilm);
			
			System.out.println("Θέλετε να καταχωρήσετε νέες ταινίες? y/n");
			answer = in.nextLine();
			while(!answer.equals("y") && !answer.equals("n")) {
				System.out.println("Λάθος επιλογή. Θέλετε να καταχωρήσετε νέες ταινίες y/n");
				answer = in.nextLine();
			}
			
			more = answer.equals("y");
		}
	}
}		
	
	


