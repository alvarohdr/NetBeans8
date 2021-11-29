import java.util.*;

public class Main {
    static int contador = 0;
    public static void mostrarMatriz(int arr[][]){
        contador++;
        System.out.println("Solución " + contador + ":");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static boolean validarArray(int array[][], int i, int j){
        boolean posicionValida = true;
        for(int k = 0; k < array.length; k++){
            if(array[k][j] == 1 && k != i){
                posicionValida = false;
            }
        }
        if(i > 0 && j > 0){
            for(int k = 1; i-k >= 0 && j-k >= 0; k++){
                if(array[i-k][j-k] == 1){
                    posicionValida = false;
                }
            }
        }
        if(i > 0 && j < array.length){
            for(int k = 1; i-k >= 0 && j+k < array.length; k++){
                if(array[i-k][j+k] == 1){
                    posicionValida = false;
                }
            }
        }
        
        return posicionValida;
    }
    
    public static void nDamas(int array[][], int cantidadDamas){
        if(cantidadDamas == array.length){
            mostrarMatriz(array);
        }else{
            for(int j = 0; j < array.length; j++){
                if(array[cantidadDamas][j] == 0){
                    array[cantidadDamas][j] = 1;
                    if(validarArray(array, cantidadDamas, j)){
                        nDamas(array, cantidadDamas + 1);
                    }
                    array[cantidadDamas][j] = 0;
                }
                
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // Your code here!
        int array[][] = new int[8][8];
        nDamas(array, 0);
        
    }
}
