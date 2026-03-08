package com.tahamert.services.impl;

import com.tahamert.dto.DtoHome;
import com.tahamert.dto.DtoRoom;
import com.tahamert.entities.Home;
import com.tahamert.entities.Room;
import com.tahamert.repository.HomeRepository;
import com.tahamert.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeSerivceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;


    @Override
    public DtoHome getDtoHome(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional=homeRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Home dbHome=optional.get();

        List<Room> dbRooms = dbHome.getRoom();
        BeanUtils.copyProperties(dbHome,dtoHome);
        if(dbRooms.size()>0){
            for (Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room,dtoRoom);
                dtoHome.getRooms().add(dtoRoom);

            }
        }



        return dtoHome;
    }
}
