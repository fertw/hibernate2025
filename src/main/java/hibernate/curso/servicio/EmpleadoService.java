package hibernate.curso.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Empleado;
import hibernate.curso.modelo.herencia.joined.EmpleadoContratadoB;
import hibernate.curso.modelo.herencia.joined.EmpleadoPlantaB;
import hibernate.curso.modelo.herencia.singletable.EmpleadoContratadoA;
import hibernate.curso.modelo.herencia.singletable.EmpleadoPlantaA;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoContratadoC;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoPlantaC;
import hibernate.curso.repository.EmpleadoContratadoARepository;
import hibernate.curso.repository.EmpleadoContratadoBRepository;
import hibernate.curso.repository.EmpleadoContratadoCRepository;
import hibernate.curso.repository.EmpleadoPlantaARepository;
import hibernate.curso.repository.EmpleadoPlantaBRepository;
import hibernate.curso.repository.EmpleadoPlantaCRepository;
import hibernate.curso.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	EmpleadoContratadoARepository empleadoContratadoARepository;
	
	@Autowired
	EmpleadoPlantaARepository empleadoPlantaARepository;
	
	@Autowired
	EmpleadoPlantaBRepository empleadoPlantaBRepository;
	
	@Autowired
	EmpleadoContratadoBRepository empleadoContratadoBRepository;
	
	@Autowired
	EmpleadoPlantaCRepository empleadoPlantaCRepository;
	
	@Autowired
	EmpleadoContratadoCRepository empleadoContratadoCRepository;
	
	public void guardar(Empleado empleado) {
		empleadoRepository.save(empleado);
	}
	
	public void guardarEmpleadoContratado(EmpleadoContratadoA empleado) {
		empleadoContratadoARepository.save(empleado);
	}
	
	public void guardarEmpleadoPlanta(EmpleadoPlantaA empleado) {
		empleadoPlantaARepository.save(empleado);
	}
	
	public void guardarEmpleadoBPlanta(EmpleadoPlantaB empleado) {
		empleadoPlantaBRepository.save(empleado);
	}
	
	public void guardarEmpleadoBContratado(EmpleadoContratadoB empleado) {
		empleadoContratadoBRepository.save(empleado);
	}
	
	public void guardarEmpleadoCPlanta(EmpleadoPlantaC empleado) {
		empleadoPlantaCRepository.save(empleado);
	}
	
	public void guardarEmpleadoCContratado(EmpleadoContratadoC empleado) {
		empleadoContratadoCRepository.save(empleado);
	}
	
	
	
	
}
