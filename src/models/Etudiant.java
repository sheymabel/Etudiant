package models;

public class Etudiant {
public static final int getEtudiant = 0;
private String matricule;
private String nom;
private String prenom;
private String idgrp;
public Etudiant() {}
public Etudiant (String m, String n, String p, String idg)
{
	matricule =m;
	nom =n;
	prenom =p;
	idgrp=idg;
}
public Etudiant(int idEtudiant, String nom2, String prenom2, String idGrpp) {
super();
}
public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getIdgrp() {
	return idgrp;
}
public void setIdgrp(String idgrp) {
	this.idgrp = idgrp;
}
public String toString()
{
	String s = "\tMatricule : " + matricule + "\n" 
			+ "\tNom : " + nom + "\n"
			+ "\tPrenom : " + prenom + "\n" 
			+ "\tGroupe : " + idgrp + "\n";
			
	return s;
}
public int getIdEtudiant() {
	// TODO Auto-generated method stub
	return 0;
}

}
