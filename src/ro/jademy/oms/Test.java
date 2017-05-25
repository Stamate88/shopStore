package ro.jademy.oms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import ro.jademy.oms.data.OmsDao;
import ro.jademy.oms.data.OmsDaoImplMySQL;
import ro.jademy.oms.entity.Product;

public class Test {

	public static void main(String[] args) {
		OmsDao data = new OmsDaoImplMySQL();
		// = new OmsDaoImplProperties();
		data.init();

		int USER_ID = new Random().nextInt(500);
		List<Product> list = new ArrayList<>();
		list.addAll(data.getBooks());
		list.addAll(data.getDVDs());

		List<Product> comenzi = new ArrayList<>();
		int option = -2;
		while (option != -1) {
			System.out.println("Ce produs vrei? Introdu -1 daca ai terminat");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i + " " + list.get(i));
			}

			Scanner sc = new Scanner(System.in);
			// TODO: verifica daca optiunea nu ne da indexoutofbounds!!!
			option = sc.nextInt();
			if (option == -1) {
				break;
			} else if (option < -1) {
				System.out.println("dsga");
				continue;
			}

			Product pr = list.get(option);
			comenzi.add(pr);
		}

		System.out.println("Urmeaza sa cumperi:");
		System.out.println(comenzi);

		Product[] p = new Product[comenzi.size()];
		// alternativa ar fi sa parcurg lista
		// si sa adaug fiecare element la array
		data.addNewOrder(USER_ID, comenzi.toArray(p));
		// TODO:
		// data.addNewOrder(user order); - vezi UserOrder.java

		double cost = 0;
		for (Product prod : comenzi) {
			cost += prod.getCost();
		}
		System.out.println("Te costa: " + cost);
	}
}
