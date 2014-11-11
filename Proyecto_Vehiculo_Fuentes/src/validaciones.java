
public class validaciones {
    private int vector_ascii[] = {44,48,49,50,51,52,53,54,55,56,57,59,69,78,79,83}; 

    public boolean valida_entrada(String cadena){
        
        for(int k=0; k<cadena.length(); k++){
            int cod_ascii = cadena.codePointAt(k);
            if(cod_ascii < 48 || cod_ascii > 57){
                return false;
            }
        }
        return true;
    }
    
    
    public String estructura(String comando){

        boolean band2 = false; 

        for (int i = 0; i < comando.length(); i++){
                band2 = false; 
                for(int j=0; j< vector_ascii.length; j++){
                        if(comando.codePointAt(i) == vector_ascii[j] ){
                                band2 = true; 
                        }
                }
                if(!band2){
                        return "Error";
                }		
        }
        return "OK";
    }

    public String sintaxis(String comando){
        int actual = 0;

        int anterior = comando.codePointAt(0);

        if( anterior < 48 || anterior > 57  ){  //Primer caracter NO es numero
            return "Error";
        }

        for (int i = 1; i < comando.length(); i++){
            anterior = comando.codePointAt(i-1);
            actual = comando.codePointAt(i);
            if(anterior >= 48 && anterior <= 57){                                             //Caracter anterior es numero
                if((actual < 48 || actual > 57) && actual != 44){                             //Caracter actual es NO num y diferente de coma ->Error
                    return "Error";
                }
            }else if(anterior == 44 ){                                                        //Caracer anterior es coma
                if(actual != 69 && actual != 78 && actual != 79 && actual != 83  ){           //Caracter actual NO es N, S, E, O   ->Error
                    return "Error";
                }
            }else if (anterior == 69 || anterior == 78 || anterior == 79 || anterior == 83 ){ //Caracter anterior es N, S, E, O
                if(actual != 59 ){                                                            //Caracter actual NO es punto y coma  ->Error                               
                    return "Error";
                }
            }else if (anterior == 59){                                                         //Caracer anterior es punto y coma
                if(actual < 48 || actual > 57 ){                                               //Caracter Actual NO es numero ->Error
                    return "Error";
                }
            }
        }
        return "OK";	
    }

    public boolean puedo_moverme(cuadricula obj_cuadricula, Integer pos_num_c, String pos_geo_c){
        int pos_act_x =0;
        int pos_act_y =0;
        int dim_matriz[][] = obj_cuadricula.mat;
        int[][] coor_resultante  = new int[1][2];

        movimientos obj_movi = new movimientos();

        pos_act_x = obj_cuadricula.obj_vehiculo.ver_pos_x() ;
        pos_act_y = obj_cuadricula.obj_vehiculo.ver_pos_y() ;

        coor_resultante = obj_movi.coordenadas(pos_num_c, pos_geo_c);

        pos_act_x = pos_act_x + coor_resultante[0][0];
        pos_act_y = pos_act_y + coor_resultante[0][1];

        if(pos_act_x > dim_matriz[0][0]){
            return false;
        }else if(pos_act_y > dim_matriz[0][1]){
            return false;
        }
        else if (pos_act_x < 0 || pos_act_y < 0){
            return false;
        }
        return true;
    }
	
}
