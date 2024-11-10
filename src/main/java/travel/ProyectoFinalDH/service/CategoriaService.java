package travel.ProyectoFinalDH.service;

import travel.ProyectoFinalDH.dto.entrada.CategoriaDto;
import travel.ProyectoFinalDH.dto.salida.CategoriaSalidaDto;
import travel.ProyectoFinalDH.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    List<CategoriaSalidaDto> listarTodas();
    CategoriaSalidaDto obtenerCategoriaDtoPorId(Long id);
    Categoria obtenerPorId(Long id);
    CategoriaSalidaDto  crear(CategoriaDto categoriaDto);
    CategoriaSalidaDto  actualizar(Long id, CategoriaDto categoriaDto);
    void eliminar(Long id);
}