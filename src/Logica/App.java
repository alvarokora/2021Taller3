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
    
    public static boolean revisarNombreUsuario(List <Persona> listaPersona, String nombre){
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombre))
                return true;
        }
        return false;
    }
    
    public static boolean revisarContraseñaUsuario(List <Persona> listaPersona, String nombre, String contraseña){
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombre)){
                if(listaPersona.get(i).getContraseña().equalsIgnoreCase(contraseña))
                    return true;
            }
        }
        return false;
    }
            
    public static boolean revisarTipoUsuario(List <Persona> listaPersona, String nombre){
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombre)){
                if(listaPersona.get(i) instanceof Jugador)
                    return true;
                if(listaPersona.get(i) instanceof Administrador)
                    return false;
            }
        }
        return false;
    }
    
    public static boolean lectura(SistemaTaller3 sistema, List <Campeon> listaCampeon, List <Persona> listaPersona, List <Orbe> listaOrbe){
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
                    listaPersona.add(new Jugador(nombre,contraseña,saldo));
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
                if(tipo.equalsIgnoreCase("Admin")){
                    sistema.ingresarAdministrador(nombre, contraseña);
                    listaPersona.add(new Administrador(nombre,contraseña));
                }
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
                String nombre = s1.next();
                sistema.ingresarOrbe(nombre);
                listaOrbe.add(new Orbe(nombre));
            }
            s.close();
            
            return true;
        }catch(FileNotFoundException e){
            return false;
        }
    }
    
    public static boolean revisarNombreOrbe(List <Orbe> listaOrbe, String nombreOrbe){
        for(int i=0;i<listaOrbe.size();i++){
            if(listaOrbe.get(i).getNombre().equalsIgnoreCase(nombreOrbe))
                return true;
        }
        return false;
    }
    
    public static boolean revisarSaldoUsuario(List <Persona> listaPersona, String nombre){
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i) instanceof Jugador){
                if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombre)){
                    Jugador j = (Jugador) listaPersona.get(i);
                    if(j.getSaldo()-1350 < 0){
                        return true;
                    }else
                        return false;
                }
            }
        }
        return false;
    }
    
    public static boolean revisarNombreFragmentoAspecto(List <Persona> listaPersona, String nombreUsuario, String nombreFragmento){
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i) instanceof Jugador){
                if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombreUsuario)){
                    Jugador jugador = (Jugador) listaPersona.get(i);
                    for(int j=0;j<jugador.getListaFragmentoAspecto().getSize();j++){
                        if(jugador.getListaFragmentoAspecto().buscarAspecto(j).getNombre().equalsIgnoreCase(nombreFragmento))
                            return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    public static boolean revisarNombreOrbeUsuario(List <Persona> listaPersona, String nombreUsuario, String nombreOrbe){
        for(int i=0;i<listaPersona.size();i++){
            if(listaPersona.get(i) instanceof Jugador){
                if(listaPersona.get(i).getNombre().equalsIgnoreCase(nombreUsuario)){
                    Jugador jugador = (Jugador) listaPersona.get(i);
                    for(int j=0;j<jugador.getListaOrbe().size();j++){
                        if(jugador.getListaOrbe().get(j).getNombre().equalsIgnoreCase(nombreOrbe))
                            return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    public static void salida(List <Persona> listaPersona, ListaAspecto listaAspecto, List <Balance> listaVenta, List <Orbe> listaOrbe, List <Campeon> listaCampeon){
        try{
            
            FileWriter arch = new FileWriter("personas.txt");
            PrintWriter reg = new PrintWriter(arch);
            for(int i=0;i<listaPersona.size();i++){
                if(listaPersona.get(i) instanceof Jugador){
                    Jugador jugador = (Jugador) listaPersona.get(i);
                    reg.print(jugador.getNombre()+","+jugador.getContraseña()+",player,"+(int)jugador.getSaldo());
                    for(int j=0;j<jugador.getListaOrbe().size();j++){
                        reg.print(","+jugador.getListaOrbe().get(j).getNombre());
                    }
                    for(int j=0;j<jugador.getListaCampeon().size();j++){
                        reg.print(","+jugador.getListaCampeon().get(j).getNombre());
                        for(int n=0;n<jugador.getListaCampeon().get(j).getListaAspecto().getSize();n++){
                            reg.print(","+jugador.getListaCampeon().get(j).getListaAspecto().buscarAspecto(n).getNombre());
                        }
                    }
                    reg.print("\n");
                }
                if(listaPersona.get(i) instanceof Administrador){
                    reg.print(listaPersona.get(i).getNombre()+","+listaPersona.get(i).getContraseña()+",Admin\n");
                }
            }
            arch.close();
            
            arch = new FileWriter("aspectosPersonajes.txt");
            reg = new PrintWriter(arch);
            for(int i=0;i<listaCampeon.size();i++){
                reg.print(listaCampeon.get(i).getNombre()+","+listaCampeon.get(i).getLinea());
                for(int j=0;j<listaCampeon.get(i).getListaAspecto().getSize();j++){
                    reg.print(","+listaCampeon.get(i).getListaAspecto().buscarAspecto(j).getNombre()+","+listaCampeon.get(i).getListaAspecto().buscarAspecto(j).getTipo());
                }
                reg.print("\n");
            }
            arch.close();
            
            arch = new FileWriter("balances.txt");
            reg = new PrintWriter(arch);
            for(int i=0;i<listaVenta.size();i++){
                reg.print(listaVenta.get(i).getFecha()+","+(int)listaVenta.get(i).getVenta()+"\n");
            }
            arch.close();
            
            arch = new FileWriter("orbes.txt");
            reg = new PrintWriter(arch);
            for(int i=0;i<listaOrbe.size();i++){
                reg.print(listaOrbe.get(i).getNombre()+"\n");
            }
            arch.close();
            
        }catch(IOException ex){
        }
    }
    
    public static void menu(SistemaTaller3 sistema, List <Campeon> listaCampeon, Scanner s, List <Persona> listaPersona, List <Orbe> listaOrbe, ListaAspecto listaAspecto, List <Balance> listaVenta){
        System.out.println("----------\nBienvenido\n----------");
        if(lectura(sistema,listaCampeon,listaPersona,listaOrbe)){
            System.out.print("Ingrese fecha(dd/mm/aaaa): ");
            String fecha = s.next();
            System.out.print("Ingrese nombre de usuario: ");
            String nombre = s.next();
            sistema.cerrarSistema(listaPersona, listaAspecto, listaCampeon, listaVenta, listaOrbe);
            while(revisarNombreUsuario(listaPersona,nombre)==false){
                System.out.print("Nombre de usuario ingresado erroneo, ingrese nuevamente: ");
                nombre = s.next();
            }
            System.out.print("Ingrese contraseña del usuario: ");
            String contraseña = s.next();
            while(revisarContraseñaUsuario(listaPersona,nombre,contraseña)==false){
                System.out.print("Contraseña ingresada erronea, ingrese nuevamente: ");
                contraseña = s.next();
            }
            while(true){
                if(revisarTipoUsuario(listaPersona,nombre)){
                    System.out.print("1)Informacion de usuario\n2)Añadir saldo\n3)Comprar orbe\n4)Re-Roll\n5)Abrir orbe\n6)Cerrar sesion\n7)Cerrar sistema\nIngrese opcion: ");
                    String opcion = s.next();
                    while(!opcion.equalsIgnoreCase("6") && !opcion.equalsIgnoreCase("7")){
                        while(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2") && !opcion.equalsIgnoreCase("3") && !opcion.equalsIgnoreCase("4") && !opcion.equalsIgnoreCase("5")){
                            System.out.print("La opcion ingresada es erronea, ingrese nuevamente: ");
                            opcion = s.next();
                        }
                        if(opcion.equalsIgnoreCase("1")){
                            System.out.println(sistema.obtenerInformacion(nombre));
                        }
                        if(opcion.equalsIgnoreCase("2")){
                            System.out.print("Ingrese monto a depositar: ");
                            double monto = s.nextDouble();
                            while(monto<=0){
                                System.out.print("Monto ingresado erroneo, ingrese nuevamente: ");
                                monto = s.nextDouble();
                            }
                            System.out.println(sistema.agregarSaldo(nombre, monto));
                            sistema.cerrarSistema(listaPersona, listaAspecto, listaCampeon, listaVenta, listaOrbe);
                        }
                        if(opcion.equalsIgnoreCase("3")){
                            System.out.println(sistema.obtenerOrbe());
                            System.out.print("Ingrese nombre del orbe: ");
                            String nombreOrbe = s.next();
                            while(revisarNombreOrbe(listaOrbe,nombreOrbe)==false){
                                System.out.print("Nombre ingresado erroneo, ingrese nuevamente: ");
                                nombreOrbe = s.next();
                            }
                            if(revisarSaldoUsuario(listaPersona,nombre)){
                                System.out.print("Tiene suficiente saldo, desea abrir el orbe(si/no): ");
                                String respuesta = s.next();
                                while(!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")){
                                    System.out.print("Opcion ingresada erronea, ingrese nuevamente(si/no): ");
                                    respuesta = s.next();
                                }
                                System.out.println(sistema.comprarOrbe(nombreOrbe,respuesta,nombre));
                                sistema.cerrarSistema(listaPersona, listaAspecto, listaCampeon, listaVenta, listaOrbe);
                            }else
                                System.out.println("El cliente no tiene suficiente saldo para comprar el orbe");
                        }
                        if(opcion.equalsIgnoreCase("4")){
                            System.out.println(sistema.obtenerAspectoUsuario(nombre));
                            System.out.print("Ingrese nombre del aspecto 1: ");
                            String nombreAspecto1 = s.next();
                            while(revisarNombreFragmentoAspecto(listaPersona,nombre,nombreAspecto1)==false){
                                System.out.print("Nombre ingresado erroneo, ingrese nuevamente: ");
                                nombreAspecto1 = s.next();
                            }
                            System.out.print("Ingrese nombre del aspecto 2: ");
                            String nombreAspecto2 = s.next();
                            while(revisarNombreFragmentoAspecto(listaPersona,nombre,nombreAspecto2)==false){
                                System.out.print("Nombre ingresado erroneo, ingrese nuevamente: ");
                                nombreAspecto2 = s.next();
                            }
                            System.out.print("Ingrese nombre del aspecto 3: ");
                            String nombreAspecto3 = s.next();
                            while(revisarNombreFragmentoAspecto(listaPersona,nombre,nombreAspecto3)==false){
                                System.out.print("Nombre ingresado erroneo, ingrese nuevamente: ");
                                nombreAspecto3 = s.next();
                            }
                            System.out.println(sistema.reRoll(nombreAspecto1, nombreAspecto2, nombreAspecto3, nombre));
                            sistema.cerrarSistema(listaPersona, listaAspecto, listaCampeon, listaVenta, listaOrbe);
                        }
                        if(opcion.equalsIgnoreCase("5")){
                            System.out.println(sistema.obtenerOrbeUsuario(nombre));
                            System.out.print("Ingrese nombre del orbe a abrir: ");
                            String nombreOrbe = s.next();
                            while(revisarNombreOrbeUsuario(listaPersona,nombre,nombreOrbe)==false){
                                System.out.print("Nombre ingresado erroneo, ingrese nuevamente: ");
                                nombreOrbe = s.next();
                            }
                            System.out.print("En el caso hipotetico de que salga un orbe lo desea almacenar o abrir (si/no): ");
                            String respuesta = s.next();
                            while(!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")){
                                System.out.println("Respuesta ingresada erronea, ingrese nuevamente: ");
                                respuesta = s.next();
                            }
                            System.out.println(sistema.abrirOrbe(nombreOrbe, nombre, respuesta));
                            sistema.cerrarSistema(listaPersona, listaAspecto, listaCampeon, listaVenta, listaOrbe);
                        }
                        System.out.print("1)Informacion de usuario\n2)Añadir saldo\n3)Comprar orbe\n4)Re-Roll\n5)Abrir orbe\n6)Cerrar sesion\n7)Cerrar sistema\nIngrese opcion: ");
                        opcion = s.next();
                    }
                    if(opcion.equalsIgnoreCase("7"))
                        break;
                }else{
                    System.out.print("1)Mes mas ventas\n2)Informacion de jugadores\n3)Mejor aspecto\n4)Cerrar sesion\n5)Cerrar sistema\nIngrese opcion: ");
                    String opcion = s.next();
                    while(!opcion.equalsIgnoreCase("4") && !opcion.equalsIgnoreCase("5")){
                        while(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2") && !opcion.equalsIgnoreCase("3")){
                            System.out.print("Opcion ingresada erronea, ingrese nuevamente: ");
                            opcion = s.next();
                        }
                        if(opcion.equalsIgnoreCase("1")){
                            System.out.println(sistema.obtenerMesMasVentas());
                        }
                        if(opcion.equalsIgnoreCase("2")){
                            System.out.println(sistema.obtenerInformacionUsuario());
                        }
                        if(opcion.equalsIgnoreCase("3")){
                            System.out.println(sistema.obtenerMejorAspecto());
                        }
                        System.out.print("1)Mes mas ventas\n2)Informacion de jugadores\n3)Mejor aspecto\n4)Cerrar sesion\n5)Cerrar sistema\nIngrese opcion: ");
                        opcion = s.next();
                    }
                    if(opcion.equalsIgnoreCase("5"))
                        break;
                }
                System.out.println("---------------\nCerrando sesion\n---------------");
                System.out.print("Ingrese fecha(dd/mm/aaaa): ");
                fecha = s.next();
                System.out.print("Ingrese nombre de usuario: ");
                nombre = s.next();
                while(revisarNombreUsuario(listaPersona,nombre)==false){
                    System.out.print("Nombre de usuario ingresado erroneo, ingrese nuevamente: ");
                    nombre = s.next();
                }
                System.out.print("Ingrese contraseña del usuario: ");
                contraseña = s.next();
                while(revisarContraseñaUsuario(listaPersona,nombre,contraseña)==false){
                    System.out.print("Contraseña ingresada erronea, ingrese nuevamente: ");
                    contraseña = s.next();
                }
            }
        }else{
            System.out.println("Uno de los archivos no existe");
        }
        sistema.cerrarSistema(listaPersona, listaAspecto, listaCampeon, listaVenta, listaOrbe);
        salida(listaPersona,listaAspecto,listaVenta,listaOrbe,listaCampeon);
        System.out.println("-----------------------------\nGracias por ocupar el sistema\n-----------------------------");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaTaller3 sistema = new SistemaTaller3Impl();
        List <Campeon> listaCampeon = new LinkedList();
        Scanner s = new Scanner(System.in);
        List <Persona> listaPersona = new ArrayList();
        List <Orbe> listaOrbe = new LinkedList();
        ListaAspecto listaAspecto = new ListaAspecto();
        List <Balance> listaBalance = new LinkedList();
        menu(sistema,listaCampeon,s,listaPersona,listaOrbe,listaAspecto,listaBalance);
    }
    
}