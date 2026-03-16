package com.dao;

import java.util.List;

import com.model.Room;

public interface RoomDao {
	boolean addRoom(Room r);
	List<Room> getAllRooms();
	Room getRoomById(int id);
	boolean updateRoom(Room r);
	boolean deleteRoom(int id);
}
