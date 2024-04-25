package edu.pe.cibertec.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoDTO
{
    private Integer id;
    private String  alumnosact;
    private Integer alumnosmin;
    private Integer estado;
    private Date    fechainicio;
    private String  nomcurso;
}