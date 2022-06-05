package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.exceptions.MenorACeroException;
import utn.cursojava.sistemabancario.modelo.Banco;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainService {
    static ClienteServiceImpl clienteService = new ClienteServiceImpl();
    static CuentaServiceImpl cuentaService = new CuentaServiceImpl();
    static SucursalServiceImpl sucursalService = new SucursalServiceImpl();
    static BancoServiceImpl bancoService = new BancoServiceImpl();
    static Banco banco;
    static Sucursal sucursal;
    static List<Sucursal> sucursales;
    public static void optionSelector() {
        Scanner input = new Scanner(System.in);
        List<Banco> bancos = bancoService.listarBancos();
        boolean salir = false;

        if(bancos.size() == 0) {
            System.out.println("\nActualmente no existe ningun banco en el sistema." +
                    "\nPara continuar, debe crear un nuevo banco y una sucursal");

            // Al agregar un banco se obtiene su ID, y luego se setea
            // al banco que está como atributo de esta clase
            Integer bancoId = bancoService.addBanco();
            banco = bancoService.findById(bancoId);
            Integer sucursalId = sucursalService.addSucursal(bancoId);
            sucursales = sucursalService.listarSucursales();
            sucursal = sucursalService.findById(sucursalId);
        } else {
            banco = bancos.get(0);
            System.out.println("\nBIENVENIDO AL BANCO " + banco.getNombre().toUpperCase());
            sucursales = sucursalService.listarSucursales();

            if(sucursales.size() == 0) {
                System.out.println("\nActualmente no existe ninguna sucursal en el sistema." +
                        "\nEsta siendo redirigido a 'Crear sucursal'...");
                Integer sucursalId = sucursalService.addSucursal(banco.getId());
                sucursal = sucursalService.findById(sucursalId);
            } else if(sucursales.size() == 1){
                sucursal = sucursales.get(0);
                System.out.println("SUCURSAL " + sucursal.getNombre());
            } else {
                do {
                    try {
                        System.out.println("Seleccione una sucursal para operar");
                        imprimirSucursales(sucursales);
                        System.out.print("OPCION: ");
                        int opcion = input.nextInt();
                        sucursal = sucursales.get(opcion - 1);
                        salir = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Ingrese una opcion dentro del rango correcto");
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una opcion valida");
                        input.next();
                    }
                } while(!salir);
            }
        }

        salir = false;

        do {
            try {
                System.out.print("\n**** BANCO "+ banco.getNombre().toUpperCase() +" ****" +
                        "\n**** SUCURSAL " + sucursal.getNombre().toUpperCase() + " ****" +
                        "\n1) Agregar Cliente" +
                        "\n2) Listar clientes" +
                        "\n3) Listar Clientes de una sucursal" +
                        "\n4) Ingresar como cliente" +
                        "\n5) Agregar sucursal" +
                        "\n6) Eliminar sucursal (EN MANTENIMIENTO)" +
                        "\n7) SALIR" +
                        "\n\nOPCION: ");
                Integer opcion = input.nextInt();
                if(opcion <= 0) {
                    throw new MenorACeroException();
                } else if(opcion == 7) {
                    System.out.println("SALIENDO...");
                    salir = true;
                } else {
                    menu(opcion);
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar opciones numericas!");
                input.next();
            } catch (MenorACeroException e) {
                System.out.println(e.getMessage());
            }
        } while(!salir);
    }

    static void menu(Integer opcion) {
        Scanner input = new Scanner(System.in);
        Cliente cliente;
        boolean salir = false;
        switch (opcion) {
            case 1:
                clienteService.addCliente(sucursal.getId());
                break;
            case 2:
                System.out.println("\n*** LISTADO DE CLIENTES ***");
                imprimirClientes(clienteService.findClientes());
                break;
            case 3:
                int idSucursalActual = sucursal.getId();
                do {
                    try {
                        System.out.println("*** LISTAR CLIENTES POR SUCURSAL ***" +
                                "\nSeleccione una sucursal");
                        imprimirSucursales(sucursales);
                        System.out.print("OPCION: ");
                        opcion = input.nextInt();
                        salir = true;
                        sucursal = sucursales.get(opcion - 1);
                        System.out.println("\n*** LISTADO DE CLIENTES ***" +
                                "\n*** SUCURSAL " + sucursal.getNombre().toUpperCase() + " ***");
                        imprimirClientes(clienteService.listarClientesPorSucursal(sucursal.getId()));
                        sucursal = sucursalService.findById(idSucursalActual);
                    } catch (InputMismatchException e) {
                        input.next();
                        System.out.println("Ingrese el tipo de dato correcto");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Ingrese una opcion dentro del rango correcto");
                    }
                } while (!salir);

                break;
            case 4:
                System.out.print("Ingrese su cuil: ");
                String cuil = input.next();
                cliente = clienteService.findClienteByCuil(cuil);
                if(cliente.getCuil() == null) {
                    System.out.println("El cliente solicitado no existe. Redirigiendo al menu principal...");
                } else {
                    System.out.println("\nINGRESO EXITOSO");
                    clienteService.dashboardCliente(cliente);
                }
                break;
            case 5:
                sucursalService.addSucursal(banco.getId());
                sucursales.clear();
                sucursales = sucursalService.listarSucursales();
                break;
            case 6:
                //TODO: completar
                break;
            default:
                System.out.println("Opcion invalida!");
        }
    }

    static void imprimirClientes(List<Cliente> clientes) {

        if(clientes.size() == 0) {
            System.out.println("No hay ningun cliente registrado hasta el momento");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    static void imprimirSucursales(List<Sucursal> sucursales) {
        int i = 1;
            for(Sucursal s : sucursales) {
                System.out.println(i + ") " + s.getNombre());
                i++;
            }

    }
}
