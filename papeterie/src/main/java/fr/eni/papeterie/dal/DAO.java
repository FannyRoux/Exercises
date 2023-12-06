/**
 * 
 */
package fr.eni.papeterie.dal;

import java.util.List;

/**
 * @author Fanny Roux
 */
public interface DAO<T> {
	public T read(Integer id) throws DALException;
	public List<T> selectAll()throws DALException;
	public void update(T object) throws DALException;
	public void create(T object) throws DALException;
	public void delete (Integer id) throws DALException;
}
