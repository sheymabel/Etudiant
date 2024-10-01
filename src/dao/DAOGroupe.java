package dao;
import java.sql.*;
import java.util.ArrayList;

import models.Etudiant;
import models.Groupe;
import utilitaires.Utilitaire;
public class DAOGroupe implements IDAO <Groupe>{
	public  DAOGroupe()
	{
		Utilitaire.seConnecter("connectionPar.properties");			
	}
	@Override
	public Groupe findByID(Object id) {
		 Groupe groupe = null;
		    try {
		        Connection connection = Utilitaire.getConnection();
		        String query = "SELECT * FROM grpp WHERE Idgrpp = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, (String) id);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        if (resultSet.next()) {
		            String idgrpp = resultSet.getString("Idgrpp");
		            String libgrp = resultSet.getString("libgrp");
		            int niveau = resultSet.getInt("niveau");
		            String specialite = resultSet.getString("specialite");
		            groupe = new Groupe(idgrpp, libgrp, niveau, specialite);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return groupe;
		}	

	@Override
	public ArrayList<Groupe> findAll() {
		
		ArrayList <Groupe> list = new ArrayList<Groupe>();
		try {
	        Connection connection = Utilitaire.getConnection();
	        String query = "SELECT * FROM grpp";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            String idGrpp = resultSet.getString("Idgrpp");
	            String libgrp = resultSet.getString("libgrp");
	            int niveau = resultSet.getInt("niveau");
	            String specialite = resultSet.getString("specialite");
	            Groupe groupe = new Groupe(idGrpp, libgrp, niveau, specialite);
	            list.add(groupe);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return list;
	}

	

	@Override
	public boolean update(Groupe o) {
		 try {
		        Connection connection = Utilitaire.getConnection();
		        String query = "UPDATE grpp SET libgrp = ?, niveau = ?, specialite = ? WHERE Idgrpp = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, o.getLibGroupe());
		        preparedStatement.setInt(2, o.getNiveau());
		        preparedStatement.setString(3, o.getSpecialite());
		        preparedStatement.setString(4, o.getIdgrp());
		        int rowsUpdated = preparedStatement.executeUpdate();
		        return rowsUpdated > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }				
				
		
	}

	@Override
	public boolean delete(Groupe o) {
		  try {
		        Connection connection = Utilitaire.getConnection();
		        String query = "DELETE FROM grpp WHERE Idgrpp = ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, o.getIdgrp());
		        int rowsDeleted = preparedStatement.executeUpdate();
		        return rowsDeleted > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
				
		
	}

	@Override
	public boolean insert(Groupe o) {
		try {
	        Connection connection = Utilitaire.getConnection();
	        String query = "INSERT INTO grpp (Idgrpp, libgrp, niveau, specialite) VALUES (?, ?, ?, ?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, o.getIdgrp());
	        preparedStatement.setString(2, o.getLibGroupe());
	        preparedStatement.setInt(3, o.getNiveau());
	        preparedStatement.setString(4, o.getSpecialite());
	        int rowsInserted = preparedStatement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }

}
}
