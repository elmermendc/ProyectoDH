package travel.ProyectoFinalDH.service;

import travel.ProyectoFinalDH.dto.entrada.ProductoDto;
import travel.ProyectoFinalDH.dto.salida.ProductoSalidaDto;

import java.util.List;

public interface ProductoService {
    List<ProductoSalidaDto> listarTodosLosProductos();
    ProductoSalidaDto crearProducto(ProductoDto productoDTO);
    ProductoSalidaDto listarProductoPorId(Long id);
    void eliminar(Long id);
}
