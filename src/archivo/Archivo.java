package archivo;

import java.io.*;
import java.util.ArrayList;

public class Archivo{
   private ObjectOutputStream out=null;
   private ObjectInputStream input=null;
   private final String nombre;
   
   public Archivo(String nombre) throws IOException{
       this.nombre=nombre+".dat";
       new File(this.nombre).createNewFile();
   }
   
   public void Save(ArrayList us) throws IOException{
       out = new ObjectOutputStream(new FileOutputStream(nombre));
       out.writeObject(us);
       out.close();
   }
   
   public ArrayList Read() throws IOException, ClassNotFoundException{
       if(new File(nombre).length()==0){
           return new ArrayList();
       }
       input = new ObjectInputStream(new FileInputStream(nombre));
       ArrayList dato = (ArrayList)input.readObject();
       input.close();
       return dato;
   }
}
