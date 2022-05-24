package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Banco;
import utn.cursojava.sistemabancario.modelo.Cliente;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainService {
    static ClienteServiceImpl clienteService = new ClienteServiceImpl();
    static CuentaServiceImpl cuentaService = new CuentaServiceImpl();
    static SucursalServiceImpl sucursalService = new SucursalServiceImpl();
    static BancoServiceImpl bancoService = new BancoServiceImpl();

    public static void optionSelector() {
        Scanner input = new Scanner(System.in);
        List<Banco> bancos = bancoService.listarBancos();
        if(bancos.size() == 0) {
            System.out.println("\nActualmente no existe ningun banco en el sistema." +
                    "\nPara continuar, debe crear un nuevo banco");
            bancoService.addBanco();
        }


        System.out.print("\n**** BANCO ****" +
                "\n1) Agregar Cliente" +
                "\n2) Agregar cuenta a Cliente" +
                "\n3) Listar Clientes por sucursal" +
                "\n4) Listar Clientes de una sucursal" +
                "\n5) Extraer dinero" +
                "\n6) Consultar Saldo" +
                "\n7) Realizar Deposito" +
                "\n8) Realizar transferencias" +
                "\n9) Eliminar una sucursal" +
                "\n\nOPCION: ");
        Integer opcion = input.nextInt();
        menu(opcion);
    }

    static void menu(Integer opcion) {

        switch (opcion) {
            case 1:
                clienteService.addCliente();
                break;
            case 2:
                break;
            case 3:
                clienteService.listarClientes();
                List<Cliente> c1 = clienteService.listarClientes();
                for(Cliente c : c1) {
                    System.out.println(c.getNombreApellido());
                }
                break;
            case 4:
                List<Cliente> c2 = clienteService.listarClientesPorSucursal(3);
                for(Cliente c : c2) {
                    System.out.println(c.getNombreApellido());
                }
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                sucursalService.deleteSucursal(6);
                break;
            case 10:
                sucursalService.addSucursal();
                break;
        }
    }
}
