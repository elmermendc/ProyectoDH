package travel.ProyectoFinalDH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.ProyectoFinalDH.dto.entrada.CategoriaDto;
import travel.ProyectoFinalDH.dto.salida.CategoriaSalidaDto;
import travel.ProyectoFinalDH.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaSalidaDto> listarTodas() {
        return categoriaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaSalidaDto> obtenerPorId(@PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.obtenerCategoriaDtoPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaSalidaDto> crear(@ModelAttribute CategoriaDto categoriaDto) {
        CategoriaSalidaDto nuevaCategoria = categoriaService.crear(categoriaDto);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaSalidaDto> actualizarCategoria(
            @PathVariable Long id,
            @ModelAttribute CategoriaDto categoriaDto) {
        CategoriaSalidaDto categoriaActualizada = categoriaService.actualizar(id, categoriaDto);
        return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}