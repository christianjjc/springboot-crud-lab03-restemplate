package edu.pe.cibertec.dao;

import edu.pe.cibertec.dto.CursoDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Repository
public class CursoDAO {

    private RestTemplate restTemplate;
    @Value("${uri.rest.cursos}")
    private String urlSevidor;

    public CursoDAO(){
        restTemplate = new RestTemplate();
    }

    public List<CursoDTO> listarTodos(){
        List<CursoDTO> cursoDTOList;
        CursoDTO[] lista = getRestTemplate().getForObject(getUrlSevidor(), CursoDTO[].class);
        if(lista == null){
            cursoDTOList = null;
        }else{
            cursoDTOList = Arrays.asList(lista);
        }
        return cursoDTOList;
    }

    public CursoDTO obtenerCurso(Integer id){
        return getRestTemplate().getForObject(getUrlSevidor()+"/"+id, CursoDTO.class);
    }

    public CursoDTO guardarCurso(CursoDTO cursoDTO){
        // Usar getBody()
        CursoDTO result = getRestTemplate().postForEntity(getUrlSevidor(), cursoDTO, CursoDTO.class).getBody();
        return result;
    }

    public void eliminarCurso(Integer id){
        getRestTemplate().delete(getUrlSevidor()+"/"+id);
    }



}
