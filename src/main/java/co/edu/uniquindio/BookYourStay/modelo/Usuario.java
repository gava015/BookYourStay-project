package co.edu.uniquindio.BookYourStay.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    protected String correo;
    protected String contraseña;
    protected String identificacion;
    protected String nombre;
    protected String telefono;
}
