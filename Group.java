/* Group of goods
 * contains goods with its group set in the constructor
 */
import java.util.ArrayList;

public class Group {
	
	public Group() {
		goods = new ArrayList<>();
	}
	
	public void addGood(Good good) {
		goods.add(good);
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Good> getGoods() {
		return goods;
	}
	public void setGoods(ArrayList<Good> goods) {
		this.goods = goods;
	}
	private ArrayList<Good> goods;
}
