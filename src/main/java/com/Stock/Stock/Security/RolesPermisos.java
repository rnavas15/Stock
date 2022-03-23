/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Security;

/**
 *
 * @author rnavas
 */
public enum RolesPermisos {
    ADMIN_READ("read"),
    ADMIN_WRITE("write"),
    USER_READ("read"),
    USER_WRITE("write");
    
    private final String permisos;

    RolesPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getPermisos() {
        return permisos;
    }

}
