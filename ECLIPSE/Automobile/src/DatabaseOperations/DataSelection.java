package DatabaseOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.jdi.connect.Connector.SelectedArgument;

import Models.AccidentModel;
import Models.AgentModel;
import Models.AutoModel;

public class DataSelection {
	private Connection connection;
	private Statement selectionStatement;
	
	private ArrayList<AutoModel> autoModelArrayList = new ArrayList<AutoModel>();
	private ArrayList<AgentModel> agentModelArrayList = new ArrayList<AgentModel>();
	private ArrayList<AccidentModel> accidentModelArrayList = new ArrayList<AccidentModel>();
	private String[] accidentDetailModelDataArray;
	
	public DataSelection() {
		// creating the statement 
		try {
			connection = Connect.getConnectionInstance().getConnection();
			selectionStatement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Get all autos
	public ArrayList<AutoModel> GetAllAutosFromDatabase(){
		try {
			ResultSet resultSet = selectionStatement.executeQuery("SELECT * FROM autos;");
			while(resultSet.next()) {
				AutoModel autoModel = new AutoModel();
				autoModel.SetVechileIdentityNo(resultSet.getString("vin"));
				autoModel.SetMake(resultSet.getString("make"));
				autoModel.SetYear(resultSet.getInt("year"));
				autoModel.SetAgentSSN(resultSet.getString("agent_ssn"));
				
				// adding the object to the arraylist
				autoModelArrayList.add(autoModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return the list 
		return autoModelArrayList;
	}
	
	// Get all agentModels
	public ArrayList<AgentModel> GetAllAgentsFromDatabase(){
		try {
			ResultSet resultSet = selectionStatement.executeQuery("SELECT ssn, salary FROM agents;");
			while(resultSet.next()) {
				AgentModel agentModel = new AgentModel();
				agentModel.SetSSN(resultSet.getString("ssn"));
				agentModel.SetSallery(resultSet.getFloat("salary"));
				
				// adding the object to the arraylist
				agentModelArrayList.add(agentModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return the list
		return agentModelArrayList;
	}
	
	// Get all the AccidentData
	public ArrayList<AccidentModel> GetAllAccidentFromDatabase(){
		try {
			ResultSet resultSet = selectionStatement.executeQuery("SELECT * FROM accidents;");
			while(resultSet.next()) {
				AccidentModel accidentModel = new AccidentModel();
				accidentModel.SetAccidentId(resultSet.getInt("aid"));
				accidentModel.SetDate(resultSet.getDate("accident_date").toString());
				accidentModel.SetCity(resultSet.getString("city"));
				accidentModel.SetState(resultSet.getString("state"));
				
				// adding the object to the arraylist
				accidentModelArrayList.add(accidentModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accidentModelArrayList;
	}
	
	// Get all the AccidentData between date ranges
		public ArrayList<AccidentModel> GetAllAccidentFromDatabaseInDateRange(String startDate, String endDate){
			try {
				String sql = "SELECT * FROM accidents WHERE accident_date BETWEEN '" + startDate + "' and '" + endDate + "';";
				ResultSet resultSet = selectionStatement.executeQuery(sql);
				while(resultSet.next()) {
					AccidentModel accidentModel = new AccidentModel();
					accidentModel.SetAccidentId(resultSet.getInt("aid"));
					accidentModel.SetDate(resultSet.getDate("accident_date").toString());
					accidentModel.SetCity(resultSet.getString("city"));
					accidentModel.SetState(resultSet.getString("state"));
					
					// adding the object to the arraylist
					accidentModelArrayList.add(accidentModel);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return accidentModelArrayList;
		}
	
	
	// Get all general detail on the accident data list
	public String[] GetAllGeneralAccidentFromDatabase(int accidentId){
		try {
			accidentDetailModelDataArray = new String[8];
			String sql = "SELECT accidents.aid as AccidentId, city, state, accident_date, involvements.aid as InvAid, vin, damages, driver_ssn FROM accidents INNER JOIN involvements ON involvements.aid = accidents.aid WHERE accidents.aid = " + accidentId + ";";
			ResultSet resultSet = selectionStatement.executeQuery(sql);
			while(resultSet.next()) {
				accidentDetailModelDataArray[0] = String.valueOf(resultSet.getInt("AccidentId"));
				accidentDetailModelDataArray[1] = resultSet.getString("city");
				accidentDetailModelDataArray[2] = resultSet.getString("state");
				accidentDetailModelDataArray[3] = resultSet.getDate("accident_date").toString();
				accidentDetailModelDataArray[4] = String.valueOf(resultSet.getInt("InvAid"));
				accidentDetailModelDataArray[5] = resultSet.getString("vin");
				accidentDetailModelDataArray[6] = String.valueOf(resultSet.getFloat("damages"));
				accidentDetailModelDataArray[7] = resultSet.getString("driver_ssn");
			}
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accidentDetailModelDataArray;
	}
}
