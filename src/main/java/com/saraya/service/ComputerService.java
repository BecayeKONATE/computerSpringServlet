package com.saraya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.model.Computer;

@Service
public class ComputerService {

	private static List<Computer> computers = new ArrayList<Computer> ();
	private static int count = 10;
	
	static {
		computers.add(new Computer(1, "MacBook", "Pro 13", "1700$", "https://images.frandroid.com/wp-content/uploads/2020/11/apple-macbook-pro-13-2020-m1-frandroid.png"));
		computers.add(new Computer(2, "hp", "Elitebook 840", "600$", "https://www.laptopspirit.fr/wp-content/uploads/new/2021/01/CES-2021-HP-EliteBook-840-G8-1.jpg"));
		computers.add(new Computer(3, "Lenovo", "x13", "650$$", "https://static.fnac-static.com/multimedia/Images/FR/MDM/6f/42/e7/15155823/1540-1/tsp20210707152916/PC-Portable-Lenovo-IdeaPad-3-15ADA05-15-6-AMD-Athlon-8-Go-RAM-256-Go-D-Gris-platine.jpg"));
		computers.add(new Computer(4, "Asus", "zenbook", "600$", "https://img.bfmtv.com/images/63a/17c37ccd393051fb4457277f0a9e2.jpg"));
		computers.add(new Computer(5, "Dell", "inspiron", "550$", "https://cdn.futura-sciences.com/buildsv6/images/wide1920/f/f/b/ffb60826ff_50172568_dell.jpg"));
		computers.add(new Computer(6, "MacBook", "air", "1200$", "https://cdn.mgig.fr/2020/04/mg-4b53d3ac-101b-4a0f-9749_accroche.jpg"));
		computers.add(new Computer(7, "Toshiba", "satellite l350", "400$", "https://media.wired.com/photos/59e956db06a2232e82ba9c05/master/w_1600%2Cc_limit/toshiba-inline2.jpg"));
		computers.add(new Computer(8, "acer", "predator", "300$", "https://m.media-amazon.com/images/I/71HaIH7W5gL._AC_SL1322_.jpg"));
		computers.add(new Computer(9, "Sony", "vaio pcg", "200$", "https://www.numerama.com/content/uploads/2019/01/alienware-17-area-51m_8.jpg"));
		computers.add(new Computer(10, "Samsung", "darty", "400$", "https://pic.clubic.com/v1/images/1737744/raw"));
	}
	
	public List<Computer> getAllComputer() {
		return computers;
	}
	
	public void addComputer(String make, String model, String price, String image) {
		computers.add(new Computer(++count,make,model,price,image));
	}
	
	public void deleteComputer(int id) {
		Iterator<Computer> iterate = computers.iterator();
		while(iterate.hasNext()) {
			if(iterate.next().getId() == id) {
				iterate.remove();
			}
		}
	}
	
	public Computer getById(int id) {
		for (Computer comp : computers) {
			if(comp.getId() == id) {
				return comp;
			}
		}
		return null;
	}
	
	public void updateComputer(Computer comp) {
		computers.add(comp);
		computers.remove(comp);
	}
}