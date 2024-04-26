package edu.pe.cibertec.controller;

import edu.pe.cibertec.dto.CursoDTO;
import edu.pe.cibertec.service.CursoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Getter
@Setter
@Controller
public class CursoController
{
  @Autowired
  private CursoService cursoService;

  @RequestMapping("/cursosList")
  public ModelAndView cursosList()
  {
    List<CursoDTO> cursos = getCursoService().getCursos();
    return new ModelAndView("cursos").
        addObject("cursosList", cursos).
        addObject("cursoDTO", new CursoDTO());
  }

  @RequestMapping("/delcurso")
  public ModelAndView delcurso(@RequestParam(value = "id") Integer id)
  {
    getCursoService().delCurso(id);
    return cursosList();
  }
  
  @RequestMapping("/editcurso")
  public ModelAndView editcurso(@RequestParam(value = "id") Integer id)
  {
    ModelAndView view = cursosList();
    CursoDTO cursoDTO = getCursoService().getCurso(id);
    view.getModelMap().remove("cursoDTO");
    view.getModelMap().put("cursoDTO", cursoDTO);
    return view;
  }
  
  @RequestMapping("/savecurso")
  public ModelAndView savecurso(CursoDTO cursoDTO)
  {
      getCursoService().saveCurso(cursoDTO);
      return cursosList();
  }
  
  @RequestMapping("/newcurso")
  public ModelAndView newcurso()
  {
    return cursosList();
  }
}
