package wzg;

public class DrawThread extends Thread{
	
	//�����ʺŵ����ã����������ڲ��Դ�����
	private Account account;
	//��ǰȡǮ�߳���ϣ��ȡ��Ǯ��
	private double drawAmount;
	
	
	public DrawThread(String name,Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	//�ظ����ȡǮ
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.draw(drawAmount);
		}
		
	}
}
