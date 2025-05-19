📦 model/ → Clases de datos (POJOs)
✅ Estudiante.java
Responsabilidad: representar los datos de un estudiante.
Atributos:
•	int id (autogenerado)
•	String nombre
•	double nota
•	int asistencia
Métodos:
•	Getters/setters
•	Constructor
•	boolean esAprobado() → nota ≥ 6 && asistencia ≥ 75
________________________________________
✅ Curso.java
Responsabilidad: representar los datos de un curso.
Atributos:
•	int id (autogenerado)
•	String nombre
•	int cupoMaximo
•	List<Integer> idsEstudiantes (opcional: solo IDs para simplificar)
Métodos:
•	Getters/setters
•	Constructor
•	boolean hayCupoDisponible(int inscritos)
________________________________________
✅ Inscripcion.java (opcional)
Responsabilidad: representar la relación Estudiante-Curso.
Atributos:
•	int idEstudiante
•	int idCurso
•	LocalDate fecha
Métodos:
•	Getters/setters
🧠 Solo es necesaria si querés una capa extra entre estudiantes y cursos. Si no, podés manejarlo directamente en los gestores.
________________________________________
📦 service/ → Lógica de negocio
✅ GestorEstudiantes.java
Responsabilidad: manejar operaciones sobre estudiantes.
Métodos:
•	agregar(Estudiante)
•	eliminarPorId(int)
•	buscarPorNombre(String)
•	listarTodos()
•	listarAprobados()
•	actualizarNota(int id, double nota)
•	actualizarAsistencia(int id, int asistencia)
________________________________________
✅ GestorCursos.java
Responsabilidad: manejar operaciones sobre cursos.
Métodos:
•	agregar(Curso)
•	eliminarPorId(int)
•	buscarPorNombre(String)
•	listarTodos()
•	verCupoDisponible(int idCurso)
•	verEstudiantesInscritos(int idCurso)
________________________________________
✅ GestorInscripciones.java
Responsabilidad: vincular estudiantes y cursos.
Métodos:
•	inscribir(int idEstudiante, int idCurso)
•	cancelarInscripcion(int idEstudiante, int idCurso)
•	verCursosDeEstudiante(int idEstudiante)
•	verEstudiantesDeCurso(int idCurso)
________________________________________
📦 persistence/ → Guardar y leer archivos JSON
✅ EstudianteJsonRepository.java
Métodos:
•	guardarLista(List<Estudiante>)
•	List<Estudiante> cargarLista()
Utiliza Jackson o Gson.
________________________________________
✅ CursoJsonRepository.java
Igual que EstudianteJsonRepository, pero para cursos.
________________________________________
📦 menu/ → Interfaz por consola
✅ MenuPrincipal.java
Responsabilidad: interacción con el usuario.
Métodos:
•	main(String[] args)
•	Muestra el menú
•	Lee entradas
•	Llama a métodos del servicio
________________________________________
📦 utils/ → Funciones reutilizables
✅ ValidadorDatos.java
Métodos estáticos:
•	boolean esNombreValido(String)
•	boolean esNotaValida(double)
•	boolean esAsistenciaValida(int)
•	boolean esNumero(String)

