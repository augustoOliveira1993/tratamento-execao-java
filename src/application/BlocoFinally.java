package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.entities.Pessoa;

public class BlocoFinally {

	public static void main(String[] args) {
		
		
		
		File file = new File("c:\\temp\\in.txt");
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String[] arr = sc.nextLine().split(",");
				Pessoa p = new Pessoa(arr[0], Integer.parseInt(arr[1]), arr[2]);
				System.out.println(p);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Error opening file: " + e.getMessage());
		}finally {
			if(sc != null) {				
				sc.close();
			}
			System.out.println("Finally block exception");
		}

	}

}
