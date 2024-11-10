package co.edu.uniquindio.bookyourstay.utils;

public class ValidacionUtil {

    public static void validarCampo(String campo, String nombreCampo) throws Exception {
        if (campo == null || campo.trim().isEmpty()) {
            throw new Exception("El campo " + nombreCampo + " es obligatorio.");
        }
    }
}
