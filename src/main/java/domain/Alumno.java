package domain;

import java.util.List;

public class Alumno {
  private String nombre;
  private String apellido;
  private Integer legajo;

  List<Materia> materiasAprobadas;
  public Alumno(String nombre, String apellido, Integer legajo) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.legajo = legajo;
  }
  public boolean aprobo(Materia materia) {
    return materiasAprobadas.contains(materia);
  }

  public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
    this.materiasAprobadas = materiasAprobadas;
  }
}
