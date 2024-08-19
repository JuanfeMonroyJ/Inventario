package inventory;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ProductTester {
    public static void main(String[] args) {
        // Crear un objeto Scanner para entrada por teclado
        Scanner in = new Scanner(System.in);

        int maxSize, menuChoice;

        maxSize = getNumProducts(in);
        if (maxSize == 0) {
            // Mostrar un mensaje si no se ingresan productos
            System.out.println("No products required!");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);

            do {
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice != 0);
        }

        in.close(); // Cerrar el scanner
    }

    /**
     * Muestra el menú y obtiene la opción del usuario.
     * @param in Objeto Scanner para entrada del usuario.
     * @return Opción seleccionada por el usuario.
     */
    public static int getMenuOption(Scanner in) {
        int menuOption = -1;
        while (menuOption < 0 || menuOption > 4) {
            System.out.println("1. View Inventory");
            System.out.println("2. Add Stock");
            System.out.println("3. Deduct Stock");
            System.out.println("4. Discontinue Product");
            System.out.println("0. Exit");
            System.out.print("Please enter a menu option: ");

            try {
                menuOption = in.nextInt();
                if (menuOption < 0 || menuOption > 4) {
                    System.out.println("Opción no válida, por favor ingrese un número entre 0 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de datos incorrecto introducido.");
                in.next(); // Limpia la entrada no válida
            }
        }
        return menuOption;
    }

    /**
     * Muestra los productos y permite al usuario seleccionar uno.
     * @param productos Arreglo de productos.
     * @param in Objeto Scanner para entrada del usuario.
     * @return Número del producto seleccionado.
     */
    public static int getProductNumber(Product[] productos, Scanner in) {
        int productChoice = -1;
        while (productChoice < 0 || productChoice >= productos.length) {
            System.out.println("Seleccione un producto por número:");
            for (int i = 0; i < productos.length; i++) {
                System.out.println(i + ". " + productos[i].getNombreDelProducto());
            }
            System.out.print("Número del producto: ");
            try {
                productChoice = in.nextInt();
                if (productChoice < 0 || productChoice >= productos.length) {
                    System.out.println("Número de producto no válido. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de datos incorrecto introducido.");
                in.next(); // Limpia la entrada no válida
            }
        }
        return productChoice;
    }

    /**
     * Agrega valores de existencias a un producto seleccionado.
     * @param productos Arreglo de productos.
     * @param in Objeto Scanner para entrada del usuario.
     */
    public static void addInventory(Product[] productos, Scanner in) {
        int productChoice;
        int updateValue = -1;

        productChoice = getProductNumber(productos, in);

        while (updateValue < 0) {
            System.out.print("¿Cuántos productos quiere agregar? ");
            try {
                updateValue = in.nextInt();
                if (updateValue < 0) {
                    System.out.println("La cantidad debe ser positiva.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de datos incorrecto introducido.");
                in.next(); // Limpia la entrada no válida
            }
        }

        productos[productChoice].addToInventory(updateValue);
    }

    /**
     * Resta valores de existencias a un producto seleccionado.
     * @param productos Arreglo de productos.
     * @param in Objeto Scanner para entrada del usuario.
     */
    public static void deductInventory(Product[] productos, Scanner in) {
        int productChoice;
        int updateValue = -1;

        productChoice = getProductNumber(productos, in);

        while (updateValue < 0) {
            System.out.print("¿Cuántos productos quiere restar? ");
            try {
                updateValue = in.nextInt();
                if (updateValue < 0) {
                    System.out.println("La cantidad debe ser positiva.");
                } else if (updateValue > productos[productChoice].getNumeroDeUnidadesEnExistencia()) {
                    System.out.println("No hay suficientes unidades en existencia.");
                    updateValue = -1; // Forzar otra iteración si la cantidad es mayor que el inventario
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de datos incorrecto introducido.");
                in.next(); // Limpia la entrada no válida
            }
        }

        productos[productChoice].deductFromInventory(updateValue);
    }

    /**
     * Marca un producto como descatalogado.
     * @param productos Arreglo de productos.
     * @param in Objeto Scanner para entrada del usuario.
     */
    public static void discontinueInventory(Product[] productos, Scanner in) {
        int productChoice;

        productChoice = getProductNumber(productos, in);

        productos[productChoice].setActivo(false);
    }

    /**
     * Ejecuta la opción del menú seleccionada.
     * @param menuOption Opción del menú seleccionada.
     * @param productos Arreglo de productos.
     * @param in Objeto Scanner para entrada del usuario.
     */
    public static void executeMenuChoice(int menuOption, Product[] productos, Scanner in) {
        switch (menuOption) {
            case 1:
                System.out.println("View Product List");
                displayInventory(productos);
                break;
            case 2:
                System.out.println("Add Stock");
                addInventory(productos, in);
                break;
            case 3:
                System.out.println("Deduct Stock");
                deductInventory(productos, in);
                break;
            case 4:
                System.out.println("Discontinue Stock");
                discontinueInventory(productos, in);
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    /**
     * Muestra el inventario de productos.
     * @param productos Arreglo de productos a mostrar.
     */
    public static void displayInventory(Product[] productos) {
        System.out.println("Productos en inventario:");
        for (Product producto : productos) {
            System.out.println(producto.toString());
        }
    }

    /**
     * Método estático que muestra el inventario de productos.
     * @param productos Arreglo de productos a llenar.
     * @param in Escáner para recibir la entrada del usuario.
     */
    public static void addToInventory(Product[] productos, Scanner in) {
        // Declaración de variables locales para almacenar los detalles del producto
        int tempNumber;
        String tempName;
        int tempQty;
        double tempPrice;
        boolean tempProductStatus;

        // Llenar el arreglo con los detalles de los productos
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Introduzca los detalles del producto " + (i + 1) + ":");

            // Pedir los detalles del producto
            System.out.print("Número del producto: ");
            tempNumber = in.nextInt();
            in.nextLine(); // Limpieza del buffer

            System.out.print("Nombre del producto: ");
            tempName = in.nextLine(); // Cambiado a nextLine() para capturar la cadena completa

            System.out.print("Cantidad del producto: ");
            tempQty = in.nextInt();

            System.out.print("Precio del producto: ");
            tempPrice = in.nextDouble();

            System.out.print("Estado del producto (true para disponible, false para no disponible): ");
            tempProductStatus = in.nextBoolean();

            // Crear y almacenar el producto en el arreglo
            productos[i] = new Product(tempNumber, tempName, tempQty, tempPrice, tempProductStatus);
        }
    }

    /**
     * Método estático que obtiene el número máximo de productos del usuario.
     * @param in Escáner para recibir la entrada del usuario.
     * @return Número máximo de productos introducido por el usuario.
     */
    public static int getNumProducts(Scanner in) {
        int maxSize = 0;

        System.out.println(); // Línea en blanco para separar los detalles
        System.out.println("Introduzca el número de productos que desea añadir");
        System.out.println("Introduzca 0 (cero) si no desea añadir productos: ");

        while (maxSize <= 0) {
            try {
                maxSize = in.nextInt();

                if (maxSize < 0) {
                    System.out.println("Número de productos no puede ser negativo.");
                    maxSize = 0; // Forzar otra iteración si el valor es incorrecto
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de datos incorrecto introducido.");
                in.next(); // Limpia la entrada no válida
            }
        }
        return maxSize;
    }
}

