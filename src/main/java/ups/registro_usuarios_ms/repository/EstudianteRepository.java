package ups.registro_usuarios_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ups.registro_usuarios_ms.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
