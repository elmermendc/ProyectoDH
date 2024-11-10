package travel.ProyectoFinalDH.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.ProyectoFinalDH.dto.entrada.CategoriaDto;
import travel.ProyectoFinalDH.dto.salida.CategoriaSalidaDto;
import travel.ProyectoFinalDH.entity.Categoria;
import travel.ProyectoFinalDH.exception.NotFoundException;
import travel.ProyectoFinalDH.repository.CategoriaRepository;
import travel.ProyectoFinalDH.service.CategoriaService;
import travel.ProyectoFinalDH.service.S3Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final ModelMapper modelMapper;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private S3Service s3Service;

    @Autowired
    public CategoriaServiceImpl(ModelMapper modelMapper, CategoriaRepository categoriaRepository) {
        this.modelMapper = modelMapper;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaSalidaDto> listarTodas() {
        return categoriaRepository.findAll().stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaSalidaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaSalidaDto obtenerCategoriaDtoPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
        return modelMapper.map(categoria, CategoriaSalidaDto.class);
    }

    @Override
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
    }

    @Override
    public CategoriaSalidaDto  crear(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        categoria.setTitulo(categoriaDto.getTitulo());
        categoria.setDescripcion(categoriaDto.getDescripcion());

        if (categoriaDto.getImagenRepresentativa() != null && !categoriaDto.getImagenRepresentativa().isEmpty()) {
            String imagenUrl = s3Service.subirImagen(categoriaDto.getImagenRepresentativa());
            categoria.setImagenRepresentativa(imagenUrl);
        }

        Categoria categoriaGuardada = categoriaRepository.save(categoria);
        return modelMapper.map(categoriaGuardada, CategoriaSalidaDto.class);
    }

    @Override
    public CategoriaSalidaDto  actualizar(Long id, CategoriaDto categoriaDto) {
        Categoria categoriaExistente =obtenerPorId(id);

        // Si hay una nueva imagen, eliminar la anterior y subir la nueva
        if (categoriaDto.getImagenRepresentativa() != null && !categoriaDto.getImagenRepresentativa().isEmpty()) {
            s3Service.eliminarImagen(categoriaExistente.getImagenRepresentativa()); // Eliminar la imagen anterior
            String nuevaImagenUrl = s3Service.subirImagen(categoriaDto.getImagenRepresentativa()); // Subir la nueva
            categoriaExistente.setImagenRepresentativa(nuevaImagenUrl);
        }

        categoriaExistente.setTitulo(categoriaDto.getTitulo());
        categoriaExistente.setDescripcion(categoriaDto.getDescripcion());

        Categoria categoriaActualizada = categoriaRepository.save(categoriaExistente);
        return modelMapper.map(categoriaActualizada, CategoriaSalidaDto.class);
    }

    @Override
    public void eliminar(Long id) {
        Categoria categoria = obtenerPorId(id);

        // Eliminar la imagen asociada del bucket
        s3Service.eliminarImagen(categoria.getImagenRepresentativa());

        // Eliminar la categoría de la base de datos
        categoriaRepository.delete(categoria);
    }
}