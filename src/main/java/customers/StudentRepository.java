package customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
    Student findByName(String name);
    Student findByPhone(String phone);

   // @Query("{'address.city' : ?0}")
    @Query("{'address.city' : :#{#city}}")
    List<Student> findStudentByCity(@Param("city") String city);
//Find the Students that took a certain course with a given name

    //@Query("{ 'grades.courseName' : ?0 }")
   // @Query("{'grade.courseName' : :#{#courseName}}")
    @Query("{ 'grades': { $elemMatch: { 'courseName' : ?0 } }}")

    List<Student>  findCourseByName(String course);


   @Query("{ 'grades.courseName': ?0, 'grades.grade': ?1 }")
   List<Student> findByCourseAndGrade(String courseName, String grade);


}
