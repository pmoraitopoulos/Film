/**
 * The Film class represent a Film with its own title, director, duration and date.
 * @author Moraitopoulos, Panagiotis
 * @version 2022.06.04
 * @class MIS2022
 */
package Main;

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Film {

	private String title;
	private String director;
	private int playingTime;
	private boolean candidacy;
	private String showDate;
	
	private Scanner in = new Scanner(System.in);
	
	//Constructor 1
	
	public Film(String title, String director, int playingTime, String showDate) {
		this.title = checkName(title);
		this.director = checkName(director);
		this.playingTime = playingTime;
		this.showDate = checkDate(showDate);
		candidacy = false;
		
	}
	//Constructor 2
	public Film(String title) {
		this.title = checkName(title);
	}
	
	//Check Every String in Constructors and Setters
	private String checkName(String name) {
		while(!name.matches("[a-zA-Z]+( +[a-zA-Z]+)*") && name.isBlank() && !name.matches("[a-zA-Z]+") ) {
			System.out.println("Λάθος Όνομα Director ή Τίτλου");
			name = in.nextLine();
		}
		 return name;
	}
	
	private String checkDate(String date) {
		while(!date.matches("[0-9]+"+"-"+"[0-9]+"+"-"+"[0-9]+") || date.isBlank()){
			System.out.println("Λάθος Ημερομηνία Πρέπει να είναι dd-mm-yyyy");
			date = in.nextLine();
		}
		return date;
	}
	
	//Returns the day of a String with Date
	public int getDatePartDay(String showDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(showDate, format);
		int day = date.getDayOfMonth();
		return day;
	}
	
	//Returns the month as Month of a String with Date
	public Month getDatePartMonth(String showDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(showDate, format);
		Month month = date.getMonth();
		return month;
	}
	//Returns the year of a String with Date
	public int getDatePartYear(String showDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(showDate, format);
		int year = date.getYear();
		return year;
	}
	//Convert month to int
	public int convertMonth(Month month) {
		int integer = 0;
		switch(month) {
		case JANUARY:
			integer = 1;
			break;
		case FEBRUARY:
			integer = 2;
			break;
		case MARCH:
			integer = 3;
			break;
		case APRIL:
			integer = 4;
			break;
		case MAY:
			integer = 5;
			break;
		case JUNE:
			integer = 6;
			break;
		case JULY:
			integer = 7;
			break;
		case AUGUST:
			integer = 8;
			break;
		case SEPTEMBER:
			integer = 9;
			break;
		case OCTOBER:
			integer = 10;
			break;
		case NOVEMBER :
			integer= 11;
			break;
		case DECEMBER :
			integer = 12;
			break;		
		}
		if(integer ==0) {
			System.out.println("Something Went Wrong");
		}
		return integer;
	}
	
	//Getters
	
	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public int getPlayingTime() {
		return playingTime;
	}

	public boolean isCandidacy() {
		return candidacy;
	}

	public String getShowDate() {
		return showDate;
	}
	
	//Setters
	
	public void setTitle(String title) {
		this.title = checkName(title);
	}

	public void setDirector(String director) {
		this.director = checkName(director);
	}

	public void setPlayingTime(int playingTime) {
		this.playingTime = playingTime;
	}

	public void setCandidacy(boolean candidacy) {
		if(this.candidacy !=candidacy) {
			this.candidacy = candidacy;
			System.out.print("H ταινία ");
			if(candidacy) {
				System.out.print("προστέθηκε ως υποψήφια ");
			}
			else
				System.out.print("αφαιρέθηκε από υποψήφια ");
			System.out.println("για Όσκαρ.");
		}
		else {
			System.out.print("Καμία αλλαγή δε προέκυψε. H ταινία ");
			if(this.candidacy) 
				System.out.print("είνα ");
			else
				System.out.print("δεν είναι ");
			System.out.println("υποψήφια για Όσκαρ.");
		}
		
	}
	public void setShowDate(String showDate) {
		this.showDate = checkDate(showDate);
	}
	
	//Prints all fields of the Class Employee
	
	public void print() {
		System.out.println("************");
		System.out.println(getTitle()+", Director "+getDirector());
		System.out.println(getPlayingTime()+" minutes");
		System.out.println(getShowDate());
		if(candidacy) {
			System.out.println("Candidate for Oscar!");
		}
		System.out.println("_______________");
		System.out.println();
	}
	
}
