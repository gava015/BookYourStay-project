package co.edu.uniquindio.bookyourstay.servicios;

import co.edu.uniquindio.bookyourstay.enums.Servicio;

import java.util.List;

public interface Gestion {


    void crearApartamento(String nombre, String cuidad, String descripcion, String imagen, double precio, int capacidadMax,
                          List<Servicio> listaServicios);


    void crearCasa(String nombre, String cuidad, String descripcion, String imagen, double precio, int capacidadMax,
                    List<Servicio> listaServicios);

    void crearHotel(String nombre, String cuidad, String descripcion, String imagen, double precio, int capacidadMax,
                    List<Servicio> listaServicios);

}
