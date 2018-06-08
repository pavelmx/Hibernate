/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import entity.Gruppyi;
import entity.Studentyi;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marchuk_15686
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
Session s = sf.openSession();
Transaction t = s.beginTransaction();

System.out.println("table Studentyi");
    String d="Studentyi";
     org.hibernate.Query query = s.createQuery("from "+d+" u ");
     List<Studentyi> ups = (List<Studentyi>)query.list();

for (Studentyi u : ups)
     {
          System.out.print(u.getFamiliya() + " "+ u.getImya() + " " + u.getOtchestvo()+" ");
          System.out.print(u.getNomerZachetki());
          System.out.println();
          
          s.update(u);

     }

System.out.println("table Gruppyi");
        org.hibernate.Query query2 = s.createQuery("from Gruppyi u where shifr = (:id)");
     query2.setParameter("id", 4);
     List<Gruppyi> ups2 = (List<Gruppyi>)query2.list();
for (Gruppyi u2 : ups2)
     {
          System.out.print(u2.getNazvanie()+ " ");
          System.out.print(u2.getStudentyis());
          System.out.println();
          
          s.update(u2);

     }
       
System.out.println("------------------------");
Printt("Gruppyi");


s.flush();
t.commit();
s.close();

        
    }
    
   public static void Printt(String tr){

       SessionFactory sf = HibernateUtil.getSessionFactory();
Session s = sf.openSession();
org.hibernate.Query query = s.createQuery("from "+tr+" u ");

if(tr=="Studentyi"){
    
    System.out.println("table Studentyi");

    List<Studentyi> ups = (List<Studentyi>)query.list();

for (Studentyi u : ups)
     {
          System.out.print(u.getFamiliya() + " "+ u.getNomerZachetki()+" "+u.getGorod());
          System.out.println();
          s.update(u);
   } 

}if(tr=="Gruppyi"){
    
    System.out.println("table Gruppyi");

     List<Gruppyi> ups2 = (List<Gruppyi>)query.list();
     
        for (Gruppyi u2 : ups2)
     {
          System.out.println(u2.getNazvanie()+ " "+u2.getStudentyis());
          
          s.update(u2);
     }
}
   }
    
}
