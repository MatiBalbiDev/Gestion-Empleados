package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.GestionEmpleados.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Long, Empleado>{

}
