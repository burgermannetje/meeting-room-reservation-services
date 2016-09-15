package com.github.verhagen.mrrs.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.github.verhagen.mrrs.domain.Room;

public class RoomRepository {
	private Map<String, Room> rooms = new HashMap<>();


	public void add(final Room room) {
		if (room == null) {
			throw new IllegalArgumentException("Argument 'room' should not be null.");
		}
		if (rooms.containsKey(room.getLocation())) {
			throw new IllegalArgumentException("There is already a room registered with the location '"
					+ room.getLocation() + "'. Registered room details '" + rooms.get(room.getLocation()) + "'");
		}

		rooms.put(room.getLocation(), room);
	}

	public int size() {
		return rooms.size();
	}

	public Room getByLocation(final String location) {
		final String locationCln = StringUtils.trimToNull(location);
		if (locationCln == null) {
			throw new IllegalArgumentException("Argument 'location' should not be null.");
		}

		if (! rooms.containsKey(locationCln)) {
			throw new IllegalArgumentException("Argument 'location' with value '" + locationCln + "' is not a known room.");
		}

		return rooms.get(locationCln);
	}

	public Collection<Room> getAll() {
		return rooms.values();
	}

}
