/**
 * Algoritmos y estructuras de datos 2018-2
 */
 import java.io.BufferedWriter;
 import java.io.FileWriter;
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;

public class KDTree{

	public static class Node{
			double x;
			double y;
			boolean checkX;
			Node childL, childR;

			public Node(double x, double y, boolean checkX){
				this.x = x;
				this.y = y;
				this.checkX = checkX;
        childL = childR = null;
			}

      public double getX(){
        return this.x;
      }

      public double getY(){
        return this.y;
      }


		}

	public static class KdTree {
		public Node root;

    public KdTree(){
      this.root = null;
    }
		/**
		 * Inserta un las coordenadas dadas en el KDtree
		 *
		 */
		public void insert(double x, double y){
      if(this.root == null){
        this.root = new Node(x,y,true);
      }else{
        Node aux = this.root;
        while(aux != null){
          if(aux.checkX){
            if(aux.x < x){
              if(aux.childR != null){
                aux = aux.childR;
              }else{
                aux.childR = new Node(x,y,!aux.checkX);
                break;
              }
            }else{
              if(aux.childL != null){
                aux = aux.childL;
              }else{
                aux.childL = new Node(x,y,!aux.checkX);
                break;
              }
            }
          }else{
            if(aux.y < y){
              if(aux.childR != null){
                aux = aux.childR;
              }else{
                aux.childR = new Node(x,y,!aux.checkX);
                break;
              }
            }else{
              if(aux.childL != null){
                aux = aux.childL;
              }else{
                aux.childL = new Node(x,y,!aux.checkX);
                break;
              }
            }
          }
        }
      }
    }

		/**
		 * Retorna el nodo mas cercano a las coordenadas dadas
		 *
		 */
		public Node get(double x, double y){
			return null;
		}

    public void printTree(Node x){
      if(x != null){
        System.out.println("x="+x.x+"|"+"y="+x.y);
        System.out.println("right child:");
        printTree(x.childR);
        System.out.println("left child:");
        printTree(x.childL);
      }else{
        System.out.println("null");
      }
    }

    public Node getRoot(){
      return this.root;
    }

	}
	/**
	 * La implementacion debe recibir 2 archivos por la linea de argumentos
	 * donde el primero es el arbol a construir y el segundo es el archivo
	 * con consultas. Se deben imprimir los resultados de las consultas por
	 * por la salida estandar.
	 */
	public static void main(String args[]){
		System.out.println(args[0]+" "+args[1]);
    KdTree tree = new KdTree();

		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))){

        String sCurrentLine;

        while((sCurrentLine = br.readLine()) != null){
          //System.out.println(sCurrentLine);
          String[] input = sCurrentLine.split(" ");
          tree.insert(Double.parseDouble(input[0]),Double.parseDouble(input[1]));
          //System.out.println(input[0]+" "+input[1]);

        }
        //System.out.println(data);

      }catch (IOException e){
        e.printStackTrace();
        System.exit(0);
      }

      tree.printTree(tree.root);

  }
}
