package wzg;

public class Account {
	private double balance;
	//����˻����Ƿ��д��
	private boolean flag=false;
	public synchronized void draw(double drawAmount){
		try {
			if(!flag){
				this.wait();
			}else{
				System.out.println(Thread.currentThread().getName()+"ȡǮ��"+drawAmount);
				balance-=drawAmount;
				System.out.println("�˻���"+balance);
				Thread.sleep(10);
				flag=false;
				this.notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void deposit(double depositAmount){
		try {
			if(flag){
				this.wait();
			}else{
				System.out.println(Thread.currentThread().getName()+"��"+depositAmount);
				balance+=depositAmount;
				Thread.sleep(10);
				System.out.println("�˻����Ϊ��"+balance);
				flag=true;
				this.notifyAll();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}