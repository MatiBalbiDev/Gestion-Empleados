package com.springBoot.GestionEmpleados.services.impl;

import com.springBoot.GestionEmpleados.models.Empleado;
import com.springBoot.GestionEmpleados.repositorys.EmpleadoRepository;
import com.springBoot.GestionEmpleados.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public ArrayList<Empleado> getEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Empleado empleadoExistente, Empleado empleadoActualizado) {
        empleadoExistente.setNombre(empleadoActualizado.getNombre());
        empleadoExistente.setApellido(empleadoActualizado.getApellido());
        empleadoExistente.setDni(empleadoActualizado.getDni());
        empleadoExistente.setPuesto(empleadoActualizado.getPuesto());
        return empleadoRepository.save(empleadoExistente);
    }

    @Override
    public void deleteEmpleadoById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
