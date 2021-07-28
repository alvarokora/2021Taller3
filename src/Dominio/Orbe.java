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
    
    public Campeon orbeCampeon(){
        Random r = new Random();
        int indice = r.nextInt(listaCampeon.size());
        return listaCampeon.get(indice);
    }
    
    public Aspecto orbeFragmento(){
        Random r = new Random();
        int probabilidad = r.nextInt(100)+1;
        if(probabilidad==0)
            probabilidad++;
        if(probabilidad>0 && probabilidad<=5){
            while(true){
                int indice = r.nextInt(listaAspectoFragmento.getSize());
                if(listaAspectoFragmento.buscarAspecto(indice).getTipo().equalsIgnoreCase("Mitica"))
                    return listaAspectoFragmento.buscarAspecto(indice);
            }
        }
        if(probabilidad>5 && probabilidad<=20){
            while(true){
                int indice = r.nextInt(listaAspectoFragmento.getSize());
                if(listaAspectoFragmento.buscarAspecto(indice).getTipo().equalsIgnoreCase("Legendaria"))
                    return listaAspectoFragmento.buscarAspecto(indice);
            }
        }
        if(probabilidad>20 && probabilidad <= 50) {
            while (true){
                int indice = r.nextInt(listaAspectoFragmento.getSize());
                if(listaAspectoFragmento.buscarAspecto(indice).getTipo().equalsIgnoreCase("Epica")) {
                    return listaAspectoFragmento.buscarAspecto(indice);
                }
            }
        }
        if(probabilidad>50 && probabilidad<=100){
            while(true){
                int indice = r.nextInt(listaAspectoFragmento.getSize());
                if(listaAspectoFragmento.buscarAspecto(indice).getTipo().equalsIgnoreCase("Normal"))
                    return listaAspectoFragmento.buscarAspecto(indice);
            }
        }
        return null;
    }
    
    public Orbe orbeOrbe(){
        Orbe o = new Orbe(nombre);
        return o;
    }
    
    public int abrirOrbe(){
        Random r = new Random();
        int valor = r.nextInt(100)+1;
        return valor;
    }
    
}