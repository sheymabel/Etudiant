package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Etudiant;
import utilitaires.Utilitaire;

public class DAOEtudiant implements IDAO <Etudiant>{
	public  DAOEtudiant()
	{
		Utilitaire.seConnecter("connectionPar.properties");		
	}
	@Override
	public Etudiant findByID(Object id) {
		Etudiant e = null;
		try {
			Connection connection = Utilitaire.getConnection();
			String query = "SELECT *FROM etud where id_etudiant=? ";
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			preparedStatement.setInt(1, (int) id);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	        	 int idEtudiant = resultSet.getInt("id_etudiant");
	        	    String nom = resultSet.getString("nom");
	        	    String prenom = resultSet.getString("prenom");
	        	    String idGrpp = resultSet.getString("Idgrpp");

	        	    Etudiant  etudiant = new Etudiant(idEtudiant, nom, prenom, idGrpp);
	        	    
	        }
	    } catch (SQLException e1) {
	        e1.printStackTrace();
	    }     
		
		return e;
	}

	@Override
	public ArrayList<Etudiant> findAll() {
		
		ArrayList <Etudiant> list = new ArrayList<Etudiant>();
		 try {
		        Connection connection = Utilitaire.getConnection();
		        String query = "SELECT * FROM etud";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        while (resultSet.next()) {

		        	  int idEtudiant = resultSet.getInt("id_etudiant");
		              String nom = resultSet.getString("nom");
		              String prenom = resultSet.getString("prenom");
		              String idGrpp = resultSet.getString("Idgrpp");
		              Etudiant etudiant = new Etudiant(idEtudiant, nom, prenom, idGrpp);
		              list.add(etudiant);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return list;


	}

public ArrayList<Etudiant> findByGroupe(String g) {
		
		ArrayList <Etudiant> list = new ArrayList <Etudiant> () ;
		 try {
		        Connection connection = Utilitaire.getConnection();
		        String query = "SELECT * FROM etud WHERE Idgrpp = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, g);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        while (resultSet.next()) {
		        	  int idEtudiant = resultSet.getInt("id_etudiant");
		              String nom = resultSet.getString("nom");
		              String prenom = resultSet.getString("prenom");
		              String idGrpp = resultSet.getString("Idgrpp");
		              Etudiant etudiant = new Etudiant(idEtudiant, nom, prenom, idGrpp);
		              list.add(etudiant);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return list;
	}


	@Override
	public boolean update(Etudiant o) {
		try {
	        Connection connection = Utilitaire.getConnection();
	        String query = "UPDATE etud SET nom = ?, prenom = ?, Idgrpp = ? WHERE id_etudiant = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, o.getNom());
	        preparedStatement.setString(2, o.getPrenom());
	        preparedStatement.setString(3, o.getIdgrp());
	       // preparedStatement.setInt(4, o.getIdEtudiant());
	        int rowsUpdated = preparedStatement.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
		
	}

	@Override
	public boolean delete(Etudiant o) {
		 try {
		        Connection connection = Utilitaire.getConnection();
		        String query = "DELETE FROM etud WHERE id_etudiant = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setInt(1, o.getEtudiant);
		        int rowsDeleted = preparedStatement.executeUpdate();
		        return rowsDeleted > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        }
		return false;
	}

	@Override
	public boolean insert(Etudiant o) {
		
		 try {
		        Connection connection = Utilitaire.getConnection();
		        String query = "INSERT INTO etud (id_etudiant, nom, prenom, Idgrpp) VALUES (?, ?, ?, ?)";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setInt(1, o.getIdEtudiant());
		        preparedStatement.setString(2, o.getNom());
		        preparedStatement.setString(3, o.getPrenom());
		        preparedStatement.setString(4, o.getIdgrp());
		        int rowsInserted = preparedStatement.executeUpdate();
		        return rowsInserted > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
				return false;
		
	}


}
}
