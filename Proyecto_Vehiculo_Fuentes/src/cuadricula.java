import java.util.Scanner;

public class cuadricula {
	public  int[][] mat = new int[1][2];
	private Scanner teclado;
	public vehiculo obj_vehiculo = new vehiculo();
	
	public void crear_matriz(){
            String filas; 
            String columnas;
            validaciones obj_vali = new validaciones();
            teclado=new Scanner(System.in);
            System.out.print("Digite la cantidad Filas: ");
            filas = teclado.nextLine();
            System.out.print("Digite la cantidad Filas: "+filas);
            if(!obj_vali.valida_entrada(filas)){
                System.out.println("Error al introducir la cantidad Filas");
                System.exit(0);
            }
            System.out.print("Digite la cantidad Columnas: ");
            columnas = teclado.nextLine();
            if(!obj_vali.valida_entrada(columnas) || columnas == null){
                System.out.println("Error al introducir la cantidad Columnas");
                System.exit(0);
            }
            int fil = Integer.parseInt(filas);
            int col = Integer.parseInt(columnas);
            mat[0][0] = fil;
            mat[0][1] = col;
            iniciar(obj_vehiculo);
	}
	
	public void iniciar(vehiculo vehiculo_inicia){
                        vehiculo_inicia.moverse_a(0,0);
		
	}
}
