/*Estructura de datos II
*James Pico
*Carlos Sandoval
*Proyecto 1
*/
package arbolBB;

import java.util.LinkedList;
import javax.swing.JPanel;


public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;
    private int cant;

    public ArbolBB() {
        raiz = null;
    }
    
    public boolean agregar(int dato) {
        Nodo nuevo = new Nodo(dato, null, null);
        insertar(nuevo, raiz);
        return true;
    }
    
    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
   public LinkedList max() {
        LinkedList rec = new LinkedList();
        max(raiz, rec);
        return rec;
    }
    
    public  void max(Nodo aux, LinkedList recorrido) {
        Nodo reco = raiz;
        if (raiz != null) {
            while (reco.getIzq()!= null) {
                reco = reco.getIzq().getDer();
            }
        }
        recorrido.add ("" + reco.getDato());
    
    }
     //cantidad de nodos del arbol
public int padre(int info) {
        if (info == 0 || this.raiz == null) {
            return 0;
        }
        Nodo x = padre(this.raiz, info);
        if (x == null) {
            return 0;
        }
        return (x.getDato());
    }

    private Nodo padre(Nodo x, int info) {
        if (x == null) {
            return null;
        }
        if ((x.getIzq() != null && x.getIzq().getDato()==(info)) || (x.getDer() != null && x.getDer().getDato()==(info))) {
            return (x);
        }
        Nodo y = padre(x.getIzq(), info);
        if (y == null) {
            return (padre(x.getDer(), info));
        } else {
            return (y);
        }
    }
  /* 
    public LinkedList total() {
        LinkedList rec = new LinkedList();
        total(raiz, rec);
        return rec;
    }
 public int total(Nodo aux,LinkedList recorrido){
    if(aux==null){
	} else
        return (1+total(aux.getDer())+total(aux.getIzq()));
        return 0;
 }    

public int hojas(Nodo aux){ 
   if (aux == null){
   	
   } else if (aux.getIzq() == null && aux.getDer() == null) 
      return 1; 
   else 
      return hojas(aux.getIzq()) + hojas(aux.getDer()); 
        return 0;
}
public LinkedList padre() {
        LinkedList rec = new LinkedList();
        padre(raiz, rec);
        return rec;
    }
public void padre(Nodo aux, LinkedList recorrido){
        recorrido.add ( total(aux)-hojas(aux));
}
*/


    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }

    private void total(Nodo der) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int cantidadNodosHoja(int cant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int cantidadNodos(int cant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
