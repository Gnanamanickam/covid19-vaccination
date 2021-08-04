package vaccine.service;

import java.util.List;

import user.dao.UserDao;
import user.domain.User;
import vaccine.dao.VaccineDao;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class VaccineService {
	private VaccineDao vaccineDao = new VaccineDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
//	public void regist(User form) throws VaccineException, ClassNotFoundException, InstantiationException, IllegalAccessException{
//		
//		// check the user name
//		//VaccineDao.add(form);
//	}
	
	
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
//	public void login(User form) throws VaccineException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//		User user = userDao.findByUsername(form.getUsername());
//		if(user.getUsername()==null) throw new VaccineException("The user is not in the database");
//		
//		String password = user.getPassword();
//		
//		if(password!=null && !password.equals(form.getPassword()))
//			throw new VaccineException(" The password is not right");
//		
//	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return vaccineDao.findall();
		
	}
}
