package inventory;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ProductTester {
	public static void main(String[] args) {

		// Apertura de scanner
		Scanner in = new Scanner(System.in);

		int maxSize = 0;

		System.out.println(); // Línea en blanco para separar los detalles
		System.out.println("Introduzca el número de productos que desea añadir");
		System.out.println("Introduzca 0 (cero) si no desea añadir productos: ");
		maxSize = in.nextInt();
		System.out.println(); // Línea en blanco para separar los detalles

		do {
			try {
				System.out.println("introduzca un valor Mayor A: 0");
				maxSize = in.nextInt();

				if (maxSize <= 0) {
					System.out.println("Valor incorrecto introducido");
					maxSize = -1; // Forzar otra iteración si el valor es incorrecto
				}
			} catch (InputMismatchException e) {
				System.out.println("Tipo de datos incorrecto introducido.");
				in.next(); // Limpia la entrada no válida
				maxSize = -1; // Forzar otra iteración
			}
		} while (maxSize <= 0);

		// Manejo de los productos en función de la cantidad introducida

		if (maxSize == 0) {
			System.out.println("No se requieren productos.");
		} else {
			// Crear el arreglo unidimensional de productos
			Product[] productos = new Product[maxSize];

			// Llenar el arreglo con los detalles de los productos
			for (int i = 0; i < maxSize; i++) {
				System.out.println("Introduzca los detalles del producto " + (i + 1) + ":");

				// Pedir los detalles del producto
				System.out.print("Número del producto: ");
				int tempNumber = in.nextInt();
				in.nextLine(); // Limpieza del buffer

				System.out.print("Nombre del producto: ");
				String tempName = in.next();

				System.out.print("Cantidad del producto: ");
				int tempQty = in.nextInt();

				System.out.print("Precio del producto: ");
				double tempPrice = in.nextDouble();

				System.out.print("Estado del producto (true para disponible, false para no disponible): ");
				boolean tempProductStatus = in.nextBoolean();

				// Crear y almacenar el producto en el arreglo
				productos[i] = new Product(tempNumber, tempName, tempQty, tempPrice, tempProductStatus);
			}
			
				System.out.println(); // Separador en blanco
				
				// Mostrar los productos agregados utilizando un ciclo for-each
	            System.out.println("Productos agregados:");
	            for (Product producto : productos) {
	                System.out.println(producto.toString());
	            }
	            in.close();
			}
	}		
}

		
