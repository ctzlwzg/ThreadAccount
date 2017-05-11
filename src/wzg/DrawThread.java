package wzg;

public class DrawThread extends Thread{
	
	//创建帐号的引用，创建对象在测试代码中
	private Account account;
	//当前取钱线程所希望取的钱数
	private double drawAmount;
	
	
	public DrawThread(String name,Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	//重复多次取钱
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.draw(drawAmount);
		}
		
	}
}
