package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Repository.ChildRepo;
import com.example.demo.model.Child;
@Service
public class service {
@Autowired
 ChildRepo r;
public String add(Child m) {
	r.save(m);
	return "Added";
}
public List<Child> getDetails(){
	return r.findAll();
}
public Child updateDetails(Child e1) {
	return r.saveAndFlush(e1);
}
public void deleteDetails(int id) {
	r.deleteById(id	);
}

public 	List<Child> getSorted(String field){
	return r.findAll(Sort.by(Sort.Direction.ASC,field));
}
public List<Child> getWithPagination(@PathVariable int offset,@PathVariable int pageSize){
	Page<Child> page=r.findAll(PageRequest.of(offset,pageSize));
	return page.getContent();
}
}