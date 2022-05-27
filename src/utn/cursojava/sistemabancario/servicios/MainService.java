package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.exceptions.MenorACeroException;
import utn.cursojava.sistemabancario.modelo.Banco;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainService {
    static ClienteServiceImpl clienteService = new ClienteServiceImpl();
    static CuentaServiceImpl cuentaService = new CuentaServiceImpl();
    static SucursalServiceImpl sucursalService = new SucursalServiceImpl();
    static BancoServiceImpl bancoService = new BancoServiceImpl();
    static Banco banco;
    static Sucursal sucursal;

    public static void optionSelector() {
        Scanner input = new Scanner(System.in);

        //Instancio una lista de bancos, y verifico:
        //      Si existe un banco, se usa.
        //      De lo contrario, se genera uno.
        List<Banco> bancos = bancoService.listarBancos();


        if(bancos.size() == 0) {
            System.out.println("\nActualmente no existe ningun banco en el sistema." +
                    "\nPara continuar, debe crear un nuevo banco y una sucursal");

            // Al agregar un banco se obtiene su ID, y luego se setea
            // al banco que está como atributo de esta clase
            Integer bancoId = bancoService.addBanco();
            banco = bancoService.findById(bancoId);
            Integer sucursalId = sucursalService.addSucursal(bancoId);
            sucursal = sucursalService.findById(sucursalId);
        } else {
            banco = bancos.get(0);
            System.out.println("\nBIENVENIDO AL BANCO " + banco.getNombre().toUpperCase());
            List<Sucursal> sucursales = sucursalService.listarSucursales();

            if(sucursales.size() == 0) {
                System.out.println("\nActualmente no existe ninguna sucursal en el sistema." +
                        "\nEsta siendo redirigido a 'Crear sucursal'...");
                Integer sucursalId = sucursalService.addSucursal(banco.getId());
                sucursal = sucursalService.findById(sucursalId);
            } else if(sucursales.size() == 1){
                sucursal = sucursales.get(0);
                System.out.println("SUCURSAL " + sucursal.getNombre());
            } else {
                System.out.println("Seleccione una sucursal para operar");
                imprimirSucursales(sucursales);
                int opcion = input.nextInt();
                sucursal = sucursales.get(opcion - 1);
            }
        }

        boolean salir = false;

        do {
            try {
            System.out.print("\n**** BANCO ****" +
                    "\n1) Agregar Cliente" +
                    "\n2) Agregar cuenta a cliente" +
                    "\n3) Listar clientes" +
                    "\n4) Listar Clientes de una sucursal" +
                    "\n5) Ingresar como cliente" +
                    "\n6) Agregar sucursal" +
                    "\n7) Eliminar sucursal" +
                    "\n8) SALIR" +
                    "\n\nOPCION: ");
            Integer opcion = input.nextInt();
            if(opcion <= 0) {
                throw new MenorACeroException();
            }
            if(opcion == 8) {
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
        switch (opcion) {
            case 1:
                clienteService.addCliente(sucursal.getId());
                break;
            case 2:
                break;
            case 3:
                imprimirClientes(clienteService.findClientes());
                break;
            case 4:
                //TODO: solicitar nro de sucursal al usuario
                List<Cliente> c2 = clienteService.listarClientesPorSucursal(3);
                for(Cliente c : c2) {
                    System.out.println(c.getNombreApellido());
                }
                break;
            case 5:
                //TODO: aqui debe ingresar como usuario | Completar metodo
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
            case 6:
                sucursalService.addSucursal(banco.getId());
                break;
            case 7:
                sucursalService.deleteSucursal(6);
                break;
            default:
                System.out.println("Opcion invalida!");
        }
    }

    static void imprimirClientes(List<Cliente> clientes) {
        for(Cliente c : clientes) {
            System.out.println(c);
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
