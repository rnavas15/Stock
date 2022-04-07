/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rnavas
 */
@Controller
public class Controlador {
  
//   
     @GetMapping("/")
    public String index() {
       

            return "Index";
    }
//    @GetMapping("/login")
//    public String login(@RequestParam(required = false) String error, 
//            @RequestParam(required = false) String logout, ModelMap model) {
//        
//        if (error != null) {
//            model.put("error", "Usuario o clave incorrectos");
//        }
//        if (logout != null) {
//            model.put("logout", "Ha salido correctamente.");
//        }
//        return "/principal/login.html";
//    }
//
//    @GetMapping("/registro")
//    public String registro(ModelMap modelo) {
//
//        return "/Principal/formulario-registro.html";
//    }
//
//    @PostMapping("/registrar")
//    public String registrar(ModelMap modelo, @RequestParam String nombre, @RequestParam String apellido,
//            @RequestParam String email, @RequestParam String clave1, @RequestParam String clave2,
//            MultipartFile foto,@RequestParam String direccion) {
//
//        try {
//            
//                      
//            usuarioServicio.registrar(nombre, apellido, email, clave1, clave2,foto, direccion);
//        } catch (Exception ex) {
//
//            modelo.put("mensaje2", ex.getMessage());
//            modelo.put("nombre", nombre);
//            modelo.put("apellido", apellido);
//            modelo.put("email", email);
//            modelo.put("clave1", clave1);
//            modelo.put("clave2", clave2);
//            modelo.put("direccion", direccion);
//
//            return "/principal/formulario-registro.html";
//        }
//        modelo.put("mensaje", "Bienvenido a la libreria mas poronga");
//
//        return "redirect:/login";
//    }
//
//}
    
}
