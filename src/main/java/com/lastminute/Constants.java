package com.lastminute;

/**
 * Constants class to hold information useful accross the codebase. Please note
 * for the purpose of this exercise, some constants that should be stored in the
 * database, will be set here
 * 
 * @author Manuel Moranchel
 *
 */
public class Constants {
	
	/** Tax percentage for imported goods. This should be stored in the database */
	public static double IMPORTED_TAX_PERCENTAGE = 0.05;
	
	/** Tax percentage for goods except books, food or medical. This should be stored in the database */
	public static double TAX_PERCENTAGE = 0.10;
}
