import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    static Estudiante estudiante = new Estudiante();
    static final int elementos = 5; 
    static ConEmple conEmple = new ConEmple();
    static ConEmple conEmples[] = new ConEmple[elementos];
    static Estudiante estudiantes[] = new Estudiante[elementos];
    static Control control = new Control();
    static Control controls[] = new Control[elementos];
    static Empleado empleado = new Empleado();
    static Empleado empleados[] = new Empleado[elementos];
    static int co2=2;
    static int op = 0, c = 0, opCrud, ne = 2, co = 2, ne2 = 2, pos, pos2, opIngre, opRegistro, opGestionEStu,opGestionEmple;
    static int actEstu, eliEstu, actuEmple, eliEmple,pos3;
    static String docu, docuE;
    static int cupomesa = 4, cupopc = 4, cupoi = 4;

    public static void main(String[] args) {
        estudiante.docum = "123";
        estudiante.nombre = "Rafael";
        estudiante.codigo = "090";
        estudiante.carrera = "Sistema";
        estudiante.jornada = "Mañana";
        estudiantes[0] = estudiante;
        control = new Control();
        control.f_ingreso = "17/05/2023";
        control.h_ingeso = "6:20 AM";
        control.h_salida = "7:00 AM";
        controls[0] = control;

        estudiante = new Estudiante();
        estudiante.docum = "155";
        estudiante.nombre = "Mary";
        estudiante.codigo = "070";
        estudiante.carrera = "Sistema";
        estudiante.jornada = "Mañana";
        estudiantes[1] = estudiante;
        control = new Control();
        control.f_ingreso = "17/05/2023";
        control.h_ingeso = "7:20 Am";
        control.h_salida = "8:00 AM";
        controls[1] = control;

        empleado = new Empleado();
        empleado.docuempleado = "154";
        empleado.nombreEmpleado = "Samuel";
        empleado.tipoEmpleado = "Docente";
        empleados[0] = empleado;
        conEmple = new ConEmple();
        conEmple.f_ingresoEmple = "17/05/2023";
        conEmple.h_ingesoEmple = "9:20 Am";
        conEmple.h_salidaEmple = "10:00 AM";
        conEmples[0] = conEmple;

        empleado = new Empleado();
        empleado.docuempleado = "156";
        empleado.nombreEmpleado = "Luis";
        empleado.tipoEmpleado = "Administrador";
        empleados[1] = empleado;
        conEmple = new ConEmple();
        conEmple.f_ingresoEmple = "17/05/2023";
        conEmple.h_ingesoEmple = "10:20 Am";
        conEmple.h_salidaEmple = "11:00 AM";
        conEmples[1] = conEmple;

        do {
            LimpiarPantalla();
            menuPrincipal();
            System.out.println("Digite una opción: ");
            opCrud = sc.nextInt();
            pausa();

            switch (opCrud) {
                case 1:
                    menuRegistro();
                    break;
                case 2:
                    menuIngreso();
                    break;
                case 3:
                    cupO();
                    break;
                case 4:
                    lista();
                    break;
                case 5:
                    listaEmpleados();
                    break;
            }
        } while (opCrud > 0 && opCrud < 6);
        System.out.println(" ¡Gracias por usar el Software! ");
    }

    public static void menuIngreso() {
        System.out.println("----------------------------");
        System.out.println("----- Tipo de ingreso -----");
        System.out.println("----------------------------");
        System.out.println("1. Estudiante");
        System.out.println("2. Empleado");
        System.out.println("3. Volver al inicio\t\n");
        System.out.println("----- Digite una opción -----");
        opIngre = sc.nextInt();

        switch (opIngre) {
            case 1:
                System.out.println("-------------------------------");
                System.out.println("----- Ingreso estudiante -----");
                System.out.println("-------------------------------");
                System.out.println("Digite su documento: ");
                docu = sc.next();
                pos = buscarDocumento(docu);
                pausa();
                if (pos == -1) {
                    System.out.println("Este documento no existe");
                    pausa();
                } else {
                    gestionEstudianr();
                }
                break;
            case 2:
                System.out.println("----------------------------");
                System.out.println("----- Ingreso empleado -----");
                System.out.println("----------------------------");
                System.out.println("Digite su documento: ");
                docuE = sc.next();
                pos2 = buscarDocumentoEmpleado(docuE);
                pausa();
                if (pos2 == -1) {
                    System.out.println("Este documento no existe");
                    pausa();
                } else {
                    gestionEmpleado();
                }
                break;
            default:
                System.out.println("Esta opcion no existe");
                break;
            case 3:
                System.out.println("Volver al inicio");
                break;
        }
    }

    public static void menuRegistro() {
        System.out.println("----------------------------");
        System.out.println("----- Tipo de registro -----");
        System.out.println("----------------------------");
        System.out.println("1. Estudiante");
        System.out.println("2. Empleado");
        System.out.println("3. Volver al inicio\t\n");
        System.out.println("----- Digite una opción: -----");
        opRegistro = sc.nextInt();

        switch (opRegistro) {
            case 1:
                registro();
                break;
            case 2:
                registroEmpleado();
                pausa();
                break;
        }
    }

    public static void menuPrincipal() {
        System.out.println("----------------- ¡Bienvenido! -----------------");
        System.out.println("--------------------- Menú ---------------------");
        System.out.println("------------------------------------------------\t\n");
        System.out.println("----- 1. Registrarse ---------------------------");
        System.out.println("----- 2. Inicio de sesion ----------------------");
        System.out.println("----- 3. Ver cupos -----------------------------");
        System.out.println("------4. Lista de estudiante en la biblioteca---");
        System.out.println("------5. Lista de empleados en la biblioteca----");
        System.out.println("----- 6. Salir ---------------------------------\t\n");
    }

    public static void LimpiarPantalla() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process straProcess = pb.inheritIO().start();
            straProcess.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void pausa() {
        sc.nextLine();
        System.out.println("\t\nPresione enter para continuar...");
        sc.nextLine();
    }

    public static int buscarDocumento(String docu) {
        int posicion = -1;
        for (int i = 0; i < ne; i++) {
            if (estudiantes[i].docum.equals(docu)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void registro() { 
        if(ne<=4){
        estudiante = new Estudiante();
        System.out.println("--------------------");
        System.out.println("----- Registro -----");
        System.out.println("--------------------"); 
        System.out.println("Digite su documento para saber si ya esta registrado: ");
        docu = sc.next();
        pos = buscarDocumento(docu);
        pausa();
        if (pos==-1) {
        estudiante.docum = docu;
        System.out.println("\t\nDigite su nombre completo:");
        estudiante.nombre = sc.next();
        System.out.println("\t\nDigite su codigo estudiantil:");
        estudiante.codigo = sc.next();
        System.out.println("\t\nDigite su programa academico:");
        estudiante.carrera = sc.next();
        System.out.println("\t\nDigite su jornada: ");
        estudiante.jornada = sc.next();
        System.out.println("\t\n¡El registro ha sido completado!");
        System.out.println("Ya puedes iniciar sesión");
        estudiantes[ne] = estudiante;
        ne = ne + 1;
        pausa();
        } else { 
            if(pos>-1){ 
          System.out.println("Este documento ya existe");
          pausa();
            }
        }  
        }else{ 
            System.out.println("Vector lleno");
        }

        }

    public static void controlBiblioteca() {
        control = new Control();
        System.out.println("-------------------------------");
        System.out.println("----- Control de ingreso -----");
        System.out.println("-------------------------------");
        System.out.println("\t\nDigite la fecha: ");
        control.f_ingreso = sc.next();
        System.out.println("\t\nDigite la hora de ingreso: ");
        control.h_ingeso = sc.next();
        System.out.println("\t\nDigite a la hora que piensa salir: ");
        control.h_salida = sc.next();
        System.out.println("\t\nSeleccione un puesto en la biblioteca");
        cupo1();
        System.out.println("\t\nDisfrute su estadia");
        pausa();
        controls[co] = control;
        co = co + 1;
    }

    public static void cupO() {
        System.out.println("---------------------------------------");
        System.out.println("------ Lista de cupos disponibles ------");
        System.out.println("---------------------------------------");
        System.out.println("Mesas con pc: " + cupopc + "/5");
        System.out.println("Mesa grupal:  " + cupomesa + "/5");
        System.out.println("Mesas individual: " + cupoi + "/5");
        pausa();
    }

    public static void cupo1() {
        System.out.println("------------------");
        System.out.println("------ Cupos ------ ");
        System.out.println("-------------------");
        System.out.println("1. Mesa grupal");
        System.out.println("2.Mesa individual");
        System.out.println("3.Mesa con pc");
        System.out.println("\t\nDigite una opcion");
        op = sc.nextInt();

        switch (op) {
            case 1: 
            if(cupomesa==0){
                System.out.println("No hay cupo");
            }else{
                System.out.println("Puesto seleccionado");
                cupomesa = cupomesa - 1;
            }
                break;
            case 2:
            if(cupoi==0){
                System.out.println("No hay cupo");
            }else{
                System.out.println("Puesto seleccionado");
                cupoi = cupoi -1;
            }
                break;
            case 3:
            if(cupopc==0){
                System.out.println("No hay cupo");
            }else{
                System.out.println("Puesto seleccionado");
                cupopc--;
            }
                break;
            default:
                System.out.println("NO existe esta opcion");
                break;
        }
    }

    public static void gestionEstudianr() {
        do {
            System.out.println("**********");
            System.out.println("--Perfil--");
            System.out.println("**********");
            System.out.println("1.Ingreso a la biblioteca");
            System.out.println("2.Alquilar/ver libros");
            System.out.println("3.Ver informacion del perfil");
            System.out.println("4.Modificar perfil");
            System.out.println("5.Eliminar perfil");
            System.out.println("6.cerrar sesion");
            System.out.println("Digite una opción");
            opGestionEStu = sc.nextInt();

            switch (opGestionEStu) {
                case 1:
                    controlBiblioteca();
                    break;
                case 2:
                    System.out.println("Opción no disponible");
                    pausa();
                    break;
                case 3:
                    mostraInfoEstudiante();
                    break;
                case 4:
                    actuEstudiante();
                    break;
                case 5:
                    eliminarEstudiante();
                    break;

                default:
                    break;
            }

        } while (opGestionEStu > 0 && opGestionEStu < 5);
    }

    public static void mostraInfoEstudiante() {
        System.out.println("**************************");
        System.out.println("Informacion del estudiante");
        System.out.println("**************************");
        System.out.println("Nombre: " + estudiantes[pos].nombre);
        System.out.println("Documento: " + estudiantes[pos].docum);
        System.out.println("Codigo estudiantil: " + estudiantes[pos].codigo);
        System.out.println("Programa academico: " + estudiantes[pos].carrera);
        System.out.println("Jornada: " + estudiantes[pos].jornada);
        pausa();
    }

    public static void actuEstudiante() {
        do {
            System.out.println("----------------");
            System.out.println("Cambiar datos");
            System.out.println("----------------");
            System.out.println("1.Cambiar nombre");
            System.out.println("2.Cambiar documento");
            System.out.println("3.Cambiar codigo estudiantil");
            System.out.println("4.Cambiar programa academico");
            System.out.println("5.Cambiar jornada");
            System.out.println("6.Salir");
            System.out.println("Digite una opción");
            actEstu = sc.nextInt();

            switch (actEstu) {
                case 1:
                    System.out.println("----------------");
                    System.out.println("Cambio de nombre");
                    System.out.println("----------------");
                    System.out.println("Digite su nuevo nombre completo");
                    estudiantes[pos].nombre = sc.next();
                    System.out.println("Nombre actualizado");
                    pausa();
                    break;
                case 2:
                    System.out.println("----------------");
                    System.out.println("Cambio de documento");
                    System.out.println("----------------");
                    System.out.println("Digite su nuevo documento");
                    estudiantes[pos].docum = sc.next();
                    System.out.println("Documento actualizado");
                    pausa();
                    break;
                case 3:
                    System.out.println("----------------");
                    System.out.println("Cambio de codigo estudiantil");
                    System.out.println("----------------");
                    System.out.println("Digite su nuevo codigo estudiantil");
                    estudiantes[pos].codigo = sc.next();
                    System.out.println("Codigo estudiantil actualizado");
                    pausa();
                    break;
                case 4:
                    System.out.println("----------------");
                    System.out.println("Cambio de programa academico");
                    System.out.println("----------------");
                    System.out.println("Digite su nuevo programa academico");
                    estudiantes[pos].carrera = sc.next();
                    System.out.println("Programa academico actualizado");
                    pausa();
                    break;
                case 5:
                    System.out.println("----------------");
                    System.out.println("Cambio de jornada");
                    System.out.println("----------------");
                    System.out.println("Digite su nuevo jornada");
                    estudiantes[pos].jornada = sc.next();
                    System.out.println("Jornada actualizado");
                    pausa();
                    break;
                default:
                    break;
            }
        } while (actEstu > 0 && actEstu < 5);
    }

    public static void eliminarEstudiante() {
        do {
            System.out.println("---------------------");
            System.out.println("Eliminacion de perfil");
            System.out.println("---------------------");
            System.out.println("¿Esta seguro que quiere eliminar el perfil?: 1)si  2)no");
            eliEstu = sc.nextInt();

            if (eliEstu == 1) {
                for (int i = 0; i <= ne - 1; i++) {
                    estudiantes[i] = estudiantes[i + 1];
                }
                ne = ne - 1;
                System.out.println("Registro eliminado");
            }
            pausa();
        } while (eliEstu > 0 && eliEstu < 2);
    }

    public static void lista() {
        System.out.println("-------------------------------------");
        System.out.println("Lista de estudiantes en la biblioteca");
        System.out.println("-------------------------------------");
        System.out.println(
                " Documento     Nombre     Codigo estudiantil     Programa     Jornada     Hora de entrada     ");
        for (int i = 0; i < ne; i++) {
            System.out.println(
                    estudiantes[i].docum + "\t\t" + estudiantes[i].nombre + "\t\t" + estudiantes[i].codigo + "\t\t"
                            + estudiantes[i].carrera + "\t\t" + estudiantes[i].jornada + "\t\t" + controls[i].h_ingeso);
        }
        pausa();
    }

    public static void registroEmpleado() {
        empleado = new Empleado();
        System.out.println("--------------------");
        System.out.println("----- Registro -----");
        System.out.println("--------------------"); 
        if(ne2<=4){
     System.out.println("Digite su documento para saber si ya esta registrado: ");
        docu = sc.next();
        pos = buscarDocumentoEmpleado(docu);
        if (pos==-1) {
        empleado.docuempleado = docu;
        System.out.println("\t\nDigite su nombre completo:");
        empleado.nombreEmpleado = sc.next();
        System.out.println("\t\nDigite su tipo de empleado:");
        empleado.tipoEmpleado = sc.next();
        System.out.println("\t\n¡El registro ha sido completado!");
        System.out.println("Ya puedes iniciar sesión");
        empleados[ne2] = empleado;
        ne2 = ne2 + 1;
        } else { 
            if(pos>-1){ 
          System.out.println("Este documento ya existe");
            }
        }        
        }else{
            System.out.println("Vector lleno");
        }
 
        }

    public static int buscarDocumentoEmpleado(String docuE) {
        int posicion = -1;
        for (int i = 0; i < ne2; i++) {
            if (empleados[i].docuempleado.equals(docuE)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void gestionEmpleado() {
        do {
            System.out.println("**********************");
            System.out.println("--------Perfil--------");
            System.out.println("**********************");
            System.out.println("1. Control biblioteca");
            System.out.println("2. Alquilar/ver libros");
            System.out.println("3. Ver informacion del perfil");
            System.out.println("4. Modificar perfil");
            System.out.println("5. Eliminar perfil");
            System.out.println("6. cerrar sesion");
            System.out.println("Digite una opción: ");
            opGestionEmple = sc.nextInt();

            switch (opGestionEmple) {
                case 1:
                    controlBibliotecaEmpel();
                    break;
                case 2:
                    System.out.println("Opción no disponible");
                    pausa();
                    break;
                case 3:
                    mostraInfoEmpleado();
                    break;
                case 4:
                    actuEmpleado();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                default:
                    break;
            }
        } while (opGestionEmple > 0 && opGestionEmple < 5);
    }

    public static void mostraInfoEmpleado() {
        System.out.println("************************");
        System.out.println("Informacion del empleado");
        System.out.println("************************");
        System.out.println("Nombre: " + empleados[pos2].nombreEmpleado);
        System.out.println("Documento: " + empleados[pos2].docuempleado);
        System.out.println("Tipo de empleado: " + empleados[pos2].tipoEmpleado);
        pausa();
    }

    public static void actuEmpleado() {
        do {
            System.out.println("----------------");
            System.out.println("Cambiar datos");
            System.out.println("----------------");
            System.out.println("1.Cambiar nombre");
            System.out.println("2.Cambiar documento");
            System.out.println("3.Cambiar tipo de empleado");
            System.out.println("4.Salir");
            System.out.println("Digite una opción");
            actuEmple = sc.nextInt();

            switch (actuEmple) {
                case 1:
                    System.out.println("----------------");
                    System.out.println("Cambio de nombre");
                    System.out.println("----------------");
                    System.out.println("Digite su nuevo nombre completo");
                    empleados[pos2].nombreEmpleado = sc.next();
                    System.out.println("Nombre actualizado");
                    pausa();
                    break;
                case 2:
                    System.out.println("----------------");
                    System.out.println("Cambio de documento");
                    System.out.println("----------------");
                    System.out.println("Digite su nuevo documento");
                    empleados[pos2].docuempleado = sc.next();
                    System.out.println("Documento actualizado");
                    pausa();
                    break;
                case 3:
                    System.out.println("------------------------");
                    System.out.println("Cambio de tipo de empleo");
                    System.out.println("------------------------");
                    System.out.println("Digite su nuevo tipo de empleo");
                    empleados[pos2].tipoEmpleado = sc.next();
                    System.out.println("Tipo de empleado actualizado");
                    pausa();
                    break;
            }
        } while (actEstu > 0 && actEstu < 4);
    }

    public static void eliminarEmpleado() {
        do {
            System.out.println("---------------------");
            System.out.println("Eliminacion de perfil");
            System.out.println("---------------------");
            System.out.println("¿Esta seguro que quiere eliminar el perfil?: 1)si  2)no");
            eliEmple = sc.nextInt();

            if (eliEmple == 1) {
                for (int i = 0; i <= ne2 - 1; i++) {
                    empleados[i] = empleados[i + 1];
                }
                ne2 = ne2 - 1;
                System.out.println("Registro eliminado");
            }
            pausa();
        } while (eliEstu > 0 && eliEstu < 2);
    }

    public static void listaEmpleados() {
        System.out.println("-------------------------------------");
        System.out.println("Lista de empleados en la biblioteca");
        System.out.println("-------------------------------------");
        System.out.println(" Documento     Nombre     tipo de empleado     Hora de entrada     ");
        for (int i = 0; i < ne2; i++) {
            System.out.println(empleados[i].docuempleado + "\t\t" + empleados[i].nombreEmpleado + "\t\t"
                    + empleados[i].tipoEmpleado + "\t\t" + conEmples[i].h_ingesoEmple);
        }
        pausa();
    } 

    public static void controlBibliotecaEmpel() {
        conEmple = new ConEmple();
        System.out.println("-------------------------------");
        System.out.println("----- Control de ingreso -----");
        System.out.println("-------------------------------");
        System.out.println("\t\nDigite la fecha: ");
        conEmple.f_ingresoEmple = sc.next();
        System.out.println("\t\nDigite la hora de ingreso: ");
        conEmple.h_ingesoEmple = sc.next();
        System.out.println("\t\nDigite a la hora que piensa salir: ");
        conEmple.h_salidaEmple = sc.next();
        System.out.println("\t\nSeleccione un puesto en la biblioteca");
        cupo1();
        System.out.println("\t\nDisfrute su estadia");
        pausa();
        conEmples[co2] = conEmple;
        co2 = co2 + 1;
    }
}