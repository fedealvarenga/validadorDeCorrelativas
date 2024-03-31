package domain;

import java.util.List;

public class Inscripcion {
  private Alumno alumno;


  private List<Materia> materias;

  public Inscripcion(Alumno alumno, List<Materia> materias) {
    this.alumno = alumno;
    this.materias = materias;

  }

  public boolean aprobada() {
    for (Materia materia : materias) {
      if (materia.getMateriasCorrelativas() != null) {
        for (Materia correlativa : materia.getMateriasCorrelativas()) {
          if (!alumno.aprobo(correlativa)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /*
  otra opcion
  public boolean aprobada() {
    return materias.stream()
                  .flatMap(materia -> materia.getMateriasCorrelativas().stream())
                  .allMatch(alumno::aprobo);
}

 */
}
