package com.bo.database.utils;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
//import java.util.LinkedList;

//import oracle.sql.CLOB;

import com.bo.loggers.MiddlewareLogger;


public abstract class DBUtil {
	MiddlewareLogger logger = null;

	public static final boolean PREPARED = true;
	public static final boolean CALLABLE = false;

	protected Connection conn;
	protected PreparedStatement prep;	
	protected ResultSet rset;
	private boolean mode = PREPARED;
	private String sql;
	protected DBContext context = null;
	private int argsCount = 0; 
	private ArrayList<Integer> argList = new ArrayList<Integer>();

	protected DBUtil(DBContext context) {
		logger = MiddlewareLogger.getInstance(this.getClass().getSimpleName());
		logger.logDebug("#()");
		prep = null;
		rset = null;
		mode = PREPARED;
		this.context = context;		
	}

	public String getSql() {
		return sql;
	}
	
	public void setArgsCount(int argsCount) {
		this.argsCount = argsCount;
		for(int li=0;li<argsCount;li++)
			argList.add(li+1);
	}
	
	public void resetArgsList() {
		argList.clear();
		for(int li=0;li<argsCount;li++)
			argList.add(li+1);
	}

	/*public void setClob(int index, String value) throws SQLException {
		prep.setClob(index, getCLOB(value));
	}*/

	public Clob getClob(int index) throws SQLException {
		return ((CallableStatement) prep).getClob(index);
	}

	public void setInt(int index, int value) throws SQLException {
		prep.setInt(index, value);
	}

	public int getInt(int index) throws SQLException {
		return ((CallableStatement) prep).getInt(index);
	}

	public void setLong(int index, long value) throws SQLException {
		prep.setLong(index, value);
	}

	public long getLong(int index) throws SQLException {
		return ((CallableStatement) prep).getLong(index);
	}

	public void setBigDecimal(int index, BigDecimal value) throws SQLException {
		prep.setBigDecimal(index, value);
	}		

	public BigDecimal getBigDecimal(int index) throws SQLException {
		return ((CallableStatement) prep).getBigDecimal(index);
	}

	public void setDouble(int index, double value) throws SQLException {
		prep.setDouble(index, value);
	}

	public double getDouble(int index) throws SQLException {
		return ((CallableStatement) prep).getDouble(index);
	}

	public void setFloat(int index, float value) throws SQLException {
		prep.setFloat(index, value);
	}

	public float getFloat(int index) throws SQLException {
		return ((CallableStatement) prep).getFloat(index);
	}

	public void setString(int index, String value) throws SQLException {
		prep.setString(index, value);
		if(argList.size()>0)
		argList.remove(new Integer(index));
	}

	public String getString(int index) throws SQLException {
		return ((CallableStatement) prep).getString(index);
	}

	public void setDate(int index, Date value) throws SQLException {
		prep.setDate(index, value);
	}

	public Date getDate(int index) throws SQLException {
		return ((CallableStatement) prep).getDate(index);
	}

	public void setBytes(int index, byte[] value) throws SQLException {
		prep.setBytes(index, value);
	}

	public byte[] getBytes(int index) throws SQLException {
		return ((CallableStatement) prep).getBytes(index);
	}

	public void setBoolean(int index, boolean value) throws SQLException {
		prep.setBoolean(index, value);
	}

	public boolean getBoolean(int index) throws SQLException {
		return ((CallableStatement) prep).getBoolean(index);
	}

	public void setNull(int index, int type) throws SQLException {
		prep.setNull(index, type);
	}

	public void setTimestamp(int index, java.sql.Timestamp time) throws SQLException {
		prep.setTimestamp(index, time);
	}

	public Timestamp getTimestamp(int index) throws SQLException {
		return ((CallableStatement) prep).getTimestamp(index);
	}

	public void registerOutParameter(int index, int type) throws SQLException {
		((CallableStatement) prep).registerOutParameter(index, type);
	}

	public ResultSet executeQuery() throws SQLException {
		rset = prep.executeQuery();
		return (rset);
	}

	public int executeUpdate() throws SQLException {
		for(Integer i:argList) {
			prep.setString(i,null);
		}
		return (prep.executeUpdate());
	}

	public boolean execute() throws SQLException {
		return (prep.execute());
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}

	public void reset() {
		logger.logDebug("reset()");
		subclose();
		setMode(PREPARED);
	}

	public void setSql(String sql) throws SQLException {
		this.sql = sql;
		if (conn == null) {
			conn = context.openConnection();
		}
		if (mode == PREPARED) {
			prep = conn.prepareStatement(sql);
		} else {
			prep = conn.prepareCall(sql);
		}
	}
	
public void addBatch() throws SQLException {
		
		for(Integer i:argList) {
			prep.setString(i,null);
		}
		if(mode == PREPARED)  {
			prep.addBatch();
		}
		
	} 
public void setFetchSize(int size) throws SQLException {
	
	if(size>0){
		prep.setFetchSize(size);
	}
	
	
}
public void clearParameters() throws SQLException {
	
	if (mode == PREPARED) {
		prep.clearParameters();
	}
	
}
	
	public int[] executeBatch() throws SQLException {
		
		int[] result = {0};
		
		if(mode == PREPARED)  {
			result = prep.executeBatch();
		}
		
		return result;
		
	}

	private void subclose() {
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rset = null;
		}
		if (prep != null) {
			try {
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			prep = null;
		}
	}

	/*@SuppressWarnings("deprecation")
	private CLOB getCLOB(String xmlData) {
		CLOB tempClob = null;
		try {
			Connection jbossConn = ((WrappedConnection) this.conn).getUnderlyingConnection();
			tempClob = CLOB.createTemporary(jbossConn, false, CLOB.DURATION_SESSION);
			tempClob.putString(1, xmlData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError(" getCLOB() - " + e.getLocalizedMessage());
			try {
				tempClob.freeTemporary();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return tempClob;
	}*/
}
