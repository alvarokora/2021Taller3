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
public class Jugador extends Persona{
    
    private double saldo;
    private List <Campeon> listaCampeon;
    private List <Orbe> listaOrbe;
    private ListaAspecto listaFragmentoAspecto;

    public Jugador(String nombre, String contraseña, double saldo) {
        super(nombre, contraseña);
        this.saldo = saldo;
        listaCampeon = new LinkedList();
        listaOrbe = new LinkedList();
        listaFragmentoAspecto = new ListaAspecto();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Campeon> getListaCampeon() {
        return listaCampeon;
    }

    public void setListaCampeon(List<Campeon> listaCampeon) {
        this.listaCampeon = listaCampeon;
    }

    public List<Orbe> getListaOrbe() {
        return listaOrbe;
    }

    public void setListaOrbe(List<Orbe> listaOrbe) {
        this.listaOrbe = listaOrbe;
    }

    public ListaAspecto getListaFragmentoAspecto() {
        return listaFragmentoAspecto;
    }

    public void setListaFragmentoAspecto(ListaAspecto listaFragmentoAspecto) {
        this.listaFragmentoAspecto = listaFragmentoAspecto;
    }
    
}