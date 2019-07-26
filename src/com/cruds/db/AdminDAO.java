/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.db;

import com.cruds.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valar Morghulis
 */
public class AdminDAO {
    
    public boolean isValidAdmin(Admin admin)
    {
        String sql = "select admin_id, password from admin where admin_id = ? and password = ?";
        boolean flag = false;
        
        try(Connection conn = DBConnectionManager.getConnection())
	{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getId());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
            {
                flag = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
