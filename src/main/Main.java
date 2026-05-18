package main;

import controller.Controller;
import model.Persona;
import view.MenuAgregar;
import view.MenuPrincipal;
import view.MenuDatos;
import view.MenuEdicion;
import view.MenuConfig;

public class Main {
    public static void main(String[] args) {
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
