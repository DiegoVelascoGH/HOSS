package mx.edu.utez.hoss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.hoss.entity.AssignedRoom;
import mx.edu.utez.hoss.repository.IAssignedRoomRepository;

@Service
public class AssignedRoomService {
    
    @Autowired
    private IAssignedRoomRepository assignedRoomRepository;

    public List<AssignedRoom> findAll(){
        return assignedRoomRepository.findAll();
    }

    public AssignedRoom findById(long id){

        return assignedRoomRepository.findById(id).get();

    }

    public boolean save(AssignedRoom assignedRoom){
        boolean flag = false;
        AssignedRoom tempAssignedRoom = assignedRoomRepository.save(assignedRoom);
        if(tempAssignedRoom!=null){
            flag = true;
        }
        return flag;
    }

    public boolean delete(long id){
        boolean flag = false;
        AssignedRoom tempAssignedRoom = findById(id);
        if(tempAssignedRoom!=null){
            assignedRoomRepository.delete(tempAssignedRoom);
            flag = true;
        }
        return flag;
    }

}
