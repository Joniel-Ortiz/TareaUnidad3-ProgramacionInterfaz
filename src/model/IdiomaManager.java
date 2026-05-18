package model;

import java.util.Locale;
import java.util.ResourceBundle;

public class IdiomaManager {
    private static IdiomaManager instancia;
    private ResourceBundle bundle;

    private IdiomaManager() {
        bundle = ResourceBundle.getBundle("locales.es", Locale.ROOT);
    }

    public static IdiomaManager getInstance() {
        if (instancia == null) instancia = new IdiomaManager();
        return instancia;
    }

    public void cambiarIdioma(String codigo) {
        switch (codigo) {
            case "en" -> bundle = ResourceBundle.getBundle("locales.es_en", Locale.ROOT);
            case "fr" -> bundle = ResourceBundle.getBundle("locales.es_fr", Locale.ROOT);
            default   -> bundle = ResourceBundle.getBundle("locales.es", Locale.ROOT);
        }
    }

    public String get(String clave) {
        return bundle.getString(clave);
    }
}