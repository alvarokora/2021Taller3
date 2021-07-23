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
public class ListaAspecto {
    
    private NodoAspecto last;
    private int size;
    
    public ListaAspecto(){
        last = null;
        size = 0;
    }

    public NodoAspecto getLast() {
        return last;
    }

    public void setLast(NodoAspecto last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        if(last==null)
            return true;
        return false;
    }
    
    public void addAspecto(Aspecto aspecto){
        NodoAspecto nodo = new NodoAspecto(aspecto);
        if(isEmpty()==true){
            last = nodo;
            last.setNext(last);
            last.setPrev(last);
        }else{
            nodo.setNext(last);
            last.getPrev().setNext(nodo);
            nodo.setPrev(last.getPrev());
            last.setPrev(nodo);
        }
        last = nodo;
        size++;
    }
    
    public Aspecto buscarAspecto(int i){
        NodoAspecto aux = last;
        int cont = 0;
        if(aux != null){
            while(aux.getNext() != last){
                if(cont==i && i>=0){
                    return aux.getAspecto();
                }
                aux.getNext();
                cont++;
            }
        }
        return null;
    }
    
}