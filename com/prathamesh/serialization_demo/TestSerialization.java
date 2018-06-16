package com.prathamesh.serialization_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {
public static void main(String[] args) throws IOException, ClassNotFoundException{
	Emp e1= new Emp();
	File f = new File("F:\\t.txt");
	FileOutputStream fos = new FileOutputStream(f);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(e1);
	oos.close();
	fos.close();
	System.out.println("\nSerialized Object is : " + e1);
	
	File f1 = new File("F:\\t.txt");
	FileInputStream fis = new FileInputStream(f1);
	ObjectInputStream ois = new ObjectInputStream(fis);
	Emp e2=(Emp) ois.readObject();
	ois.close();
	fis.close();
	System.out.println("\nDe-Serialized Object is : " + e2);

}
}

class Emp implements Serializable{
	private int empId=101;
	private String empName="abc";
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + "]";
	}
	
}

class PermEmp extends Emp {
	private int pEmpId=102;
	private String pEmpName="xyz";
	public PermEmp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PermEmp [pEmpId=" + pEmpId + ", pEmpName=" + pEmpName + "]";
	}
}
