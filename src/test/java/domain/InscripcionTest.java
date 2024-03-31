package domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class InscripcionTest {

  @Test
  public void testInscripcionAMateriaSinCorrelativas() {
    Alumno alumno = new Alumno("Juan", "Perez", 1234);
    List<Materia>materias = new ArrayList<>();
    materias.add(new Materia("Algoritmos", 1, null));
    Inscripcion inscripcion = new Inscripcion(alumno, materias);
    assertTrue(inscripcion.aprobada());
  }
  @Test
  public void testInscripcionCorrelativaNoAprobada() {

    Alumno alumno = new Alumno("Pepe", "Rodriguez", 123);
    List<Materia> materiasAprobadas = new ArrayList<>();
    materiasAprobadas.add(new Materia("Materia1", 101, null));
    alumno.setMateriasAprobadas(materiasAprobadas);
    List<Materia> materias = new ArrayList<>();
    List<Materia> correlativas = new ArrayList<>();
    correlativas.add(new Materia("Materia1", 101, null)); // La correlativa está aprobada
    correlativas.add(new Materia("Materia2", 102, null)); // La correlativa no está aprobada
    materias.add(new Materia("Materia3", 103, correlativas));
    Inscripcion inscripcion = new Inscripcion(alumno, materias);
    assertFalse(inscripcion.aprobada());
  }

  @Test
  public void testAprobada_TodasCorrelativasAprobadas() {
    Alumno alumno = new Alumno("Juan", "Perez", 123);
    List<Materia> materiasAprobadas = new ArrayList<>();
    materiasAprobadas.add(new Materia("Materia1", 101, null));
    materiasAprobadas.add(new Materia("Materia2", 102, null));
    alumno.setMateriasAprobadas(materiasAprobadas);
    List<Materia> materias = new ArrayList<>();
    materias.add(new Materia("Materia3", 103, materiasAprobadas));
    materias.add(new Materia("Materia4", 104, materiasAprobadas));
    Inscripcion inscripcion = new Inscripcion(alumno, materias);
    assertTrue(inscripcion.aprobada());
  }
}
