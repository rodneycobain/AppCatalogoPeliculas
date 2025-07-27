package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo (){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
        //Si ya existe el archivo, NO se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya existe!");
            }
            else {
                //Si no  existe, se crea vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e) {
            System.out.println("Ocurrio un error al abrir el archivo: " + e.getMessage());

        }

    }

    @Override
    public void listarPeliculas() {
        //volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de Peliculas");
            //Abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            //Leemos todas las lineas
            while(linea !=null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            //Cerrar el archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error a leer el archivo" + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
