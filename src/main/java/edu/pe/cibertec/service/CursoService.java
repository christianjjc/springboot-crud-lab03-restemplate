package edu.pe.cibertec.service;

import edu.pe.cibertec.dao.CursoDAO;
import edu.pe.cibertec.dto.CursoDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService
{
  @Getter @Setter
  @Autowired
  private CursoDAO cursoDAO;
  
  public List<CursoDTO> getCursos()
  {
    List<CursoDTO> cursosDTO = getCursoDAO().listarTodos();
    return cursosDTO;
  }
  
  public void delCurso(Integer id)
  {
    getCursoDAO().eliminarCurso(id);
  }
  
  public CursoDTO getCurso(Integer id)
  {
    CursoDTO cursoDTO = getCursoDAO().obtenerCurso(id);
    return cursoDTO;
  }
  
  public void saveCurso(CursoDTO cursoDTO)
  {
    getCursoDAO().guardarCurso(cursoDTO);
  }
}
