package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {
	private FileInputStream fileIn;
	private ObjectInputStream in;
	
	public Object deserialize(File file) throws IOException, ClassNotFoundException{
		try{
		fileIn = new FileInputStream(file.getPath());
		in = new ObjectInputStream(fileIn);
		return in.readObject();
		}finally{
			in.close();
			fileIn.close();
		}
	}
}
