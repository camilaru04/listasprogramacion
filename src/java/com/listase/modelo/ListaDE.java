/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listase.excepciones.InfanteExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maria Camila
 */
public class ListaDE implements Serializable{
    private NodoDE cabeza;
    
    public ListaDE() {
    }

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }
    
    public void adicionarNodo(Infante infante)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoDE(infante);
        }
        else
        {
            //Lamo a mi ayudante
            NodoDE temp= cabeza;
            while(temp.getSiguiente()!=null) //Mientras que en siguiente exista algo
            {
//                temp= temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new Nodo(infante));
        }
        
    }
    
    public void adicionarNodoAlInicio(Infante infante)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoDE(infante);
        }
        else
        {
            NodoDE temp= new NodoDE(infante);
            temp.setSiguiente(cabeza);
            cabeza= temp;
        }
    }
    
    public short contarNodos()
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            NodoDE temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=null)
            {
//                temp =temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    public String obtenerListadoInfantes()
    {
        
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        
        return listarInfantes("");
    }
    
    public String listarInfantes(String listado)
    {
        if(cabeza !=null)
        {
            NodoDE temp= cabeza;            
            while(temp!=null)
            {
                listado += temp.getDato()+"\n";
//                temp=temp.getSiguiente();
                
            }
            return listado;
        }
        return "No hay infantes";
    }
    
    
     public List obtenerListaInfantes()
    {
        List<Infante> listado = new ArrayList<>();
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        listarInfantes(listado);
        return listado;
    }
    
    public void listarInfantes(List listado)
    {
        if(cabeza !=null)
        {
            NodoDE temp= cabeza;            
            while(temp!=null)
            {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
//                temp=temp.getSiguiente();                
            }            
        }
        
    }
    
    public float promediarEdades()
    {
        int sumaEdades= 0;
        int contador=0;
        if(cabeza !=null)
        {
            NodoDE temp= cabeza;            
            while(temp!=null)
            {          
                //sumaEdades= sumaEdades+ temp.getDato().getEdad();
                sumaEdades += temp.getDato().getEdad();
                contador++;
//                temp=temp.getSiguiente();                
            }   
            return sumaEdades/(float) contador;
        }
        return 0;
        
    }
    
    
    public void invertirLista()
    {
        if(cabeza!=null)
        {
            //Crear una lista temporal la cabeza de la lista temporal está vacía
            ListaSE listaTemporal = new ListaSE();
            // Llamo un ayudante
            NodoDE temp= cabeza;
            //Recorro la lista de principio a fin
            while(temp!=null)
            {         
               //Parado en cada nodo , se extrae la información y se
                // envía a la otra lista al inicio
                listaTemporal.adicionarNodoAlInicio(temp.getDato());
                //temp= temp.getSiguiente();                
            }   
            //Igualo la cabeza de mi lista principal a la cabeza de la lista temporal
           
        }
    }
    
    public short contarInfantesxGenero(boolean genero)
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            NodoDE temp= cabeza;
            short cont=0;
            while(temp!=null)
            {
                if(temp.getDato().isGenero()==genero)
                {
                  cont++;   
                }                
               // temp=temp.getSiguiente();
                
            }
            return cont;
        }
    }
    public void eliminarInfanteDe (short codigo ) throws InfanteExcepcion{
        NodoDE temp = cabeza;
        boolean eliminar = false;
        while (cabeza != null && eliminar == false) {
            eliminar = (temp.getAnterior().getDato().getCodigo()== codigo);
            if (eliminar) {
 //              temp = temp.getAnterior();
                
            }       
        }
        if(eliminar){
            if (temp == cabeza){
  //              cabeza = temp.getAnterior();          
            }else{
                temp.getAnterior().setSiguiente(temp.getSiguiente());
                if(temp.getSiguiente() != null){
 //                   temp.getSiguiente().setAnterior(temp.getAnterior());
                }
            }
            temp = null;
        }    
    }
}

