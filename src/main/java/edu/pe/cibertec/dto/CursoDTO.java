package edu.pe.cibertec.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoDTO
{
    private Integer id;
    private Integer  alumnosact;
    private Integer alumnosmin;
    private Integer estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechainicio;
    private String  nomcurso;
}