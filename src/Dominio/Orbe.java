/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.*;
import Logica.*;

/**
 *
 * @author defGrupo()
 */
public class Orbe {
    
    private String nombre;
    private List <Campeon> listaCampeon;
    private ListaAspecto listaAspectoFragmento;
    private Orbe orbe;

    public Orbe(String nombre) {
        this.nombre = nombre;
        listaCampeon = new LinkedList();
        listaAspectoFragmento = new ListaAspecto();
        orbe = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Campeon> getListaCampeon() {
        return listaCampeon;
    }

    public void setListaCampeon(List<Campeon> listaCampeon) {
        this.listaCampeon = listaCampeon;
    }

    public ListaAspecto getListaAspectoFragmento() {
        return listaAspectoFragmento;
    }

    public void setListaAspectoFragmento(ListaAspecto listaAspectoFragmento) {
        this.listaAspectoFragmento = listaAspectoFragmento;
    }

    public Orbe getOrbe() {
        return orbe;
    }

    public void setOrbe(Orbe orbe) {
        this.orbe = orbe;
    }
    
}