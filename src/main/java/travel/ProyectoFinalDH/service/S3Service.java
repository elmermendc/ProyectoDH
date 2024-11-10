package travel.ProyectoFinalDH.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String subirImagen(MultipartFile file);
    void eliminarImagen(String imagenUrl);
}
