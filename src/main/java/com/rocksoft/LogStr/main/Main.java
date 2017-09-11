package com.rocksoft.LogStr.main;

import com.rocksoft.LogStr.tree.BinaryInsertDeleteTree;
import com.rocksoft.LogStr.tree.Node;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
//		File file = new File("C:\\Users\\Esenin\\eclipse-workspace\\LogisticStruct\\src\\text.txt");
//		try {
//			String line = FileUtils.readFileToString(file, "UTF-8");
//			String[] stringList = line.split("[ .,;()']");
//			FileParser fparser = new FileParser();
//			fparser.printWordCountsToFile(stringList);
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//
//		Employee employee0 = new StoreKeeper();
//		employee0.setName("Vasya");
//		employee0.setSurName("Pupkin");
//		employee0.setEstablishedPost("storekeeper");
//		Address address0 = new Address();
//		address0.setCountry("Belarus");
//		address0.setCity("Minsk");
//		address0.setRegion(Region.MINSKY);
//		address0.setStreet("Mohileuskala");
//		address0.setHomeNumber("39");
//		try {
//			employee0.setAddress(address0);
//		} catch (InvalidAddressException e) {
//			System.out.println(e);
//		}
//		((StoreKeeper) employee0).setNumbOfWorkingShift(5);
//		System.out.println(employee0.getName() + "\n" + employee0.getEstablishedPost() + "\n"
//				+ employee0.getAddress().getCountry() + " \nRegion : " + employee0.getAddress().getRegion());
//		System.out.println();
//
//		System.out.println("birth day");
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(1992, Calendar.MARCH, 25);
//		SimpleDateFormat nform = new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println(nform.format(calendar.getTime()));
//		calendar.add(Calendar.DATE, 8);
//		System.out.println("after 8 days");
//		System.out.println(nform.format(calendar.getTime()));
//		System.out.println("from String to Date");
//		Date date = null;
//		try {
//			date = ((nform.parse((nform.format(calendar.getTime())))));
//		} catch (ParseException e1) {
//			System.out.println(e1);
//		}
//		String s = "07/06/2017/4-00";
//		SimpleDateFormat sform = new SimpleDateFormat("dd/MM/yyyy/hh-mm");
//		try {
//			Date date1 = sform.parse(s);
//			System.out.println();
//			System.out.println(sform.format(date1));
//		} catch (ParseException e) {
//			System.out.println(e);
//		}
//		System.out.println();
//
//		System.out.println("isBlank :");
//		boolean str1 = StringUtils.isBlank("  ");
//		boolean str2 = StringUtils.isBlank(null);
//		boolean str3 = StringUtils.isBlank(employee0.getName());
//		boolean str4 = StringUtils.isBlank("");
//		System.out.println("" + str1 + "\n" + str2 + "\n" + str3 + "\n" + str4);
//
//		System.out.println("isEmpty :");
//		boolean st1 = " ".isEmpty();
//		boolean st3 = employee0.getName().isEmpty();
//		boolean st4 = "".isEmpty();
//		System.out.println("" + st1 + "\n" + st3 + "\n" + st4);
//		System.out.println();
//
//		String abc = "abcdefghigklmnopqrstuvwxyz";
//		System.out.println(abc.substring(0, 4));
//		System.out.println(abc.substring(10));
//		System.out.println();
//
//		String emailPattern = "^[a-zA-Z0-9]{4,}@[a-z]+\\.[a-z]+$";
//		String text = "egor1234@gmail.com";
//		Pattern pattern = Pattern.compile(emailPattern);
//		Matcher m = pattern.matcher(text);
//		boolean isEmailExist = m.matches();
//		System.out.println(isEmailExist);
//		System.out.println();
//
//		Address address1 = new Address();
//		address1.setCountry("Belarus");
//		address1.setRegion(Region.MINSKY);
//		IWorkerEat employee1 = new DriverCar();
//		employee1.eat();
//		((DriverCar) employee1).sleep();
//		((Employee) employee1).setName("Dima");
//		((Employee) employee1).setSurName("Petrov");
//		try {
//			((Employee) employee1).setAddress(address1);
//		} catch (InvalidAddressException e) {
//
//			System.out.println(e);
//		}
//		((Employee) employee1).setEstablishedPost("driver");
//		((DriverCar) employee1).setDriveCateg("c");
//		((DriverCar) employee1).driveCar("drive slowly");
//		address1.getYourAddress();
//		((DriverCar) employee1).driveCar("action");
//		((Employee) employee1).work();
//		((DriverCar) employee1).startShift("8-00");
//		System.out.println(((Employee) employee1).getName() + "\n" + employee1.eat() + " \n"
//				+ ((DriverCar) employee1).sleep() + "\n");
//
//		Address address2 = new Address("Belarus", "Minsk", "Leukova", "16", "34");
//		Employee employee2 = new Logist();
//		employee2.setName("Vitek");
//		employee2.setSurName("Politowsky");
//		employee2.setEstablishedPost("logist");
//		try {
//			employee2.setAddress(address2);
//		} catch (InvalidAddressException e) {
//			System.out.println(e);
//		}
//		System.out.println("Name: " + employee2.getName() + " " + "\nSurname: " + employee2.getSurname()
//				+ " \nEstablished post: " + employee2.getEstablishedPost());
//		System.out.println();
//
//		Employee employee3 = new HeadOfDepartment();
//		employee3.setName("Ivan");
//		employee3.setSurName("Petrov");
//		employee3.setEstablishedPost("head of department");
//		try {
//			employee3.setAddress(address2);
//		} catch (InvalidAddressException e) {
//			System.out.println(e);
//		}
//		System.out.println("name: " + employee3.getName() + "\nSurname :" + employee3.getSurname() + "\nPosition : "
//				+ employee3.getEstablishedPost() + "\nRegion representation :" + Region.MINSKY);
//		System.out.println();
//
//		System.out.println("StringBuilder");
//		StringBuilder strBuild = new StringBuilder();
//		strBuild.append(employee0.getName());
//		strBuild.append(" ");
//		strBuild.append(employee0.getSurname());
//		strBuild.append(", ");
//		strBuild.append(((Employee) employee1).getName());
//		strBuild.append(" ");
//		strBuild.append(" ");
//		strBuild.append(((Employee) employee1).getSurname());
//		System.out.println(strBuild);
//		System.out.println();
//
//		System.out.println("StringBuffer");
//		StringBuffer strBuff = new StringBuffer();
//		strBuff.append(employee0.getName());
//		strBuff.append(" ");
//		strBuff.append(employee0.getSurname());
//		strBuff.append(", ");
//		strBuff.append(((Employee) employee1).getName());
//		strBuff.append(" ");
//		strBuff.append(" ");
//		strBuff.append(((Employee) employee1).getSurname());
//		System.out.println(strBuff);
//
//		int count = 4;
//		int itemCount = 5000;
//
//		long arrayListSum = 0L;
//		long linkedListSum = 0L;
//
//		for (int i = 0; i < count; i++) {
//			CollectionComparing c1 = new CollectionComparing();
//			arrayListSum = c1.estimateAddingRandomEmployeeList(itemCount) + arrayListSum;
//			CollectionComparing c2 = new CollectionComparing();
//			linkedListSum = c2.estimateAddingRandomEmployeeLinkedList(itemCount) + linkedListSum;
//		}
//		System.out.println("Average adding values : \nArrayList: " + arrayListSum / count + "\nLinkedList : "
//				+ linkedListSum / count);
//
//		arrayListSum = 0L;
//		linkedListSum = 0L;
//		CollectionComparing d1 = new CollectionComparing();
//		List<Employee> arrayList = new ArrayList<>();
//		List<Employee> linkedList = new LinkedList<>();
//		arrayList = d1.addRandomEmployeeToList(itemCount, arrayList);
//		linkedList = d1.addRandomEmployeeToList(itemCount, linkedList);
//		for (int i = 0; i < count; i++) {
//			arrayListSum = d1.estimateDeletingRandomEmployeeList(arrayList) + arrayListSum;
//			linkedListSum = d1.estimateDeletingRandomEmployeeLinkedList(linkedList) + linkedListSum;
//		}
//		System.out.println("Average deleting values : \nArrayList: " + arrayListSum / count + "\nLinkedList : "
//				+ linkedListSum / count);
		
		BinaryInsertDeleteTree a = new BinaryInsertDeleteTree();
		Node root = null;
		root = a.insert(root, 0.12);
		root = a.insert(root, 0.44);
		root = a.insert(root,  0.85);
		root = a.insert(root, 1.15);
		root = a.insert(root, 2.15);
		
		System.out.println("After insert");
		a.printTree(root);
		
		System.out.println("After delete");
		root = a.delete(root, 0.12);
		
		a.printTree(root);
		
	}
}
