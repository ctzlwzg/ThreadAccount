package wzg;

public class DepositThread extends Thread{
	
	//创建帐号的引用，创建对象在测试代码中
	private Account account;
	//当前存取线程所希望存的钱数
	private double depositAmount;
	
	public DepositThread(String name,Account account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}
}
