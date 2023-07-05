import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListadeCompras {
    public static ArrayList<String> agregarItem(ArrayList<String> listaItems) {
        String item;
        Scanner tecladoItem = new Scanner(System.in);

        System.out.println("Agregar items - SALIR para terminar");
        do {
            item = tecladoItem.nextLine();
            if (!item.equals("SALIR")) {
                listaItems.add(item);
            }
        } while (!item.equals("SALIR"));

        verLista(listaItems);
        return listaItems;
    }

    public static void verLista(ArrayList<String> listaItems) {
        System.out.println("************************");
        System.out.println(listaItems);
        System.out.println("************************");
    }

    public static ArrayList<String> modificarItem(ArrayList<String> listaItems) {
        String item, itemNuevo;
        Scanner tecladoItem = new Scanner(System.in);
        int indiceItem;

        System.out.println("Ingrese item a modificar");
        item = tecladoItem.nextLine();

        indiceItem = buscarItem(item, listaItems);

        if (indiceItem != -1) {
            System.out.println("Ingrese nuevo item");
            itemNuevo = tecladoItem.nextLine();
            listaItems.set(indiceItem, itemNuevo);
        } else {
            System.out.println("Ese item no existe");
        }

        verLista(listaItems);
        return listaItems;
    }

    public static ArrayList<String> eliminarItem(ArrayList<String> listaItems) {
        String item;
        Scanner tecladoItem = new Scanner(System.in);
        int indiceItem;

        System.out.println("Ingrese item a eliminar");
        item = tecladoItem.nextLine();

        indiceItem = buscarItem(item, listaItems);

        if (indiceItem != -1) {
            listaItems.remove(indiceItem);
        } else {
            System.out.println("Ese item no existe");
        }

        verLista(listaItems);
        return listaItems;
    }

    public static int buscarItem(String item, ArrayList<String> listaItems) {
        int indiceItem;
        indiceItem = listaItems.indexOf(item);
        return indiceItem;
    }

    public static void guardarLista(ArrayList<String> listaItems) {
        FileWriter archivo = null;
        String rutaNombreArchivo = "listaCompras.txt"; // SE GUARDA EN LA CARPETA LOCAL DEL PROYECTO

        try {
            archivo = new FileWriter(rutaNombreArchivo);
            for (String item : listaItems) {
                archivo.write(item + "\n");
            }
            System.out.println("La lista se guardó correctamente");
            archivo.close();
        } catch (Exception excepcion) {
            System.out.println("No se pudo guardar la lista");
        }
    }

    public static void leerLista(ArrayList<String> listaItems) {
        String rutaNombreArchivo = "listaCompras.txt";
        File archivo = new File(rutaNombreArchivo);
        Scanner contenidoArchivo = null;
        // LEEMOS EL CONTENIDO DEL ARCHIVO
        try {
            System.out.println("... Leemos el contenido del archivo ...");
            contenidoArchivo = new Scanner(archivo);

            while (contenidoArchivo.hasNextLine()) {
                String linea = contenidoArchivo.nextLine();
                listaItems.add(linea);
            }
            contenidoArchivo.close();
        } catch (Exception exContenido) {
            System.out.println("No se encontró el archivo");
        }
    }

    public static void ejecutar() {

        ArrayList<String> lista = new ArrayList<String>();
        Scanner teclado = new Scanner(System.in);
        int opcionUsuario;

        System.out.println("************************");
        System.out.println("Lista de Compras");
        System.out.println("************************");

        leerLista(lista);

        do {
            System.out.println("Elige una opción");
            System.out.println("1- Agregar item");
            System.out.println("2- Ver lista");
            System.out.println("3- Modificar item");
            System.out.println("4- Eliminar item");
            System.out.println("5- Guardar Lista");
            System.out.println("6- Salir");

            System.out.print("Opcion: ");

            try {
                opcionUsuario = teclado.nextInt();
            } catch (Exception error) {
                //System.out.println(error);
                opcionUsuario = 0;
                teclado.next(); // VACIA EL SCANNER
            }

            switch (opcionUsuario) {
                case 1:
                    System.out.println("1- Agregar item");
                    lista = agregarItem(lista);
                    break;
                case 2:
                    System.out.println("2- Ver lista");
                    verLista(lista);
                    break;
                case 3:
                    System.out.println("3- Modificar item");
                    modificarItem(lista);
                    break;
                case 4:
                    System.out.println("4- Eliminar item");
                    eliminarItem(lista);
                    break;
                case 5:
                    System.out.println("5- Guardar Lista");
                    guardarLista(lista);
                    break;
                case 6:
                    System.out.println("Adios");
                    guardarLista(lista);
                    break;
                default:
                    System.out.println("Debe ingresar un número entre 1 y 5");
            }
        } while (opcionUsuario != 6);
    }
}