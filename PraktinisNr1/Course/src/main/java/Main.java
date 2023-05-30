import Util.JaxbUtil;
import jakarta.xml.bind.JAXBException;
import org.example.drevinskas.courses.Course;
import org.example.drevinskas.courses.Student;
import org.example.drevinskas.courses.Registration;

import java.io.IOException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {

        Course course1 = new Course("Math", "Cena", 2024, 10000 );
        Course course2 = new Course("Programming101", "Cena", 2024, 12054 );

        Student student1 = new Student("Vaiva", "Mackevičaitė");
        Student student2 = new Student("Daiva", "Vilnietė");

        Registration registration1 = new Registration("2023-03-01", List.of(student1, student2), List.of(course1, course2));
        JaxbUtil.convertToXML(registration1);
        System.out.println(registration1);
    }
}