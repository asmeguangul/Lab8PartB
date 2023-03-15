package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address("street1", "Mekelle", 25555);
        Student student = new Student(4, "Mike", "161616");
        List<Grade> grade = Arrays.asList(new Grade("EA", "A+"),
                new Grade("WAA", "A-"),
                new Grade("SA", "A+"));

        student.setAddress(address);
        student.setGrades(grade);
        studentRepository.save(student);

        address = new Address("street2", "Mekelle", 25555);
        student = new  Student(5, "Kenedy", "121212");

         grade = Arrays.asList(new Grade("WAP", "A"),
                new Grade("WAA", "A-"),
                new Grade("SA", "B+"));

        student.setAddress(address);
        student.setGrades(grade);
        studentRepository.save(student);


        System.out.println(studentRepository.findByName("Mike"));
        System.out.println(studentRepository.findByPhone("121212"));

        // print list of studetn from specified address
        System.out.println(" List of students from Mekelle");
        List<Student> students = studentRepository.findStudentByCity("Mekelle");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("=============STUDENT COURSE BY NAME===============");
        System.out.println(studentRepository.findCourseByName("WAP"));


        System.out.println("========CUORSE WITH SPECIFIED NAME AND GRADE ============");
        System.out.println(studentRepository.findByCourseAndGrade("EA","A+"));

    }

}
