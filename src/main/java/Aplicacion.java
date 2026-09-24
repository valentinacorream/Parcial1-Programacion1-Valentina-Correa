import java.util.List;
import java.util.Scanner;

public class Aplicacion {
    static void main() {

        Scanner sc= new Scanner(System.in);

        Supermercado supermercado= new Supermercado("MarketPlus", "Carrera 19", 31823456);

        int opcion;
        do {
            System.out.println("====== Menú MarketPlus ======");
            System.out.println("1. Agregar Cliente.");
            System.out.println("2. Actualizar Cliente.");
            System.out.println("3. Ver Historial de Compras de un Cliente.");
            System.out.println("4. Eliminar Cliente.");
            System.out.println("5. Mostrar Clientes.");

            System.out.println("------------------------------------------------");
            System.out.println("6. Agregar Producto.");
            System.out.println("7. Actuallizar Producto.");
            System.out.println("8. Eliminar Producto.");
            System.out.println("9. Mostrar Productos");

            System.out.println("------------------------------------------------");
            System.out.println("10. Realizar Compra.");
            System.out.println("11. Ver Historial General de Compras.");

            System.out.println("------------------------------------------------");
            System.out.println("0. Salir.");

            opcion= sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("\n----- Agregar Cliente -----");
                    System.out.println("Nombre: ");
                    String nombre= sc.nextLine();

                    System.out.println("Documento: ");
                    int documento= sc.nextInt();

                    System.out.println("Teléfono: ");
                    int telefono= sc.nextInt();

                    System.out.println("Correo: ");
                    String correo= sc.nextLine();

                    Cliente cliente= new Cliente(nombre, documento, telefono, correo);
                    if (supermercado.agregarCliente(cliente)){
                        System.out.println("El cliente ha sido agregado correctamente: ");
                    }else {
                        System.out.println("El cliente ya existe.");
                    }

                    break;

                case 2:
                    System.out.println("\n----- Actualizar Cliente -----");
                    System.out.println("Documento: ");
                    int documentoActualizar= sc.nextInt();

                    System.out.println("Nuevo Nombre: ");
                    String nuevoNombre= sc.nextLine();

                    System.out.println("Nuevo Teléfono: ");
                    int nuevoTelefono= sc.nextInt();

                    System.out.println("Nuevo Correo: ");
                    String nuevoCorreo= sc.nextLine();

                    Cliente clienteActualizado= new Cliente(nuevoNombre, documentoActualizar, nuevoTelefono, nuevoCorreo);

                    if (supermercado.actualizarCliente(documentoActualizar, clienteActualizado)){
                        System.out.println("Cliente actualizado correctamente. ");
                    } else {
                        System.out.println("El cliente ya existe.");
                    }

                    break;

                case 3:
                    System.out.println("\n----- Historial de Compras de un Cliente -----");
                    System.out.println("Documento del cliente: ");
                    int documentoHistorial= sc.nextInt();

                    sc.nextLine();

                    List<Compra> historial= supermercado.mostrarHistorialCliente(documentoHistorial);
                    if (!historial.isEmpty()){
                        System.out.println(historial);
                    } else {
                        System.out.println("El cliente no tiene compras registradas.");
                    }
                    break;

                case 4:
                    System.out.println("\n----- Eliminar Cliente -----");
                    System.out.println("Documento del cliente a eliminar: ");
                    int documentoEliminado= sc.nextInt();

                    if (supermercado.eliminarCliente(documentoEliminado)){
                        System.out.println("El cliente ha sido eliminado correctamente.");
                    }else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n----- Lista de Clientes -----");
                    for (Cliente clienteLista: supermercado.getListaClientes()){
                        System.out.println(clienteLista);
                    }
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;

                case 0:
                    System.out.println("Adiós.....");
                    break;

                default:
                    System.out.println("Opción no válida... Intente de nuevo.");
            }
        } while (opcion!=0);

        sc.close();
    }
}
