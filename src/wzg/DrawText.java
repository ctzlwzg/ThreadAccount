package wzg;

public class DrawText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建账户，即共同资源，
		Account a=new Account();
		//new Thread(new DrawThread(a, 500), "wzsg").start();
		//new Thread(new DepositThread(a, 500), "ctzl").start();
		new DrawThread("wzg", a, 500).start();
		new DepositThread("存款者1", a, 500).start();
		new DepositThread("存款者2", a, 500).start();
	}

}
