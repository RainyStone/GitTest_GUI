package practice7;

import util.XMLUtil_Practice7;

public class Client {
	public static void main(String[] args) {
		Resume resume_previous=new Resume();
		Resume resume_new=null;
		Image image=new Image();
		resume_previous.setImage(image);
		String isWithImageString=XMLUtil_Practice7.IsWithImage();
		try {
			resume_new=resume_previous.copyWithImage(isWithImageString);
		} catch (Exception e) {
			System.out.println("��¡ʧ��");
		}
		//�Ƚϼ���
		System.out.println("�����Ƿ���ͬ?"+(resume_previous==resume_new));
		//�Ƚ���Ƭ
		System.out.println("��Ƭ�Ƿ���ͬ?"+(resume_previous.getImage()==resume_new.getImage()));
	}
}
