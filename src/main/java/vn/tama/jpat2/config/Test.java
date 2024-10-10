package vn.tama.jpat2.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Test {
    public static void main(String[] args) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try{
            trans.begin();

            //Goi phuong thuc de insert, update, delete
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally{
            enma.close();
        }
    }
}
