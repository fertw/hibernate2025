package hibernate.curso.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.dto.EmpresaDTO;
import hibernate.curso.mapper.EmpresaMapper;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.repository.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmpresaMapper empresaMapper;

	@Transactional
	public void guardar(Empresa empresa) {
		empresaRepository.save(empresa);
	}

	public EmpresaDTO buscarEmpresaPorId(Long id) {
		Empresa e = empresaRepository.findByIdConProductosYCategorias(id)
				.orElseThrow(() -> new IllegalArgumentException("Empresa no encontrada: " + id));
		return modelMapper.map(e, EmpresaDTO.class);
	}
	
	public EmpresaDTO buscarPorId(Long id) {
		Empresa e = empresaRepository.findByIdConProductosYCategorias(id)
				.orElseThrow(() -> new IllegalArgumentException("Empresa no encontrada: " + id));
		
		return empresaMapper.toDto(e);
	}
        

}
