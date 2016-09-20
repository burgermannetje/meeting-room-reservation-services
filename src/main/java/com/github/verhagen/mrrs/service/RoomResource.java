package com.github.verhagen.mrrs.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.verhagen.mrrs.domain.Room;
import com.github.verhagen.mrrs.repository.RoomRepository;
import com.github.verhagen.mrrs.repository.csv.CsvRoomRepository;


@Path("room")
public class RoomResource {
	private RoomRepository roomRepo;

	public RoomResource() {
		try {
			roomRepo = CsvRoomRepository.importBy(new FileReader("src/test/resources/room.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

/* ToDo Make use of this Map for parameterizing
   @GET
   @Path("/room/{location}")
   public String getLocation(@PathParam("location") PathSegment location) {...}
*/
   
   @GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Room> getAll() {
		return roomRepo.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{location}")
	public Room getRoomByLocation(@PathParam("location") String id) {
		return roomRepo.getByLocation(id);
	}

   }