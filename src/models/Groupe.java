package models;

public class Groupe {
	private String idgrp;
	private String libGroupe;
	private int niveau; 
	private String specialite;
	public Groupe() {}
	public Groupe (String id, String lib, int n, String s)
	{
		idgrp=id;
		libGroupe = lib;
		niveau =n;
		specialite = s;
	}
	public String getIdgrp() {
		return idgrp;
	}
	public void setIdgrp(String idgrp) {
		this.idgrp = idgrp;
	}
	public String getLibGroupe() {
		return libGroupe;
	}
	public void setLibGroupe(String libGroupe) {
		this.libGroupe = libGroupe;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String toString()
	{
		String s = "\tIdentifiant groupe : " + idgrp + "\n" 
				+ "\tLibell� groupe : " + libGroupe + "\n"
				+ "\tSp�cialit� : " + specialite + "\n" 
				+ "\tNiveau : " + niveau + "\n";
				
		return s;
	}
}
