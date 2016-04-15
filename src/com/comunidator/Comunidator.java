package com.comunidator;

import java.io.IOException;
import java.util.List;

import utils.FileManager;

public class Comunidator {
	
	private String list; // lista de hermanos de la comunidad
	
	public Comunidator(String file){
		this.list = file;
	}

	// Devuelve una lista con los hermanos de la comunidad
	public List<String> listComunidad() throws IOException{
		return FileManager.read(list);
	}
	
	// Imprime por consola la lista de la comunidad
	public void printComunidad(){
		FileManager.printFile(list);
		System.out.println();
	}
	
	// Añade nuevo miembro a la comunidad
	public void addNewMember(String data) throws IOException{
		FileManager.appendLine(list, data);
	}
	
	// Añade un nuevo hermano a fichero CSV
	public void addNewMemberToCSV(String name, String name2, String dir, boolean isMarried) throws IOException{
		int id = getLastId() + 1;
		int newMarriedId = getLastMarriedId() + 1;
		String data = id + ";" + name + ";" + dir + ";" + (isMarried ? "SI;" + newMarriedId : "NO;" + "-1");
		if(isMarried){
			data += "\n"; // añadimos a su pareja
			data += id + ";" + name2 + ";" + dir + ";" + (isMarried ? "SI;" + newMarriedId : "NO;" + "-1");
		}
		FileManager.appendLine(list, data);
	}
	
	// Retorna el id del último hermano en lista
	private int getLastId(){
		// TODO
		return 0;
	}
	
	// Devuelve el último ID de matrimonio en lista
	private int getLastMarriedId(){
		// TODO
		return 0;
	}
	
	public int getTotalMarried(){
		// TODO
		return 0;
	}
	
	public List<String> getDirs(){
		// TODO
		return null;
	}
	
	// TODO - Method to generate groups (n)
	
	
	public void printGroups(){
		// TODO
	}
}
