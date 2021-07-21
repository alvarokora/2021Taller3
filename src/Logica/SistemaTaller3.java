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
public interface SistemaTaller3 {
    
    public boolean ingresarJugador(String nombre, String contraseña, double saldo);
    public boolean ingresarCampeon(String nombre, String linea);
    public boolean ingresarAspecto(String nombre, String tipo);
    public boolean ingresarAdministrador(String nombre, String contraseña);
    public boolean asociarCampeonJugador(String nombre, String nombreCampeon);
    public boolean ingresarOrbe(String nombre);
    public boolean asociarOrbeJugador(String nombre, String nombreOrbe);
    public String obtenerInformacion(String nombre);
    public boolean ingresarBalanceMensual(String fecha, double venta);
    public String agregarSaldo(String nombre, double saldoNuevo);
    public String obtenerOrbe();
    public String comprarOrbe(String nombre, String respuesta);
    public String obtenerAspectoUsuario(String nombre);
    public String reRoll(String nombre1, String nombre2, String nombre3, String nombreUsuario);
    public String obtenerOrbeUsuario(String nombre);
    public String abrirOrbe(String nombreOrbe, String nombreUsuario, String respuesta);
    public String obtenerMesMasVentas();
    public String obtenerInformacionUsuario();
    public String obtenerMejorAspecto();
    public void cerrarSistema(List <Persona> listaJugadorActualizado, ListaAspecto listaAspectoActualizado, List <Campeon> listaCampeonActualizado, List <Balance> listaVentaActualizado);
    
}