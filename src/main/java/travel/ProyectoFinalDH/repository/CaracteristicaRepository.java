package travel.ProyectoFinalDH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel.ProyectoFinalDH.entity.Caracteristica;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Long> {
}
