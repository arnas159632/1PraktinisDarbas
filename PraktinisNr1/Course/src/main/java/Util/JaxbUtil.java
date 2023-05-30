package Util;

import org.example.drevinskas.courses.Registration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUtil {

    public static void convertToXML(Registration registration){
        try{
            JAXBContext context = JAXBContext.newInstance(Registration.class);

            Marshaller marshaller = null;

            marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

           // OutputStream os = new FileOutputStream("generated.xml");

            marshaller.marshal(registration, new File("order.xml"));

            marshaller.marshal(registration, System.out);
        }catch (/*FileNotFoundExeption | */ JAXBException e){
            throw new RuntimeException(e);
        }
    }

    public static void convertToPojo()
    {
        String fileName = "order.xml";
        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Registration.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Registration employee = (Registration) jaxbUnmarshaller.unmarshal(xmlFile);

            System.out.println(employee);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
