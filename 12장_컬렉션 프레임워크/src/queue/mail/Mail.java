package queue.mail;

public class Mail {
	private String toSome; 		//사람이름
	private String mailTitle;	//메일제목
	
	public Mail(String toSome, String mailTitle) {
		super();
		this.toSome = toSome;
		this.mailTitle = mailTitle;
	}

	public String getToSome() {
		return toSome;
	}

	public String getMailTitle() {
		return mailTitle;
	}

	@Override
	public String toString() {
		return "Mail [toSome=" + toSome + ", mailTitle=" + mailTitle + "]";
	}
	
	
}
