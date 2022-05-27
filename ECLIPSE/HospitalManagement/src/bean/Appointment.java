package bean;

public class Appointment {
	private int id;
	private int patientId;
	private int doctorId;
	private Patient patientObj;
	private Doctor doctorObj;
	private String details;
	private String appointedDate;
	private String status;
	private String createdAt;
	
	public Appointment(){
	}

	public Appointment(int id, int patientId, int doctorId, String details, String appointedDate, String status, String createdAt) {
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.details = details;
		this.appointedDate = appointedDate;
		this.status = status;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAppointedDate() {
		return appointedDate;
	}

	public void setAppointedDate(String appointedDate) {
		this.appointedDate = appointedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Patient getPatientObj() {
		return patientObj;
	}

	public void setPatientObj(Patient patientObj) {
		this.patientObj = patientObj;
	}

	public Doctor getDoctorObj() {
		return doctorObj;
	}

	public void setDoctorObj(Doctor doctorObj) {
		this.doctorObj = doctorObj;
	}
}
