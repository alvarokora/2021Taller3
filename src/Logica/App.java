/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author defGrupo()
 */
public class App {
    
    public static boolean revisarCampeon(List <Campeon> listaCampeon, String nombre){
        for(int i=0;i<listaCampeon.size();i++){
            if(listaCampeon.get(i).getNombre().equalsIgnoreCase(nombre))
                return true;
        }
        return false;
    }
    
    public static boolean lectura(SistemaTaller3 sistema, List <Campeon> listaCampeon){
        try{
            
            File arch = new File("aspectosPersonajes.txt");
            Scanner s = new Scanner(arch);
            while(s.hasNextLine()){
                String linea = s.nextLine();
                Scanner s1 = new Scanner(linea);
                s1.useDelimiter(",");
                String[] particiones = linea.split(",");
                String nombre = s1.next();
                String carril = s1.next();
                sistema.ingresarCampeon(nombre, carril);
                listaCampeon.add(new Campeon(nombre,carril));
                for(int i=2;i<particiones.length;i++){
                    String nombreAspecto = particiones[i];
                    i++;
                    String tipo = particiones[i];
                    sistema.ingresarAspecto(nombre, tipo);
                    sistema.asociarSkinCampeon(nombre, nombreAspecto);
                }
            }
            s.close();
            
            arch = new File("personas.txt");
            s = new Scanner(arch);
            while(s.hasNextLine()){
                String linea = s.nextLine();
                Scanner s1 = new Scanner(linea);
                s1.useDelimiter(",");
                String[] particiones = linea.split(",");
                String nombre = s1.next();
                String contraseña = s1.next();
                String tipo = s1.next();
                String nombreCampeon = "";
                if(tipo.equalsIgnoreCase("player")){
                    double saldo = s.nextDouble();
                    sistema.ingresarJugador(nombre, contraseña, saldo);
                    for(int i=4;i<particiones.length;i++){
                        if(particiones[i].split(" ")[0].equalsIgnoreCase("Orbe"))
                            sistema.asociarOrbeJugador(nombre, particiones[i]);
                        else{
                            if(revisarCampeon(listaCampeon,particiones[i])){
                                sistema.asociarCampeonJugador(nombre, particiones[i]);
                                nombreCampeon = particiones[i];
                            }else{
                                sistema.asociarSkinJugador(nombre, nombreCampeon, particiones[i]);
                            }
                        }
                    }
                }
                if(tipo.equalsIgnoreCase("Admin"))
                    sistema.ingresarAdministrador(nombre, contraseña);
            }
            s.close();
            
            arch = new File("balances.txt");
            s = new Scanner(arch);
            while(s.hasNextLine()){
                String linea = s.nextLine();
                Scanner s1 = new Scanner(linea);
                s1.useDelimiter(",");
                String fecha = s1.next();
                double venta = s1.nextDouble();
                sistema.ingresarBalanceMensual(fecha, venta);
            }
            s.close();
            
            arch = new File("orbes.txt");
            s = new Scanner(arch);
            while(s.hasNextLine()){
                String linea = s.nextLine();
                Scanner s1 = new Scanner(linea);
                String[] particiones = linea.split(",");
                for(int i=0;i<particiones.length;i++){
                    String nombre = particiones[i];
                    sistema.ingresarOrbe(nombre);
                }
            }
            s.close();
            
            return true;
        }catch(FileNotFoundException e){
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}