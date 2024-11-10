package travel.ProyectoFinalDH.service;

import travel.ProyectoFinalDH.dto.salida.CaracteristicaSalidaDto;
import travel.ProyectoFinalDH.entity.Caracteristica;

import java.util.List;

public interface CaracteristicaService {
    List<CaracteristicaSalidaDto> listarTodas();
    CaracteristicaSalidaDto obtenerCaracteristicaDtoPorId(Long id);
    Caracteristica obtenerPorId(Long id);
    CaracteristicaSalidaDto  crear(Caracteristica caracteristica);
    CaracteristicaSalidaDto actualizar(Long id, Caracteristica caracteristicaActualizada);
    void eliminar(Long id);
}