package model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.User;

public class C_ScoreDao {
	
	public void insertScore(User u) {
		ObjectOutputStream oos = null; 
		try {
			oos = new ObjectOutputStream(new FileOutputStream("score.dat", true));
			oos.writeObject(u);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList readAll() {
		ArrayList list = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("score.dat");
			list = new ArrayList();
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fis);
				User u = (User) ois.readObject();
				list.add(u);
				
			}
		} catch (EOFException e) {
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
