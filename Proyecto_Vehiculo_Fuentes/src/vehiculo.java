
public class vehiculo {
    private Integer pos_x; 
    private Integer pos_y ;

    public void moverse_a(int entra_x,int entra_y){
            pos_x = entra_x;
            pos_y = entra_y;
    }

    public int ver_pos_x(){
            int v_pos_x =0;
            v_pos_x = pos_x.intValue();
            return v_pos_x;
    }

    public int ver_pos_y(){
            int v_pos_y =0;
            v_pos_y = pos_y.intValue();
            return v_pos_y;
    }
}
