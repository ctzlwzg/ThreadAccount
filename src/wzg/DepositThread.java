package wzg;

public class DepositThread extends Thread{
	
	//�����ʺŵ����ã����������ڲ��Դ�����
	private Account account;
	//��ǰ��ȡ�߳���ϣ�����Ǯ��
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
