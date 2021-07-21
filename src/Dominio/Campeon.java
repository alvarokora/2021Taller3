/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Logica.*;

/**
 *
 * @author defGrupo()
 */
public class Campeon {
    
    private String nombre;
    private String linea;
    private ListaAspecto listaAspecto;

    public Campeon(String nombre, String linea) {
        this.nombre = nombre;
        this.linea = linea;
        listaAspecto = new ListaAspecto();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public ListaAspecto getListaAspecto() {
        return listaAspecto;
    }

    public void setListaAspecto(ListaAspecto listaAspecto) {
        this.listaAspecto = listaAspecto;
    }
    
}