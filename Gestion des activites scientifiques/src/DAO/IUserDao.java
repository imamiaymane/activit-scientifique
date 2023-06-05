package DAO;

import java.util.List;

import Metier.User;

public interface IUserDao {
	public List<User> userParMC(String mc);
	public List<User> listeUser();
	public User getUser(int id);
	public void deleteUser(int id);
	public void  addUser(User u);
	public boolean verifier(String email) throws ClassNotFoundException;
}
