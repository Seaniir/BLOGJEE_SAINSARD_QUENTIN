package dao;

import java.util.List;

public interface IDAO<T> {

    public boolean create(T object);

    public List<T> read();

    public List<T> readById(int id);

    public void update(T object);

    public void delete( int id);

    public T findById(int id);

    public List<T>findByName(String nom);

    public T connectUser(String email, String password);
}