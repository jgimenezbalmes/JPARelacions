package demojparelacions.controladors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demojparelacions.entitats.Course;
import demojparelacions.entitats.CourseMaterial;
import demojparelacions.repositoris.CourseRepositori;
import demojparelacions.repositoris.CoursematerialRepositori;



@RestController
@RequestMapping("api")
public class CourseController {

	@Autowired
	CourseRepositori courseRep;
	
	@Autowired
	CoursematerialRepositori coursematRep;
	
	@GetMapping("course")
	public Iterable<Course> getCourse() {
		return courseRep.findAll();
	}
	
	@GetMapping("course/{id}")
	public Course getCourse(@PathVariable long id) {
		Course course = courseRep.findById(id).get();
		if (course==null) {
			return null;
		}
		System.out.println("EAGER OR LAZY");
		return course;
	}
	
	@GetMapping("coursemat")
	public Iterable<CourseMaterial> getCourseMat() {
		return coursematRep.findAll();
	}
	
	@GetMapping("coursemat/{id}")
	public CourseMaterial getCourseMat(@PathVariable long id) {
		CourseMaterial coursemat = coursematRep.findById(id).get();
		return coursemat;
	}
	
	@DeleteMapping("course/delete/{id}")
	public void deleteCourse (@PathVariable long id) {
		courseRep.deleteById(id);
	}
	
}
