package wzg;

public class Account {
	private double balance;
	//标记账户中是否有存款
	private boolean flag=false;
	public synchronized void draw(double drawAmount){
		try {
			if(!flag){
				this.wait();
			}else{
				System.out.println(Thread.currentThread().getName()+"取钱："+drawAmount);
				balance-=drawAmount;
				System.out.println("账户余额："+balance);
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
				System.out.println(Thread.currentThread().getName()+"存款："+depositAmount);
				balance+=depositAmount;
				Thread.sleep(10);
				System.out.println("账户余额为："+balance);
				flag=true;
				this.notifyAll();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
