package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Banco;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;
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
            sucursalService.addSucursal(bancoId);
        } else {
            banco = bancos.get(0);
            List<Sucursal> sucursales = sucursalService.listarSucursales();
            
            if(sucursales.size() == 0) {
                System.out.println("\nActualmente no existe ninguna sucursal en el sistema." +
                        "\nEsta siendo redirigido a 'Crear sucursal'...");
                Integer sucuralId = sucursalService.addSucursal(banco.getId());
                sucursal = sucursalService.findById(sucuralId);
            } else {

            }
        }

        System.out.print("\n**** BANCO ****" +
                "\n1) Agregar Cliente" +
                "\n2) Agregar cuenta a Cliente" +
                "\n3) Listar clientes" +
                "\n4) Listar Clientes de una sucursal" +
                "\n5) Seleccionar cliente" +
                "\n9) Agregar sucursal" +
                "\n10) Eliminar sucursal" +
                "\n\nOPCION: ");
        Integer opcion = input.nextInt();
        menu(opcion);
    }

    static void menu(Integer opcion) {

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
                List<Cliente> c2 = clienteService.listarClientesPorSucursal(3);
                for(Cliente c : c2) {
                    System.out.println(c.getNombreApellido());
                }
                break;
            case 5:
                Cliente c3 = clienteService.findClienteById();
                System.out.println(c3);
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                sucursalService.addSucursal(banco.getId());
                break;
            case 10:
                sucursalService.deleteSucursal(6);
                break;
        }
    }

    static void imprimirClientes(List<Cliente> clientes) {
        for(Cliente c : clientes) {
            System.out.println(c);
        }
    }

    static void imprimirSucursales(List<Sucursal> sucursales) {
        for(Sucursal s : sucursales) {
            System.out.println(s);
        }
    }
}
