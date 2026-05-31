package com.example;

import com.example.controller.Controller;
import com.example.model.Persona;
import com.example.view.MenuAgregar;
import com.example.view.MenuPrincipal;
import com.example.view.MenuDatos;
import com.example.view.MenuEdicion;
import com.example.view.MenuConfig;

public class Main {
    public static void main(String[] args) {

        // Inicializar FlatLaf para aplicar los estilos modernos y bordes redondeados
        try {
            com.formdev.flatlaf.FlatLightLaf.setup();
            
            // Configuración global para redondear todos los botones y componentes
            javax.swing.UIManager.put("Button.arc", 20);
            javax.swing.UIManager.put("Component.arc", 20);
        } catch (Exception e) {
            System.err.println("Error al inicializar FlatLaf");
        }

        MenuAgregar menuAgregar = new MenuAgregar();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuDatos menuDatos = new MenuDatos();
        MenuEdicion menuEdicion = new MenuEdicion();
        MenuConfig menuConfig = new MenuConfig();
        Persona persona = new Persona();
        Controller controller = new Controller(menuAgregar, persona, menuPrincipal, menuDatos, menuEdicion, menuConfig);
        controller.iniciar();
        

    }
}
