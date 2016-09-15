package com.github.verhagen.mrrs.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.verhagen.mrrs.domain.Room;
import com.github.verhagen.mrrs.repository.RoomRepository;
import com.github.verhagen.mrrs.repository.csv.CsvRoomRepository;

@Path ("room")

public class RoomResource {
	private RoomRepository roomRepo;
	
	
	public RoomResource() {
		try {
			roomRepo = CsvRoomRepository.importBy(new FileReader("src/test/resources/room.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


    @GET
    @Produces(MediaType.TEXT_PLAIN)
	public Collection<Room> getAll(){
		return roomRepo.getAll();
	}

}
