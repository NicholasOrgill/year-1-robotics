package interfaces;

public interface IRouteExecuter extends Runnable {

		public int getDelay();
		public void setDelay(int _delay);
		public void returnMessage(IMessage _msg);
		
}
