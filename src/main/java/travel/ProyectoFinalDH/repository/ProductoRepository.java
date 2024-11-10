package travel.ProyectoFinalDH.repository;

import org.springframework.data.repository.CrudRepository;
import travel.ProyectoFinalDH.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

  Producto findById(long id);

  Producto findByNombre(String nombre);
}