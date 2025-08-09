package hibernate.curso.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.dto.EmpresaDTO;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.repository.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {


   @Autowired
   private EmpresaRepository empresaRepository;
   
	@Autowired
	private ModelMapper modelMapper;

    @Transactional
    public void guardar(Empresa empresa) {
		empresaRepository.save(empresa);       
    }
 
    
    public Empresa buscarPorCuit(String cuit) {
		return empresaRepository.findByCuit(cuit).stream().findFirst().orElse(null);
	}
	
    
    
	public EmpresaDTO buscarEmpresaPorId(Long id) {
		Empresa empresa = empresaRepository.findById(id).orElse(null);
		if (empresa != null) {
			return modelMapper.map(empresa, EmpresaDTO.class);
		}
		return null;
	}
    
    
   
}
