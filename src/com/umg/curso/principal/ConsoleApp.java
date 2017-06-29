package com.umg.curso.principal;

import com.umg.curso.clases.Deporte;
import com.umg.curso.clases.Deportista;
import com.umg.curso.clases.Especialista;
import com.umg.curso.clases.Ministerio;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

/**
 * Created by IT DASA on 28/06/2017.
 */
public class ConsoleApp {

    public static void main(String[] args) throws Exception {

        Ministerio ministerio = null;
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        boolean inicializada = false;
        int opcion;

        while (!salir) {
            System.out.println("Sistema del Ministerio de Deportes\n");

            System.out.println("1. Ingresar cantidad de deportes para el Ministerio");
            System.out.println("2. Datos de Especialista asignado");
            System.out.println("3. Adicionar deportes");
            System.out.println("4. Listar deportes con balón");
            System.out.println("5. Adicionar deportista");
            System.out.println("6. Promedio de edades de los deportistas\n");
            System.out.println("0. Salir\n");

            try {
                System.out.println("Seleccione una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Cuantos deportes posee el Ministerio");
                        ministerio = new Ministerio(sn.nextInt());
                        inicializada=true;
                        break;
                    case 2:
                        System.out.println("Nombre:");
                        Especialista especialista = new Especialista();
                        especialista.setNombre(sn.next());
                        System.out.println("Años de experiencia:");
                        especialista.setAnnosExp(sn.nextInt());
                        break;
                    case 3:
                        System.out.println("Nombre del deporte:");
                        Deporte deporte = new Deporte(sn.next());
                        System.out.println("Con balón? (S/N):");
                        if (sn.next().equalsIgnoreCase("S"))
                            deporte.setConBalon(true);
                        ministerio.adicionarDeporte(deporte);

                        break;
                    case 4:
                        Deporte[] listado = ministerio.getListado();
                        for (int i = 0; i <ministerio.getCantReal() ; i++) {
                            if(listado[i].isConBalon())
                            System.out.printf("Deporte #"+(i+1)+ ": "+listado[i].getNombre()+"\n");
                        }
                        System.out.println("--------------");
                        break;
                    case 5:
                        if (inicializada == true) {
                            System.out.println("Ingrese el nombre: ");
                            String Nombre=sn.next();
                            System.out.println("Ingrese la edad: ");
                            int Edad=sn.nextInt();
                            Deportista deportistas = new Deportista(Nombre,Edad);
                            ministerio.adicionarDeportista(deportistas);
                        } else {
                            System.out.println("*****");
                            System.out.println("Error, por favor inice con la opcion 1");
                            System.out.println("*****\n");
                        }
                        break;
                    case 6:
                        if (inicializada == true) {
                            System.out.println("El promedio de las edades de los deportistas es: "+ministerio.promedioEdad()+"\n");
                        } else {
                            System.out.println("*****");
                            System.out.println("Error, por favor inice con la opcion 1");
                            System.out.println("*****\n");
                        }
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}