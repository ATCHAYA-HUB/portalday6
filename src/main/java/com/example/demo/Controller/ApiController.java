package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.service;
import com.example.demo.model.Child;
@RestController
public class ApiController {
         @Autowired
         service s;    
         @GetMapping("/getfam")
         public List<Child> showDetails(){
        	 return s.getDetails();
         }
         @PostMapping("/postfam")
         public String addDetails(@RequestBody Child m) {
        	 s.add(m);
        	 return "Added product "+m.getBabyId();
         }
         @PutMapping("/putfam")
     	public Child updateInfo(@RequestBody Child st1) {
     		return s.updateDetails(st1);
     	}
     	@DeleteMapping("/delfam/{id}")
     	public String deleteInfo(@PathVariable("id")int id) {
     		s.deleteDetails(id);
     		return "Deleted details";
     	}  
     	//sorting
        @GetMapping("/product/{field}")
        public List<Child> getWithSort(@PathVariable String field){
       	 return s.getSorted(field);
        }
        
        //pagination
        @GetMapping("/product/{offset}/{pageSize}")
        public List<Child> productsWithPagination(@PathVariable int offset,@PathVariable int pageSize){
       	 return s.getWithPagination(offset, pageSize);
        }
}