package travel.ProyectoFinalDH.dto.salida;

import java.util.Date;
import java.util.List;

public class ProductoSalidaDto {
    private Long id; // ID del producto
    private String nombre; // Nombre del producto
    private String descripcion; // Descripción del producto
    private String region; // Región donde se ofrece el producto
    private int cantidad; // Cantidad disponible
    private double precio; // Precio del producto
    private Date fecha;
    private List<String> imagenes; // URLs de las imágenes
    private CategoriaSalidaDto categoria; // Información de la categoría
    private List<CaracteristicaSalidaDto> caracteristicas; // Lista de características

    public ProductoSalidaDto(){}
    public ProductoSalidaDto(Long id, String nombre, String descripcion, String region, int cantidad, double precio, Date fecha, List<String> imagenes, CategoriaSalidaDto categoria, List<CaracteristicaSalidaDto> caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.region = region;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.imagenes = imagenes;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public CategoriaSalidaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSalidaDto categoria) {
        this.categoria = categoria;
    }

    public List<CaracteristicaSalidaDto> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CaracteristicaSalidaDto> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}