package hau.dev;
import hau.dev.data.dao.CategoryDao;
import hau.dev.data.impl.CategoryImpl;
import hau.dev.data.model.Category;

public class MainApp {
    public static void main(String[] args) {
    	CategoryDao categoryDao = new CategoryImpl();
    	Category cat = new Category(1, "Áo quần", "https://g");
    	categoryDao.insert(cat);
    	Category find = categoryDao.find(18);
    	System.out.println(find.name);
    	find.name = "Ao quan qua dai";
    	categoryDao.update(find);
    	categoryDao.delete(find.id);
    	
    	
    }


}
