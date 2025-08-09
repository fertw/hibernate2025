package hibernate.curso.dto;

import java.util.List;

public class EmpresaDTO {
  private String nombre;
  private String cuit;
  private List<ProductoDTO> productos;

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public String getCuit() { return cuit; }
  public void setCuit(String cuit) { this.cuit = cuit; }

  public List<ProductoDTO> getProductos() { return productos; }
  public void setProductos(List<ProductoDTO> productos) { this.productos = productos; }
}
