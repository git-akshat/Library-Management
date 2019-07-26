/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.model;

/**
 *
 * @author Valar Morghulis
 */
public class Admin {
    String id;
    String password;
    
    public Admin(String id, String password)
    {
        this.id = id;
        this.password = password;
    }
    
    public String getId() {
	return id;
    }
    
    public String getPassword() {
	return password;
    }
    
}
