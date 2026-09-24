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
            System.out.println("7. Consultar Disponibilidad de un Producto.");
            System.out.println("8. Actuallizar Producto.");
            System.out.println("9. Eliminar Producto.");
            System.out.println("10. Mostrar Productos");

            System.out.println("------------------------------------------------");
            System.out.println("11. Realizar Compra.");
            System.out.println("12. Ver Historial General de Compras.");
            System.out.println("13. Consultar ventas por fecha.");

            System.out.println("------------------------------------------------");
            System.out.println("14. Salir.");

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
                    sc.nextLine();

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
                    sc.nextLine();

                    System.out.println("Nuevo Nombre: ");
                    String nuevoNombre= sc.nextLine();

                    System.out.println("Nuevo Teléfono: ");
                    int nuevoTelefono= sc.nextInt();
                    sc.nextLine();

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
                    System.out.println("\n----- Agregar Producto -----");
                    System.out.println("Código: ");
                    String codigo= sc.nextLine();

                    System.out.println("Nombre: ");
                    String nombreProducto= sc.nextLine();

                    System.out.println("Precio Unitario: ");
                    double precio= sc.nextDouble();

                    System.out.println("Cantidad inicial Disponile: ");
                    int cantidadInicial= sc.nextInt();

                    Categoria categoria= seleccionarCategoria(sc);

                    Producto producto= new Producto(codigo, nombreProducto, precio, cantidadInicial, categoria);

                    if (supermercado.agregarProducto(producto)) {
                        System.out.println("El producto se registró correctamente: ");
                    }else {
                        System.out.println("El producto ya existe.");
                    }

                    break;

                case 7:
                    System.out.println("\n----- Disponibilidad de un Producto -----");
                    System.out.println("Código del Producto: ");
                    String codigoConsulta= sc.nextLine();

                    System.out.println("Cantidad que desea consultar: ");
                    int cantidadRequerida= sc.nextInt();
                    sc.nextLine();

                    boolean encontrado = false;

                    for (Producto productoConsulta : supermercado.getListaProductos()) {
                        if (productoConsulta.getCodigo().equalsIgnoreCase(codigoConsulta)) {

                            encontrado = true;

                            if (supermercado.validarDisponibilidad(cantidadRequerida, productoConsulta)) {
                                System.out.println("Hay disponibilidad del producto.");
                            } else {
                                System.out.println("No hay suficiente cantidad disponible.");
                            }

                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("El producto no existe.");
                    }


                    break;

                case 8:
                    System.out.println("\n----- Actualizar Producto -----");
                    System.out.println("Código: ");
                    String codigoActualizar= sc.nextLine();

                    System.out.println("Nuevo nombre: ");
                    String nombreNuevo= sc.nextLine();

                    System.out.println("Nuevo precio: ");
                    double precioNuevo= sc.nextDouble();

                    System.out.println("Nueva Cantidad: ");
                    int cantidadNueva= sc.nextInt();

                    Categoria nuevaCategoria= seleccionarCategoria(sc);

                    Producto productoActualizado= new Producto(codigoActualizar, nombreNuevo, precioNuevo, cantidadNueva,nuevaCategoria);

                    if (supermercado.actualizarProducto(codigoActualizar, productoActualizado)) {
                        System.out.println("Producto actualizado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 9:
                    System.out.println("\n----- Eliminar Producto -----");
                    System.out.println("Código del producto a eliminar: ");
                    String codigoEliminado= sc.nextLine();

                    if (supermercado.eliminarProducto(codigoEliminado)){
                        System.out.println("El producto ha sido eliminado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 10:
                    System.out.println("\n----- Lista Productos -----");
                    for (Producto productoLista: supermercado.getListaProductos()) {
                        System.out.println(productoLista);
                    }
                    break;

                case 11:
                    System.out.println("\n----- Realizar Compra -----");
                    System.out.println("Documento: ");
                    int documentoCompra= sc.nextInt();
                    sc.nextLine();

                    System.out.println("Código de la compra: ");
                    String codigoCompra= sc.nextLine();

                    MetodoPago metodoPago= seleccionarMetodoPago(sc);

                    Compra compra= new Compra(codigoCompra, java.time.LocalDate.now(), 0, metodoPago);

                    if (supermercado.realizarCompra(documentoCompra, compra)) {

                        System.out.println("¿Cuántos productos desea agregar?");
                        int cantidadProductos = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < cantidadProductos; i++) {
                            System.out.println("Código del producto: ");
                            String codigoProducto = sc.nextLine();

                            System.out.println("Cantidad de ese producto: ");
                            int cantidad = sc.nextInt();
                            sc.nextLine();

                            if (supermercado.agregarProductoCompra(codigoCompra, codigoProducto, cantidad)) {
                                System.out.println("Producto agregado correctamente.");
                            } else {
                                System.out.println("No se pudo agregar el producto.");
                            }
                        }

                        double total = supermercado.calcularValorTotal(compra);
                        System.out.println("Valor Total de la Compra: " + total);

                    } else {
                        System.out.println("No se pudo realizar la compra.");
                    }
                    break;

                case 12:
                    System.out.println("\n----- Historial General de Compras ----");
                    for (Compra compraLista : supermercado.getListaCompras()) {
                        System.out.println(compraLista);
                    }
                    break;

                case 13:
                    System.out.println("\n----- Ventas por Fecha -----");
                    System.out.println("Ingrese la fecha (AAAA-MM-DD): ");

                    String fechaTexto = sc.nextLine();
                    java.time.LocalDate fecha = java.time.LocalDate.parse(fechaTexto);

                    double totalVentas = supermercado.calcularVentasPorFecha(fecha);

                    System.out.println("Valor total vendido el " + fecha + ": $" + totalVentas);
                    break;

                case 14:
                    System.out.println("Adiós.....");
                    break;

                default:
                    System.out.println("Opción no válida... Intente de nuevo.");
            }
        } while (opcion!=14);

        sc.close();
    }

    public static Categoria seleccionarCategoria(Scanner sc){
        System.out.println("Categoria del producto: ");
        System.out.println("1. Alimentos.");
        System.out.println("2. Bebidas.");
        System.out.println("3. Productos de Aseo.");
        System.out.println("4. Cuidado Personal.");

        System.out.println("Seleccione la opción: ");
        int opcionCategoria= sc.nextInt();
        sc.nextLine();

        switch (opcionCategoria){
            case 1:
                return Categoria.ALIMENTOS;

            case 2:
                return  Categoria.BEBIDAS;

            case 3:
                return Categoria.PRODUCTOSDEASEO;

            case 4:
                return Categoria.CUIDADOPERSONAL;

            default:
                System.out.println("Opción no válida... Se asigna Alimentos por defecto.");
                return Categoria.ALIMENTOS;
        }
    }

    public static MetodoPago seleccionarMetodoPago(Scanner sc){
        System.out.println("Método de pago:");
        System.out.println("1. Tarjeta.");
        System.out.println("2. Transferencia.");
        System.out.println("3. Efectivo.");

        System.out.println("Seleccione la opción: ");
        int opcionPago = sc.nextInt();
        sc.nextLine();

        switch (opcionPago) {
            case 1:
                return MetodoPago.TARJETA;

            case 2:
                return MetodoPago.TRANSFERENCIA;

            case 3:
                return MetodoPago.EFECTIVO;

            default:
                System.out.println("Opción no válida. Se asigna Efectivo por defecto.");
                return MetodoPago.EFECTIVO;
        }
    }
}
