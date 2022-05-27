package tight_coupling_1;

public class Subject {
	private Topic topic;
	
	public Subject() {
		this.topic = new Topic();
	}
	
	public void startReading() {
		this.topic.understand();
	}
}
