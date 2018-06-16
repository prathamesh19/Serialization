package com.prathamesh.serialization_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomizedSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Credentials c1 = new Credentials();

		File f = new File("F:\\s.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c1);
		oos.close();
		fos.close();
		System.out.println("\nSerialized Object is : " + c1);
		
		File f1 = new File("F:\\s.txt");
		FileInputStream fis = new FileInputStream(f1);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Credentials c2 = (Credentials) ois.readObject();
		ois.close();
		fis.close();
		System.out.println("\nDe-Serialized Object is : " + c2);

	}
}

class Credentials implements Serializable {
	private String username = "prathamesh";
	private transient String password = "pass";

	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + "]";
	}

	private void writeObject(ObjectOutputStream oos) throws Exception {
		oos.defaultWriteObject();
		String epwd = "abc" + password;
		oos.writeObject(epwd);
	}

	private void readObject(ObjectInputStream ois) throws Exception {
		ois.defaultReadObject();
		String epwd = (String) ois.readObject();
		password = epwd.substring(3);
	}

}
