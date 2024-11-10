package co.edu.uniquindio.bookyourstay.modelo;

import co.edu.uniquindio.bookyourstay.enums.EstadoReserva;
import co.edu.uniquindio.bookyourstay.enums.Servicio;
import co.edu.uniquindio.bookyourstay.enums.TipoAlojamiento;
import co.edu.uniquindio.bookyourstay.factory.AlojamientoFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServicioReserva {

    private AlojamientoFactory factory;

    private List<Alojamiento> listaAlojamientos;

    private List<Oferta> listaOfertas;

    private List<Usuario> listaUsuarios;

    private List<Reserva> listaReservas;

    public ServicioReserva() {
        factory = new AlojamientoFactory();
        listaAlojamientos = new ArrayList<>();
        listaOfertas = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
    }

    public Usuario loginUsuario(String correo, String contrasenia) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getContrasenia().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario crearUsuario(String identificacion, String nombre, String telefono, String correo, String contrasenia) throws Exception {
        //TODO: Agregar validaciones

        Usuario usuarioBuscado = buscarUsuario(identificacion);
        if (usuarioBuscado != null) {
            throw new Exception("Ya existe un cliente registrado con la identificacion: " + identificacion);
        }

        Usuario cliente = Usuario.builder()
                .identificacion(identificacion)
                .nombre(nombre)
                .correo(correo)
                .telefono(telefono)
                .contrasenia(contrasenia)
                .build();

        listaUsuarios.add(cliente);
        return cliente;
    }

    public Usuario buscarUsuario(String identificacion) {
        for (Usuario usuario : listaUsuarios) {
            if (identificacion.equals(usuario.getIdentificacion())) {
                return usuario;
            }
        }
        return null;
    }

    public void eliminarUsuario(String usuarioId) throws Exception {
        Usuario usuario = buscarUsuario(usuarioId);
        if (usuario == null) {
            throw new Exception("No existe un usuario con el ID: " + usuarioId);
        }

        listaUsuarios.remove(usuario);
    }

    public Oferta crearOferta(String descripcion, double descuento, LocalDate fechaInicio, LocalDate fechaFinal) {

        //TODO: Agregar validaciones
        Oferta oferta = new Oferta(UUID.randomUUID().toString(), descripcion, descuento, fechaInicio, fechaFinal);
        listaOfertas.add(oferta);
        return oferta;
    }

    public Oferta buscarOferta(String ofertaId) {
        for (Oferta oferta : listaOfertas) {
            if (ofertaId.equals(oferta.getId())) {
                return oferta;
            }
        }
        return null;
    }

    public void eliminarOferta(String ofertaId) throws Exception {
        Oferta oferta = buscarOferta(ofertaId);
        if (oferta == null) {
            throw new Exception("No existe una oferta con el ID " + ofertaId);
        }

        listaOfertas.remove(oferta);
    }

    public Alojamiento crearAlojamiento(TipoAlojamiento tipoAlojamiento, String nombre, String ciudad, String descripcion,
                                        String urlImagen, double precioPorNoche, int capacidadMax,
                                        Double costoAseoMantenimiento, List<Servicio> listaServicios) throws Exception {

        //TODO: Agregar validaciones
        Alojamiento alojamiento = factory.crearAlojamiento(
                tipoAlojamiento,
                nombre,
                ciudad,
                descripcion,
                urlImagen,
                precioPorNoche,
                capacidadMax,
                costoAseoMantenimiento,
                listaServicios);

        listaAlojamientos.add(alojamiento);
        return alojamiento;
    }

    public Alojamiento buscarAlojamiento(String alojamientoId) {
        for (Alojamiento alojamiento : listaAlojamientos) {
            if (alojamientoId.equals(alojamiento.getId())) {
                return alojamiento;
            }
        }
        return null;
    }

    public void eliminarAlojamiento(String alojamientoId) throws Exception {
        Alojamiento alojamiento = buscarAlojamiento(alojamientoId);
        if (alojamiento == null) {
            throw new Exception("No existe un alojamiento con el ID " + alojamientoId);
        }

        listaAlojamientos.remove(alojamiento);
    }

    public void crearHabitacion(String alojamientoId, String numero, double precio, int capacidad, String urlImagen, String descripcion) throws Exception {
        //TODO: Agregar validaciones

        Hotel hotel = (Hotel) buscarAlojamiento(alojamientoId);
        if (hotel == null) {
            throw new Exception("No existe un hotel con el ID: " + alojamientoId);
        }

        hotel.crearHabitacion(numero, precio, capacidad, urlImagen, descripcion);
    }

    public Reserva crearReserva(String identificacion, String alojamientoId, LocalDate fechaInicio, LocalDate fechaFinal, int numeroHuespedes) throws Exception {

        Cliente cliente = (Cliente) buscarUsuario(identificacion);
        if (cliente == null) {
            throw new Exception("No existe un cliente con la identificación: " + identificacion);
        }

        Alojamiento alojamiento = buscarAlojamiento(alojamientoId);
        if (alojamiento == null) {
            throw new Exception("No existe un alojamiento con el ID " + alojamientoId);
        }

        if (numeroHuespedes > alojamiento.getCapacidadMax()) {
            throw new Exception("El alojamiento no cuenta con capacidad para el número de huespedes ingresado.");
        }

        //TODO: Agregar validaciones
        Reserva reserva = Reserva.builder()
                .cliente(cliente)
                .alojamiento(alojamiento)
                .fechaInicio(fechaInicio)
                .fechaFinal(fechaFinal)
                .numeroHuespedes(numeroHuespedes)
                .estado(EstadoReserva.CONFIRMADO)
                .build();

        reserva.calcularCostoReserva();
        if (cliente.getBilleteraVirtual().getValor() < reserva.getCostoReserva()) {
            throw new Exception("La billetera virtual no cuenta con fondos suficientes.");
        }

        listaReservas.add(reserva);
        return reserva;
    }

    public Reserva buscarReserva(String reservaId) {
        for (Reserva reserva: listaReservas) {
            if (reservaId.equals(reserva.getId())) {
                return reserva;
            }
        }
        return null;
    }

    public void eliminarReserva(String reservaId) throws Exception {
        Reserva reserva = buscarReserva(reservaId);
        if (reserva == null) {
            throw new Exception("No existe una reserva con el ID " + reservaId);
        }

        listaReservas.remove(reserva);
    }



    public static void main(String[] args) {
        ServicioReserva servicioReserva = new ServicioReserva();

        try {
            Alojamiento casa = servicioReserva.crearAlojamiento(TipoAlojamiento.CASA, "Casa", "Armenia", "Casa", "URL",
                    60.000, 5, 40.000, new ArrayList<>());

            Alojamiento apartamento = servicioReserva.crearAlojamiento(TipoAlojamiento.APARTAMENTO, "Apartamento", "Medellin", "Apartamento", "URL",
                    120.000, 5, 50.000, new ArrayList<>());


            Usuario usuario = servicioReserva.crearUsuario("1234", "Stiven", "7326132", "s@gmail.com", "123");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
