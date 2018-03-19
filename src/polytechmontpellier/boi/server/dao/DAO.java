package polytechmontpellier.boi.server.dao;

import java.util.ArrayList;

public abstract class DAO<T> {
		
	public abstract ArrayList<T> findAll();
	public abstract ArrayList<T> findById();
	public abstract ArrayList<T> findByName();
	public abstract T insert(T obj);
	public abstract boolean update(T obj);
	public abstract boolean delete(T obj);
	
}
