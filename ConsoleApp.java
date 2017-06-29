package com.umg.curso.principal;

import com.umg.curso.clases.Deporte;
import com.umg.curso.clases.Deportista;
import com.umg.curso.clases.Especialista;
import com.umg.curso.clases.Ministerio;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ore on 28/06/17.
 */
public class ConsoleApp {

    public static void main(String[] args) throws Exception {

        Ministerio ministerio = null;
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("1. Ingresar cantidad de deportes para el Ministerio");
            System.out.println("2. Datos de Especialista asignado");
            System.out.println("3. Adicionar deportes");
            System.out.println("4. Listar deportes con balón");
            System.out.println("5. Salir");
            System.out.println("6. Deportista");
            System.out.println("Sistema del Ministerio de Deportes");

            try {
                System.out.println("Seleccione una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Cuantos deportes posee el Ministerio");
                        ministerio = new Ministerio(sn.nextInt());
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
                        if (sn.next().equals("S"))
                            deporte.setConBalon(true);
                        ministerio.adicionarDeporte(deporte);

                        break;
                    case 4:
                        Deporte[] listado = ministerio.getListado();
                        for (int i = 0; i <ministerio.getCantReal() ; i++) {
                            if(listado[i].isConBalon())
                            System.out.printf("Deporte #"+i+1+ ": "+listado[i].getNombre()+"\n");
                        }
                        System.out.println("--------------");
                        break;
                    case 5:
                        salir = true;
                        break;

                    case 6:
                        System.out.println("Ingrese nombre del deportista: ");
                        String Nombre = sn.next();
                        System.out.println("Ingrese edad: ");
                        int Edad = sn.nextInt();
                        Deportista deportista = new Deportista(Nombre,Edad);
                        ministerio.adicioanarDeportista(deportista);

                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}