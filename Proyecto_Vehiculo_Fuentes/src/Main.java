
public class Main {
		
    public static void main(String[] parametro) {
        cuadricula obj_cuadricula  = new cuadricula();
        movimientos obj_movimientos = new movimientos();
        obj_cuadricula.crear_matriz();
        obj_movimientos.captura_cadena();
        obj_movimientos.cargar_movi();
        obj_movimientos.ejecutar_movi(obj_cuadricula);
    }

}
