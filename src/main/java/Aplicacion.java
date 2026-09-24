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
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
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
