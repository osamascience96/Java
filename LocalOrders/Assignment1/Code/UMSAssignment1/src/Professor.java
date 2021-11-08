public class Professor extends Person
{
	private String researchTopics;
	
	public Professor(String fn, int rn, String em, String rt) {
		super(rt, rn, em);
		this.researchTopics = rt;
	}
	
	/**
	 * @return the researchTopics
	 */
	public String getResearchTopics(){
		return researchTopics;
	}
	/**
	 * Set/change the researchTopics
	 * @param em The new researchTopics
	 */
	public void setResearchTopics(String rt) {
		this.researchTopics = rt;
	}
	
	public String toString() {
		return "Professor: " + this.fullname; 
	}
}
