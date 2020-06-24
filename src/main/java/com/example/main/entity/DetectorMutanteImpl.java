package com.example.main.entity;

import com.example.main.exception.InputValidationException;

public class DetectorMutanteImpl implements DetectorMutante {

	String prueba; 
	String dna2;  
	 private  char[][] tablero;
	  private char[] ejemplo ;
	  boolean Mutante = true;
	  boolean isMutant = true;
	  
	public DetectorMutanteImpl(String prueba, String dna2, char[][] tablero, char[] ejemplo, boolean mutante,
			boolean isMutant) {
		super();
		this.prueba = prueba;
		this.dna2 = dna2;
		this.tablero = tablero;
		this.ejemplo = ejemplo;
		Mutante = mutante;
		this.isMutant = isMutant;
	}

	public DetectorMutanteImpl() {
		super();
	}

	public String getPrueba() {
		return prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}

	public String getDna2() {
		return dna2;
	}

	public void setDna2(String dna2) {
		this.dna2 = dna2;
	}

	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	public char[] getEjemplo() {
		return ejemplo;
	}

	public void setEjemplo(char[] ejemplo) {
		this.ejemplo = ejemplo;
	}

	public boolean isMutante() {
		return Mutante;
	}

	public void setMutante(boolean mutante) {
		Mutante = mutante;
	}

		

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

	public boolean isMutant(String[] dna) throws InputValidationException{
		prueba =dna[0];
		dna2=dna[0]+dna[1]+dna[2]+dna[3]+dna[4]+dna[5];
		int n=prueba.length();
		this.tablero= new char[n][n];
		int cuenta=0;
		int inverso=0;

			//rellenamos la matriz con los adn
		System.out.println(dna2);
		        rellenarMatriz(tablero,dna);
			
			//muestro el tablero
		        
			mostrarMatriz(tablero);
		    
		        // compara la fila 
		        
		        cuenta=cuenta+coincidenciaLinea(tablero);
		           
		        System.out.println("la coincidencia en linea es   "+cuenta);
		        
		        // compara columna
		        inverso=coincidenciaColumna(tablero);
		        cuenta=cuenta+inverso;
		        System.out.println("la coincidencia en columna es  "+inverso);

		        // compara diagonal principal
		        
		        inverso=coincidenciaDiagonal(tablero);
		        cuenta=cuenta+inverso;
		        System.out.println("la coincidencia diagonal principal es   "+inverso);
		        
		        // compara diagonal inversa
		        
		        inverso=coincidenciaInversa(tablero);
		        cuenta=cuenta+inverso;
		        System.out.println("la coincidencia diagonal inversa es   "+ inverso);
		        
		        if(cuenta >1 )
		        {
		            Mutante = true;
		        }
		        else
		        {
		            Mutante = false;
		        }
		        return Mutante;
	}
	public static void mostrarMatriz(char[][] matriz) {
	      for (char[] matriz1 : matriz) {
	          for (int j = 0; j < matriz[0].length; j++) {
	              System.out.print(matriz1[j] + " ");
	          }
	          System.out.println("");
	      }
	 
	    }

	    private void rellenarMatriz(char[][] tablero, String[] dna) {
	        
	          for (int i = 0; i < tablero.length; i++) {
	            for(int j=0;j< tablero.length;j++){
	                      
	                    prueba =dna[i];
	                    ;
	                    ejemplo =prueba.toCharArray();
	                    tablero[i][j]=ejemplo[j];
	                    
	        } 
	              
	    }
	 
	    }
	    public static int coincidenciaLinea(char[][] matriz) {
	        int contador=0;
	        char simbolo;
	        int  coincidencia=0;
	      for (char[] matriz1 : matriz) {
	          for (int j = 0; j<(matriz.length)-2; j++) {
	              //Reiniciamos la coincidencia
	              //Cogemos el simbolo de la fila
	              simbolo = matriz1[j];
	              //sino coincide ya no habra semimutante  en esta fila
	              if (simbolo == matriz1[j+1] && simbolo == matriz1[j+2] && simbolo == matriz1[j+3]) {
	                  contador = contador + 1;
	                  System.out.println("hay un posible mutante   "+ contador);
	                  return contador;
	              } 
	          }
	      }
	   return coincidencia;
	    
	        }
	    
	public static int coincidenciaColumna(char[][] matriz) {
	        
	        int contador=0;
	        char simbolo;
	        int coincidencia=0;
	 
	        for (int i = 0; i < matriz.length; i++) {
	                for(int j=0;j<(matriz.length)-2; j++){
	            //Reiniciamos la coincidencia
	            
	            //Cogemos el simbolo de la fila
	            simbolo = matriz[j][i];
	            
	                    //sino coincide ya no habra semimutante  en esta fila
	                    if (simbolo == matriz[j+1][i]&& simbolo == matriz[j+2][i] && simbolo == matriz[j+3][i]) {
	                        contador = contador + 1;
	                        System.out.println("hay un posible mutante   "+ contador);
	                        return contador;
	                    }
	                    
	              }
	 
	        }
	   return coincidencia;
	    }

	 
	    public static int coincidenciaDiagonal(char[][] matriz) {
	 
	        char simbolo;
	        int contador=0;
		int cont=1;
	        int coincidencia=0;
	        //Diagonal principal
	        for(int i=0;i<(matriz.length)-3; i++){
		simbolo = matriz[i][i];
	        
	                           //sino coincide ya no habra mutante en esta fila

	                if (simbolo == matriz[i+1][i+1] && simbolo == matriz[i+2][i+2] && simbolo == matriz[i+3][i+3]) {
	                    			
						contador = contador + 1;
						return contador;
			  
	                        }
	         }
	 return coincidencia;
	     
	        }
	 
	              
	private int coincidenciaInversa(char[][] matriz) {
	       
	        char simbolo;
	        int contador=0;
		int cont=1;
	        int coincidencia=0;
	        //Diagonal principal
	        
	        for (int i=0;i<(matriz.length)-3;i++){
	            
	            for (int j=5;j>2; j--){
	                simbolo = matriz[i][j];
	        
	               //sino coincide ya no habra mutante en esta fila

	                if (simbolo == matriz[i+1][j-1]&& simbolo == matriz[i+2][j-2]&& simbolo == matriz[i+3][j-3]) {
	                    
				contador = contador + 1;
				return contador;
					  }
	       
	              
	 
	    }
	        
	            }
	            return coincidencia;
	    }
	  
	}

