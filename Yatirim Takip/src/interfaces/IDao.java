package interfaces;

import java.util.List;

public interface IDao<T> {

	void save(T t,String id);
	void save(T t);
	void update(String id, T t);
	void delete(String id);
	List<T> getAll();
}
