package com.bo.utils;

import java.sql.Types;

import com.bo.bean.PgmLogBean;
import com.bo.database.utils.DBContext;
import com.bo.database.utils.DBUtil;

public class EventsUtil {

	private DBContext dbContext;

	public EventsUtil() {

	}

	public EventsUtil(DBContext dbContext) {
		this.dbContext = dbContext;
	}

	public DBContext getDbContext() {
		return dbContext;
	}

	public void generateProgramLog(PgmLogBean pgmLogBean, String entityNum,DBContext dbContext) throws Exception {
		
		DBUtil dbUtil = dbContext.createUtilInstance();
		
		try {
			
			dbUtil.reset();
			String sql = "{CALL PKG_EVTS_PGMLOG.SP_GEN_PGMLOG(?,?,?,?,?)}";

			dbUtil.setMode(DBUtil.CALLABLE);
			dbUtil.setSql(sql);
			dbUtil.setString(1, entityNum);
			dbUtil.setString(2, pgmLogBean.getProgramID());
			dbUtil.setString(3, pgmLogBean.getSourceTable());
			dbUtil.setString(4, pgmLogBean.getSourceKey());
			dbUtil.registerOutParameter(5, Types.VARCHAR);
			dbUtil.executeUpdate();
			String result = dbUtil.getString(5);
			System.out.println(result);
			if (!(result != null && result.equals("000"))) {
				throw new Exception("");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			dbUtil.reset();
		}

	}

}
