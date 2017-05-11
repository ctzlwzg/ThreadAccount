package wzg;

public class Account {
	//余额参数
	private double balance;
	//标记账户中是否有存款
	private boolean flag=false;
	//取款方法
	public synchronized void draw(double drawAmount){
		try {
			//如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
			if(!flag){
				this.wait();
			}else{
				System.out.println(Thread.currentThread().getName()+"取钱："+drawAmount);
				balance-=drawAmount;
				System.out.println("账户余额："+balance);
				Thread.sleep(10);
				flag=false;
				this.notifyAll();//唤醒其他所有线程
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//存款方法
	public synchronized void deposit(double depositAmount){
		try {
			//如果flag为真，表明账户中还没有人取钱出去，存钱方法阻塞
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
