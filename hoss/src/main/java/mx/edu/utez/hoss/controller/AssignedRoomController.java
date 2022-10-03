package mx.edu.utez.hoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.hoss.entity.AssignedRoom;
import mx.edu.utez.hoss.service.AssignedRoomService;

@RestController
@RequestMapping(value = "/hoss/assignedRooms")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class AssignedRoomController {
    
    @Autowired
    private AssignedRoomService assignedRoomService;

    @RequestMapping(value = "/getAll", method = {RequestMethod.GET})
    public List<AssignedRoom> getAll (){
        return assignedRoomService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", method = {RequestMethod.GET})
    public AssignedRoom getById(@PathVariable("id") long id){
        return assignedRoomService.findById(id);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody AssignedRoom assignedRoom){
        System.out.println(assignedRoom);
        return assignedRoomService.save(assignedRoom);
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable("id") long id){
        return assignedRoomService.delete(id);
    }


}
