package travel.ProyectoFinalDH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.ProyectoFinalDH.dto.entrada.ProductoDto;
import travel.ProyectoFinalDH.dto.salida.ProductoSalidaDto;
import travel.ProyectoFinalDH.service.ProductoService;

import java.util.List;



@RequestMapping("/productos")
@RestController
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoSalidaDto>> listarTodosLosProductos() {
        List<ProductoSalidaDto> productos = productoService.listarTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ProductoSalidaDto> crearProducto(@ModelAttribute ProductoDto productoDTO) {
        ProductoSalidaDto nuevoProducto = productoService.crearProducto(productoDTO);
        return ResponseEntity.ok(nuevoProducto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoSalidaDto> listarProductoPorId(@PathVariable("id") Long productoId) {
        ProductoSalidaDto productoSalidaDto = productoService.listarProductoPorId(productoId);
        return new ResponseEntity<>(productoSalidaDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
