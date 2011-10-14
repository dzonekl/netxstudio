package com.netxforge.netxstudio.data.job;

import com.netxforge.netxstudio.scheduling.JobRunState;

public interface IRunMonitor {

	public abstract void appendToLog(String logStatement);

	public abstract String getLog();

	public abstract void incrementProgress(int inc, boolean update);

	public abstract int getProgress();

	public abstract int getTotalWork();

	public abstract void setTotalWork(int totalWork);

	public abstract int getWorkDone();

	public abstract void setWorkDone(int workDone);

	public abstract String getMsg();

	public abstract void setMsg(String msg);

	public abstract String getTask();

	public abstract void setTask(String task);

	public abstract void setStartRunning();

	public abstract void setFinished(JobRunState state, Throwable t);

}