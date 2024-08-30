package services;

import models.Empleado;

import java.util.Scanner;

public class EmpleadoServices {
    private static Scanner sc;
    private static Empleado empleado;
    private Empleado[] listaEmpleado;

    public EmpleadoServices() {
        sc = new Scanner(System.in);
        crearListaEmpleado();
        menu();
    }

    public void menu() {
        char opcion;
        do {
            System.out.println("***Menu***");
            System.out.println("1 - crear empleado");
            System.out.println("2 - modificar empledo");
            System.out.println("3 - buscar empleado");
            System.out.println("4 - listar empleado");
            System.out.println("s - salir");
            System.out.println("ingrese una opcion del menu");
            opcion = sc.next().charAt(0);

            switch (opcion) {
                case '1' -> crearEmpleado();
                case '2' -> modificarEmpleado();
                case '3' -> buscarEmpleado();
                case '4' -> listarEmpleado();
                default -> {
                    opcion = 's';
                    System.out.println("hasta mañana");
                }
            }

        } while (opcion != 's');
    }

    private void listarEmpleado() {
        System.out.println("LISTA DE EMPLEADOS");
        System.out.println(listaEmpleado);

    }

    private void buscarEmpleado() {

    }

    private void modificarEmpleado() {

    }

    private void crearEmpleado() {
        System.out.println("CREAR EMPLEADOS");
        for (int i = 0; i < listaEmpleado.length; i++) {
            System.out.println("---Empleado nuevo---");
            System.out.println("ingrese el codigo");
            String codigo = sc.next();
            System.out.println("ingrese el non¿mbre del empleado");
            String empleado = sc.next();
            System.out.println("ingrese las horas trabajadas");
            int horasTrabajadas = sc.nextInt();
            System.out.println("ingrese el valor de la hora");
            double valor = sc.nextDouble();


            listaEmpleado[i] = new Empleado(codigo, empleado, horasTrabajadas, valor , horasTrabajadas * valor);
        }
    }

    private void crearListaEmpleado() {
        System.out.println("ingrese la cantidad de empleados de la empresa X");
        listaEmpleado = new Empleado[sc.nextInt()];
    }
}
