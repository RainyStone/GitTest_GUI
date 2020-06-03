package practice7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Resume implements Cloneable,Serializable{
	private Image image;
	
	public Resume() {
		System.out.println("Resumeԭ���Ѵ���");
	}
	
	public Image getImage(){
		return image;
	}
	
	public void setImage(Image image) {
		this.image=image;
	}
	
	public Resume copyWithImage(String cloneImageOrNot) throws ClassNotFoundException, IOException {
		Resume resume=null;
		if(cloneImageOrNot.equals("��")) {
			resume=deepClone();
			return resume;
		}
		else if(cloneImageOrNot.equals("��")){
			resume=shallowClone();
			return resume;
		}
		else 
			return resume;
	}
	
	private Resume shallowClone() {
		Object obj=null;
		try {
			System.out.println("Resumeԭ���ѱ�ǳ��¡");
			obj=super.clone();
			
			return (Resume)obj;
		} catch (CloneNotSupportedException e) {
			System.out.println("��֧��ǳ��¡");
			
			return null;
		}
	}
	
	private Resume deepClone() throws IOException, ClassNotFoundException{
		//������д������
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bao);
		oos.writeObject(this);
		//�����������ȡ��
		ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		System.out.println("Resumeԭ���ѱ����¡");
		
		return (Resume)ois.readObject();
	}
}
