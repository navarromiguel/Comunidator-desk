package com.comunidator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.plaf.SeparatorUI;

import utils.FileManager;

public class Application {

	private static final String PATH = "src/";
	public static final String TXT_FILE = PATH + "lista.txt";
	public static final String CSV_FILE = PATH + "lista.txt";

	private Comunidator comunidad;
	private Scanner sc;
	
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
	
	public Application(){
		this.comunidad = new Comunidator(TXT_FILE);
		this.sc = new Scanner(System.in);
	}
	
	public void run(){
		System.err.println("BIENVENIDO A COMUNIDATOR!");
		showMenu();
		int opt = chooseOption();
		while(opt != 0){
			processOption(opt);
			showMenu();
			opt = chooseOption();
		}
		sc.close();
	}
	
	// Imprime el menú por pantalla
		public void showMenu(){
			System.err.println("Elige una opción:");
			System.out.println("1. Ver lista de la comunidad");
			System.out.println("2. Añadir nuevo hermano");
			System.out.println("0. Salir");
		}
	
	// Método para que el usuario marque una opción
	public int chooseOption(){
		return Integer.parseInt(sc.nextLine());
	}
	
	// Procesa la opción del usuario
	public void processOption(int opt){
		switch(opt){
		case 1:
			comunidad.printComunidad();
			break;
		case 2:
			Map<String, Object> datas = readDatasFromUser();
			try {
				comunidad.addNewMember((String) datas.get("name"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 0:
			break;
		}
	}
	
	// Recoge los datos del usuario cuando está añadiendo un nuevo hermano
	private Map<String, Object> readDatasFromUser(){
		Map<String, Object> datas = new HashMap<String, Object>();
		
		System.out.println("Introduce el nombre:");
		String name = sc.nextLine();
		datas.put("name", name);
		
		System.out.println("Introduce el nombre del cónyuge:");
		String name2 = sc.nextLine();
		datas.put("name2", name2);
		
		System.out.println("Introduce la dirección postal:");
		String dir = sc.nextLine();
		datas.put("dir", dir);
		
		System.out.println("¿Está casado con alguien de la comunidad?");
		String isMarried = sc.nextLine();
		datas.put("isMarried", isMarried);
		
		return datas;
	}
	
	

}
