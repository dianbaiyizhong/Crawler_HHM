package org.hhm.crawler.pojo.db;

public class Taskinfo implements java.io.Serializable {

	// Fields

	private static Integer taskId;

	public static Integer getTaskId() {
		return taskId;
	}

	public static void setTaskId(Integer taskId) {
		Taskinfo.taskId = taskId;
	}

	public static String getTaskName() {
		return taskName;
	}

	public static void setTaskName(String taskName) {
		Taskinfo.taskName = taskName;
	}

	public static String getTaskDescription() {
		return taskDescription;
	}

	public static void setTaskDescription(String taskDescription) {
		Taskinfo.taskDescription = taskDescription;
	}

	public static String getInfoDb() {
		return infoDb;
	}

	public static void setInfoDb(String infoDb) {
		Taskinfo.infoDb = infoDb;
	}

	public static String getSourceFileSave() {
		return sourceFileSave;
	}

	public static void setSourceFileSave(String sourceFileSave) {
		Taskinfo.sourceFileSave = sourceFileSave;
	}

	public static String getSourceFileDb() {
		return sourceFileDb;
	}

	public static void setSourceFileDb(String sourceFileDb) {
		Taskinfo.sourceFileDb = sourceFileDb;
	}

	public static String getInfoUpdateServer() {
		return infoUpdateServer;
	}

	public static void setInfoUpdateServer(String infoUpdateServer) {
		Taskinfo.infoUpdateServer = infoUpdateServer;
	}

	public static String getTaskBeginTime() {
		return taskBeginTime;
	}

	public static void setTaskBeginTime(String taskBeginTime) {
		Taskinfo.taskBeginTime = taskBeginTime;
	}

	public static String getTaskRemark() {
		return taskRemark;
	}

	public static void setTaskRemark(String taskRemark) {
		Taskinfo.taskRemark = taskRemark;
	}

	public static String getStartTime() {
		return startTime;
	}

	public static void setStartTime(String startTime) {
		Taskinfo.startTime = startTime;
	}

	public static String getStopTime() {
		return stopTime;
	}

	public static void setStopTime(String stopTime) {
		Taskinfo.stopTime = stopTime;
	}

	public static String getOperateType() {
		return operateType;
	}

	public static void setOperateType(String operateType) {
		Taskinfo.operateType = operateType;
	}

	public static String getTotalDataSize() {
		return totalDataSize;
	}

	public static void setTotalDataSize(String totalDataSize) {
		Taskinfo.totalDataSize = totalDataSize;
	}

	public static String getLastGathDateSize() {
		return lastGathDateSize;
	}

	public static void setLastGathDateSize(String lastGathDateSize) {
		Taskinfo.lastGathDateSize = lastGathDateSize;
	}

	public static String getTaskState() {
		return taskState;
	}

	public static void setTaskState(String taskState) {
		Taskinfo.taskState = taskState;
	}

	private static String taskName;
	private static String taskDescription;

	public static Integer getGatherThread() {
		return gatherThread;
	}

	public static void setGatherThread(Integer gatherThread) {
		Taskinfo.gatherThread = gatherThread;
	}

	private static Integer gatherThread;
	private static String infoDb;
	private static String sourceFileSave;
	private static String sourceFileDb;
	private static String infoUpdateServer;
	private static String taskBeginTime;
	private static String taskRemark;
	private static String startTime;
	private static String stopTime;
	private static String operateType;
	private static String totalDataSize;
	private static String lastGathDateSize;
	private static String taskState;

}