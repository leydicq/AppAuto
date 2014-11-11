import java.util.Scanner;

public class movimientos {
    private Scanner teclado;
    public String comando;
    private String[] vect_pos_geo  = new String[100] ;
    private Integer[] vect_pos_num = new Integer[100];

    public void captura_cadena(){
        boolean rta2 = true;
        teclado=new Scanner(System.in);

        System.out.print("Digite los comandos: ");
        comando = teclado.next().toUpperCase();

        rta2 = validar_cadena();
        if (!rta2){
            System.out.println("Error en formato de comando");
            System.exit(0);
        }
    }

    private boolean validar_cadena(){
        String rta;
        validaciones obj_vali = new validaciones();

        rta = obj_vali.estructura(comando);

        if ( rta != "OK") {
                return false;
        }

        rta = obj_vali.sintaxis(comando);

        if ( rta != "OK") {
                return false;
        }

        return true;
    }

    public void cargar_movi(){
        String[] vector_temp;
        String pareja;

        int ultima_posicion = 0;	
        int separador;
        int i = 0;

        vector_temp = new String[100];
        comando = comando + ";";

        do {
                 separador = comando.indexOf(';',ultima_posicion);
                 pareja = comando.substring(ultima_posicion,separador);
                 ultima_posicion = separador + 1;
                 vector_temp[i] = pareja;
                 i++;
         }while(ultima_posicion < comando.length());		 


         separador = 0;

         for (int j=0; j< vector_temp.length; j++){
                 if (vector_temp[j] != null ) {
                         separador =  vector_temp[j].indexOf(',');
                         vect_pos_num[j] = Integer.parseInt(vector_temp[j].substring(0,separador)) ;
                         vect_pos_geo[j] = vector_temp[j].substring(separador + 1) ;
                }
         }
    }

    public void ejecutar_movi(cuadricula obj_cuadri){
        validaciones obj_valida = new validaciones();
        int pos_x_vehi = obj_cuadri.obj_vehiculo.ver_pos_x();
        int pos_y_vehi = obj_cuadri.obj_vehiculo.ver_pos_y();
        int[][] coor_movimiento = new int[1][2];
        int pos_final_x = 0;
        int pos_final_y = 0;

        for (int i = 0; i < vect_pos_num.length; i++ ){
            if(vect_pos_num[i] != null){
                if (obj_valida.puedo_moverme(obj_cuadri,vect_pos_num[i], vect_pos_geo[i])){
                    coor_movimiento       = coordenadas(vect_pos_num[i], vect_pos_geo[i]);
                    pos_x_vehi = pos_x_vehi + coor_movimiento[0][0];
                    pos_y_vehi = pos_y_vehi + coor_movimiento[0][1];
                    obj_cuadri.obj_vehiculo.moverse_a(pos_x_vehi, pos_y_vehi);

                    pos_final_x = obj_cuadri.obj_vehiculo.ver_pos_x();
                    pos_final_y = obj_cuadri.obj_vehiculo.ver_pos_y();
                    System.out.println("Coordenadas vehiculo= (" + pos_final_x + "),(" + pos_final_y + ")");
                }
                else{
                    System.out.println("Se ha detenido el avance por salir de los límites");
                    System.exit(0);
                }
            }	
        }
        //motrar resultado
        System.out.println("-------------------------------------------");
        pos_final_x = obj_cuadri.obj_vehiculo.ver_pos_x();
        pos_final_y = obj_cuadri.obj_vehiculo.ver_pos_y();
        System.out.println("Coordenadas finales del vehiculo= (" + pos_final_x + "),(" + pos_final_y + ")");
    }

    public int[][] coordenadas(int coor_num, String coor_geogra){
        int[][] coor_resultante  = new int[1][2];

        switch (coor_geogra.charAt(0)){
                case 'N' :
                        coor_resultante[0][0] = 0;
                        coor_resultante[0][1] = coor_num;
                        break;
                case 'S' :
                        coor_resultante[0][0] = 0;
                        coor_resultante[0][1] = -coor_num;
                        break;
                case 'E' :
                        coor_resultante[0][0] = coor_num;
                        coor_resultante[0][1] = 0;
                        break;
                case 'O' :
                        coor_resultante[0][0] = -coor_num;
                        coor_resultante[0][1] = 0;
                        break;
                default :
                        break;	
        }
        return coor_resultante; 
    }

}
