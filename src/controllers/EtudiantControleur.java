package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DAOEtudiant;
import models.Etudiant;
import views.AjoutEtudiant;
import views.ListEtudiants;
import views.ModifEtudiant;

public class EtudiantControleur implements ActionListener{
	static AjoutEtudiant fr1;
	static ModifEtudiant fr2;
	static ListEtudiants fr3;
	Etudiant vm;
	DAOEtudiant ed = new DAOEtudiant();
	public EtudiantControleur(JFrame  f)
	{
		if (f instanceof AjoutEtudiant)
			fr1 = (AjoutEtudiant)f;
		if (f instanceof ModifEtudiant)
			fr2 = (ModifEtudiant)f;
		if (f instanceof ListEtudiants)
			fr3 = (ListEtudiants)f;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton b = (JButton)arg0.getSource();
		if (b.getText().equals("Ajouter")) {
		    if (fr1 == null) {
		        fr1 = new AjoutEtudiant();
		    }
		    fr1.setVisible(true);
		}
		if (b.getText().equals("Modifier")) {
		    if (fr2 == null) {
		        fr2 = new  ModifEtudiant(vm);
		    }
		    fr2.setVisible(true);
		}

		if (b.getText()=="Enregistrer")
		{
		
			if (fr1 != null) {
		       
		        Etudiant etudiant = new Etudiant(fr1.getX(), fr1.getName(), fr1.getPrenom(), fr1.getidGrpp());
		        boolean enregistrementReussi = ed.insert(etudiant);
		        if (enregistrementReussi) {
		            JOptionPane.showMessageDialog(null, "Enregistrement réussi !");
		        } else {
		            JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement !");
		        }
		    }
		}
		if (b.getText()=="Valider")
		{
			if (fr2 != null) {
		        Etudiant etudiant = new Etudiant(fr2.getX(), fr2.getNom(), fr2.getPrenom(), fr2.getIdGrp());
		        boolean validationReussie = ed.update(etudiant);
		        if (validationReussie) {
		            JOptionPane.showMessageDialog(null, "Validation réussie !");
		        } else {
		            JOptionPane.showMessageDialog(null, "Erreur lors de la validation !");
		        }
		    }
		}
		
		tmatricule = new JTextField(v.getMatricule());
    	p.add(lmatricule); p.add(tmatricule); tmatricule.setEnabled(false);
    	p.add(lnom); tnom = new JTextField(v.getNom());p.add(tnom); 
    	p.add(lprenom); tprenom = new JTextField(v.getPrenom());p.add(tprenom); 
    	p.add(lgroupe); 

		if (b.getText()=="Supprimer")
		{
			 if (fr3 != null) {
			        Etudiant idEtudiant = fr3.getEtudiantSelectionne();
			        boolean suppressionReussie = ed.delete(idEtudiant);
			        if (suppressionReussie) {
			            JOptionPane.showMessageDialog(null, "Suppression réussie !");
			        } else {
			            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression !");
			        }
			    }
		}
		
		
		}
	
		
}


