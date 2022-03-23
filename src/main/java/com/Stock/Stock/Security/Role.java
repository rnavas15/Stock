/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Security;

import com.google.common.collect.Sets;
import java.util.Set;
import static com.Stock.Stock.Security.RolesPermisos.*;

/**
 *
 * @author rnavas
 */
public enum Role {

    /**
     *
     */
    ADMIN(Sets.newHashSet(ADMIN_READ,ADMIN_WRITE))
    ,USER(Sets.newHashSet());
    
    private final Set<RolesPermisos> permisos; 

    private Role(Set<RolesPermisos> permisos) {
        this.permisos = permisos;
    }

    public Set<RolesPermisos> getPermisos() {
        return permisos;
    }
    
    
    
}
