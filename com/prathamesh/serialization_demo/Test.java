package com.prathamesh.serialization_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		A a=new A();
		File f = new File("F:\\t.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a);
		oos.close();
		fos.close();
		System.out.println("\nSerialized Object is : " + a);
		
		File f1 = new File("F:\\t.txt");
		FileInputStream fis = new FileInputStream(f1);
		ObjectInputStream ois = new ObjectInputStream(fis);
		A a1=(A) ois.readObject();
		ois.close();
		fis.close();
		System.out.println("\nDe-Serialized Object is : " + a1);
	}

}
class A implements Serializable{
	int i=10;
static final transient int j=20;
	public A() {
		super();

		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "A [i=" + i + ", j=" + j + "]";
	}
}