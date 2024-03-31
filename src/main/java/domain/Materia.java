package domain;

import java.util.List;

public class Materia {
  private String nombre;
  private Integer codigo;

  List<Materia> materiasCorrelativas;
  public Materia(String nombre, Integer codigo, List<Materia> materiasCorrelativas) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.materiasCorrelativas = materiasCorrelativas;
  }

  public List<Materia> getMateriasCorrelativas() {
    return materiasCorrelativas;
  }
}
