package com.springBoot.GestionEmpleados.repositorys;

import com.springBoot.GestionEmpleados.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    ArrayList<Empleado> findAll();

    Optional<Empleado> findById(Long id);
}
