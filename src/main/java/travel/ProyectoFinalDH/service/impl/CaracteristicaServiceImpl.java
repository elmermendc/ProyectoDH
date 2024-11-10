package travel.ProyectoFinalDH.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.ProyectoFinalDH.dto.salida.CaracteristicaSalidaDto;
import travel.ProyectoFinalDH.entity.Caracteristica;
import travel.ProyectoFinalDH.exception.NotFoundException;
import travel.ProyectoFinalDH.repository.CaracteristicaRepository;
import travel.ProyectoFinalDH.service.CaracteristicaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {

    private final ModelMapper modelMapper;
    private final CaracteristicaRepository caracteristicaRepository;

    @Autowired
    public CaracteristicaServiceImpl(ModelMapper modelMapper, CaracteristicaRepository caracteristicaRepository) {
        this.modelMapper = modelMapper;
        this.caracteristicaRepository = caracteristicaRepository;
    }

    @Override
    public List<CaracteristicaSalidaDto> listarTodas() {
        return caracteristicaRepository.findAll().stream()
                .map(caracteristica -> modelMapper.map(caracteristica, CaracteristicaSalidaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CaracteristicaSalidaDto obtenerCaracteristicaDtoPorId(Long id) {
        Caracteristica caracteristica = obtenerPorId(id);
        return modelMapper.map(caracteristica, CaracteristicaSalidaDto.class);
    }

    @Override
    public Caracteristica obtenerPorId(Long id) {
        return caracteristicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Característica no encontrada"));
    }

    @Override
    public CaracteristicaSalidaDto  crear(Caracteristica caracteristica) {
        Caracteristica nuevaCaracteristica = caracteristicaRepository.save(caracteristica);
        return modelMapper.map(nuevaCaracteristica, CaracteristicaSalidaDto.class);
    }

    @Override
    public CaracteristicaSalidaDto actualizar(Long id, Caracteristica caracteristicaActualizada) {
        Caracteristica caracteristica = obtenerPorId(id);
        caracteristica.setNombre(caracteristicaActualizada.getNombre());
        caracteristica.setIcono(caracteristicaActualizada.getIcono());
        Caracteristica actualizada = caracteristicaRepository.save(caracteristica);
        return modelMapper.map(actualizada, CaracteristicaSalidaDto.class);
    }

    @Override
    public void eliminar(Long id) {
        caracteristicaRepository.deleteById(id);
    }
}