package inventory;

public class ProductTester {
    public static void main(String[] args) {
    	
        // productos usando el constructor predeterminado

        Product product1 = new Product();
        Product product2 = new Product();
        
        product1.setNumeroElemento(1);
        product1.setNombreDelProducto("Huevo");
        product1.setNumeroDeUnidadesEnExistencia(12);
        product1.setPrecioDeCadaUnidad(1300);
        
        product2.setNumeroElemento(2);
        product2.setNombreDelProducto("Leche");
        product2.setNumeroDeUnidadesEnExistencia(6);
        product2.setPrecioDeCadaUnidad(3600);
        
        // Productos con argumentos
        Product product3 = new Product(3, "Cafe", 1, 32000);
        Product product4 = new Product(4, "Arroz", 5, 4000);
        Product product5 = new Product(5, "Pan Tajado", 6, 6000  );
        Product product6 = new Product(6, "Frijol", 25, 3000);
        

        // Mostrar los detalles de los productos usando toString()
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
