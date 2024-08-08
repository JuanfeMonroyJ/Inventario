package inventory;

import java.util.Scanner;

public class ProductTester {
    public static void main(String[] args) {
    	
    	Product p7 = new Product();
    	// Imprimir el detalle del producto usando el método toString()
    	System.out.println(p7.toString());
    	
    	// Apertura de scanner
    	Scanner in = new Scanner (System.in);
    	
    
    	//Variables locales p
    	int tempNumber = 0;
    	String tempName = " ";
    	int tempQty = 0;
    	double tempPrice = 0;
    	boolean tempProductStatus;

    	
    	
    	// Solicitar valores al usuario para el objeto p1
    	System.out.println("Ingrese el numero del producto");
    	tempNumber = in.nextInt();
    	 in.nextLine(); // Limpiar el buffer de entrada.
    	
    	 System.out.println("Ingrese el nombre del producto");
    	tempName = in.nextLine(); 
    	
    	System.out.println("Ingrese la cantidad del producto");
    	tempQty = in.nextInt();
    	
    	System.out.println("Ingrese el precio del producto");
    	tempPrice = in.nextDouble();
    	
    	System.out.println("¿Producto disponible?");
    	tempProductStatus = in.nextBoolean();
    	
    	System.out.println(); // Línea en blanco para separar los detalles
    	System.out.println("Su Producto será: " + tempNumber + ", Producto: " + tempName + ", Cantidad: " + tempQty + ", Precio total: " + (tempPrice * tempQty) + ", Estado: " + (tempProductStatus ? "Activo" : "Descatalogado"));
    	
    	System.out.println(); // Línea en blanco para separar los detalles
    	
    	    	
        // productos usando el constructor predeterminado
        Product product1 = new Product();
        Product product2 = new Product();
        
     // Marcar p6 como descatalogado
        Product p6 = new Product();

        product1.setNumeroElemento(1);
        product1.setNombreDelProducto("Huevo");
        product1.setNumeroDeUnidadesEnExistencia(12);
        product1.setPrecioDeCadaUnidad(1300);
        
        product2.setNumeroElemento(2);
        product2.setNombreDelProducto("Leche");
        product2.setNumeroDeUnidadesEnExistencia(6);
        product2.setPrecioDeCadaUnidad(3600);
        
        p6.setNumeroElemento(6);
        p6.setNombreDelProducto("Queso");
        p6.setNumeroDeUnidadesEnExistencia(6);
        p6.setPrecioDeCadaUnidad(3600);
        p6.setActivo(false);
        
        // Productos con argumentos (p1)
        Product p1 = new Product(tempNumber, tempName, tempQty, tempPrice * tempQty, tempProductStatus);
        System.out.println("Valor del inventario de p1: " + p1.calcularValorInventario());
        
        // Solicitar valores al usuario para el objeto p2
    	System.out.println("Ingrese el numero del producto");
    	tempNumber = in.nextInt();
    	
    	 in.nextLine(); // Limpiar el buffer de entrada.
    	 
    	System.out.println("Ingrese el nombre del producto");
    	tempName = in.nextLine(); 
    	
    	System.out.println("Ingrese la cantidad del producto");
    	tempQty = in.nextInt();
    	
    	System.out.println("Ingrese el precio del producto");
    	tempPrice = in.nextDouble();
    	
    	System.out.println("¿Producto disponible?");
    	tempProductStatus = in.nextBoolean();
    	
    	System.out.println(); // Línea en blanco para separar los detalles
    	System.out.println("Su Producto será: " + tempNumber + ", Producto: " + tempName + ", Cantidad: " + tempQty + ", Precio total: " + (tempPrice * tempQty) + ", Estado: " + (tempProductStatus ? "Activo" : "Descatalogado"));
    	
    	System.out.println(); // Línea en blanco para separar los detalles
    	
    	
    	// Productos con argumentos (p2)
    	Product p2 = new Product(tempNumber, tempName, tempQty, tempPrice * tempQty, tempProductStatus);
    	
    	    	
    	// Productos con argumentos
        Product product3 = new Product(3, "Cafe", 1, 32000, true);
        Product product4 = new Product(4, "Arroz", 5, 4000, true);
        Product product5 = new Product(5, "Pan Tajado", 6, 6000, true);
        Product product6 = new Product(6, "Frijol", 25, 3000, true);
        

        // Mostrar los detalles de los productos usando toString()
        System.out.println("Producto p1 Detalles:");
        System.out.println(p1.toString());
        
        System.out.println(); // Línea en blanco para separar los detalles
        
        System.out.println("Producto p2 Detalles:");
        System.out.println(p2.toString());
        
        System.out.println(); // Línea en blanco para separar los detalles
        
        System.out.println("Producto p6 Detalles:");
        System.out.println(p6.toString());
        
        System.out.println(); // Línea en blanco para separar los detalles
        
        
        in.close(); // Cierre de Scanner
        
        
        // Mostrar los detalles fijos de los productos usando toString()
        System.out.println(); // Línea en blanco para separar los detalles
        
        System.out.println("Producto 1 Detalles:");
        System.out.println(product1.toString());
        System.out.println(); // Línea en blanco para separar los detalles

        System.out.println("Producto 2 Detalles:");
        System.out.println(product2.toString());
        System.out.println(); // Línea en blanco para separar los detalles
        
        System.out.println("Producto 3 Detalles:");
        System.out.println(product3.toString());
        System.out.println(); // Línea en blanco para separar los detalles
        
        System.out.println("Producto 4 Detalles:");
        System.out.println(product4.toString());
        System.out.println(); // Línea en blanco para separar los detalles
        
        System.out.println("Producto 5 Detalles:");
        System.out.println(product5.toString());
        System.out.println(); // Línea en blanco para separar los detalles
        
        System.out.println("Producto 6 Detalles:");
        System.out.println(product6.toString());
        System.out.println(); // Línea en blanco para separar los detalles
    }
}
