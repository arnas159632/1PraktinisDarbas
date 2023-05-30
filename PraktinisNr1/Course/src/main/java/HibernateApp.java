
import Util.HibernateUtil;
import Util.JaxbUtil;
import org.example.drevinskas.courses.Course;
import org.example.drevinskas.courses.Student;
import org.example.drevinskas.courses.Registration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args){

        Course course1 = new Course("Literature", "Someone", 2026, 10241);
        Student student1 = new Student("Arnas", "Drevinskas");
        Registration registration1 = new Registration("2023-06-08", List.of(student1), List.of(course1));

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(registration1);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Registration> registrations = session.createQuery("from Registration", Registration.class).list();
            registrations.forEach(ordr -> System.out.println());

            System.out.println("---------------------------------");
            registrations.forEach(ordr -> JaxbUtil.convertToXML(ordr));

            //server = Server.createTcpServer().start();
            System.in.read();
        }catch (Exception e){
            if(transaction != null){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            //server.shutdown();
        }
    }
}
