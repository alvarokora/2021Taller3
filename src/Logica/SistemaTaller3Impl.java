/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.*;
import java.util.*;

/**
 *
 * @author defGrupo()
 */
public class SistemaTaller3Impl implements SistemaTaller3{
    
    private List <Persona> listaPersona;
    private ListaAspecto listaAspecto;
    private List <Campeon> listaCampeon;
    private List <Orbe> listaOrbe;
    private List <Balance> listaBalance;

    public SistemaTaller3Impl() {
        listaPersona = new ArrayList();
        listaAspecto = new ListaAspecto();
        listaCampeon = new LinkedList();
        listaOrbe = new LinkedList();
        listaBalance = new LinkedList();
    }

    @Override
    public boolean ingresarJugador(String nombre, String contraseña, double saldo) {
        Jugador j = new Jugador(nombre,contraseña,saldo);
        return listaPersona.add(j);
    }

    @Override
    public boolean ingresarCampeon(String nombre, String linea) {
        Campeon c = new Campeon(nombre,linea);
        return listaCampeon.add(c);
    }

    @Override
    public boolean ingresarAspecto(String nombre, String tipo) {
        Aspecto a = new Aspecto(nombre,tipo);
        listaAspecto.addAspecto(a);
        return true;
    }

    @Override
    public boolean ingresarAdministrador(String nombre, String contraseña) {
        Administrador d = new Administrador(nombre,contraseña);
        return listaPersona.add(d);
    }

    @Override
    public boolean asociarCampeonJugador(String nombre, String nombreCampeon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresarOrbe(String nombre) {
        Orbe orbe = new Orbe(nombre);
        orbe.setListaAspectoFragmento(listaAspecto);
        orbe.setListaCampeon(listaCampeon);
        for(int i=0;i<orbe.getListaCampeon().size();i++){
            orbe.getListaCampeon().get(i).setListaAspecto(null);
        }
        return listaOrbe.add(orbe);
    }

    @Override
    public boolean asociarOrbeJugador(String nombre, String nombreOrbe) {
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i) instanceof Jugador){
                if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombre)){
                    Jugador j = (Jugador) listaPersona.get(i);
                    j.getListaOrbe().add(new Orbe(nombreOrbe));
                    listaPersona.add(i, j);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean asociarSkinCampeon(String nombre, String nombreSkin){
        for(int i=0;i<listaCampeon.size();i++){
            if(listaCampeon.get(i).getNombre().equalsIgnoreCase(nombre)){
                for(int j=0;j<listaAspecto.getSize();i++){
                    if(listaAspecto.buscarAspecto(j).getNombre().equalsIgnoreCase(nombreSkin)){
                        listaCampeon.get(i).getListaAspecto().addAspecto(listaAspecto.buscarAspecto(j));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean asociarSkinJugador(String nombre, String nombreCampeon, String nombreSkin){
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i) instanceof Jugador){
                if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombre)){
                    for(int j=0;j<listaCampeon.size();j++){
                        if(listaCampeon.get(j).getNombre().equalsIgnoreCase(nombreCampeon)){
                            for(int n=0;n<listaAspecto.getSize();n++){
                                if(listaAspecto.buscarAspecto(n).getNombre().equalsIgnoreCase(nombreSkin)){
                                    Jugador jugador = (Jugador) listaPersona.get(i);
                                    jugador.getListaFragmentoAspecto().addAspecto(listaAspecto.buscarAspecto(n));
                                    listaPersona.add(i, jugador);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public String obtenerInformacion(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresarBalanceMensual(String fecha, double venta) {
        Balance b = new Balance(fecha,venta);
        return listaBalance.add(b);
    }

    @Override
    public String agregarSaldo(String nombre, double saldoNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerOrbe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String comprarOrbe(String nombre, String respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerAspectoUsuario(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String reRoll(String nombre1, String nombre2, String nombre3, String nombreUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerOrbeUsuario(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String abrirOrbe(String nombreOrbe, String nombreUsuario, String respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerMesMasVentas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerInformacionUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerMejorAspecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarSistema(List<Persona> listaJugadorActualizado, ListaAspecto listaAspectoActualizado, List<Campeon> listaCampeonActualizado, List<Balance> listaVentaActualizado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}