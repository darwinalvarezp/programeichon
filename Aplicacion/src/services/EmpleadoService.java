package services;

import models.Direccion;
import models.Empleado;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmpleadoService {
    private Scanner sc;
    private Empleado empleado;
    private DireccionService direccionService;
    private Map<String, Empleado> listaEmpleado; // Cambiado a Map
    private Direccion direccion;

    public EmpleadoService() {
        listaEmpleado = new HashMap<>(); // Inicializado como HashMap
        sc = new Scanner(System.in);
        direccionService = new DireccionService();
    }

    public void menu() {
        char opcion;
        do {
            System.out.println("***Menu***");
            System.out.println("1 - crear empleado");
            System.out.println("2 - modificar empleado");
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
        for (Empleado empleado : listaEmpleado.values()) { // Obtener empleados del Map
            System.out.println("nombre del empleado: " + empleado.getNombreEmpleado() + " sueldo " + empleado.getSueldo());
        }
    }

    private void buscarEmpleado() {
        System.out.println("BUSCAR EMPLEADO");
        System.out.println("Ingrese el codigo del empleado");
        String codigo = sc.next();
        Empleado empleadoEncontrado = listaEmpleado.get(codigo); // Buscar empleado en el Map
        if (empleadoEncontrado != null) {
            System.out.println("El codigo corresponde a: " + empleadoEncontrado.getNombreEmpleado());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void modificarEmpleado() {
        System.out.println("MODIFICAR EMPLEADO");
        System.out.println("Ingrese el codigo del empleado");
        String codigo = sc.next();
        empleado = listaEmpleado.get(codigo); // Buscar empleado en el Map
        if (empleado != null) {
            System.out.println("Ingrese el nuevo nombre");
            empleado.setNombreEmpleado(sc.next());
            System.out.println("Ingrese las horas");
            int horas = sc.nextInt();
            empleado.setHorasTrabajadas(horas);
            System.out.println("Ingrese valor de la hora");
            double valor = sc.nextDouble();
            empleado.setValorHora(valor);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void crearEmpleado() {
        System.out.println("CREAR EMPLEADOS");
        System.out.println("Empleado nuevo");
        String codigo;
        do {
            System.out.println("ingrese el codigo del empleado");
            codigo = sc.next();
        } while (codigoYaExiste(codigo));
        System.out.println("ingrese el nombre del empleado");
        String nombreEmpleado = sc.next();
        System.out.println("ingrese horas Trabajadas");
        int horasTrabajadas = sc.nextInt();
        System.out.println("ingrese el valor de la hora trabajada");
        double valorHora = sc.nextDouble();
        direccion = direccionService.crear();
        listaEmpleado.put(codigo, new Empleado(codigo, nombreEmpleado, horasTrabajadas, valorHora, horasTrabajadas * valorHora, direccion)); // Agregar al Map
    }

    private boolean codigoYaExiste(String codigo) {
        boolean existe = listaEmpleado.containsKey(codigo);
        if (existe) {
            System.out.printf("codigo ya existe ");
        }
        return existe;
    }
}
