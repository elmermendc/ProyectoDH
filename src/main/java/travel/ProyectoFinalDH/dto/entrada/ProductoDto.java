package travel.ProyectoFinalDH.dto.entrada;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class ProductoDto {
    private String nombre;
    private String descripcion;
    private String region;
    private int cantidad;
    private double precio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha; // Puede ser LocalDate
    private Long categoriaId; // ID de la categoría
    private List<Long> caracteristicaIds; // IDs de las características
    private List<MultipartFile> imagenes;

    public ProductoDto(){}

    public ProductoDto(String nombre, String descripcion, String region, int cantidad, double precio, Date fecha, Long categoriaId, List<Long> caracteristicaIds, List<MultipartFile> imagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.region = region;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.categoriaId = categoriaId;
        this.caracteristicaIds = caracteristicaIds;
        this.imagenes = imagenes;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<Long> getCaracteristicaIds() {
        return caracteristicaIds;
    }

    public void setCaracteristicaIds(List<Long> caracteristicaIds) {
        this.caracteristicaIds = caracteristicaIds;
    }

    public List<MultipartFile> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<MultipartFile> imagenes) {
        this.imagenes = imagenes;
    }
}
