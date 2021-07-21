/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.*;

/**
 *
 * @author defGrupo()
 */
public class NodoAspecto {
    
    private Aspecto aspecto;
    private NodoAspecto next;
    private NodoAspecto prev;
    
    public NodoAspecto(Aspecto aspecto){
        this.aspecto=aspecto;
        next = prev = null;
    }

    public Aspecto getAspecto() {
        return aspecto;
    }

    public void setAspecto(Aspecto aspecto) {
        this.aspecto = aspecto;
    }

    public NodoAspecto getNext() {
        return next;
    }

    public void setNext(NodoAspecto next) {
        this.next = next;
    }

    public NodoAspecto getPrev() {
        return prev;
    }

    public void setPrev(NodoAspecto prev) {
        this.prev = prev;
    }
    
}