package model.mainapp;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

import model.shared.CheckInOut;

public interface storesCheckInOut {
	/**
	 * @param beforeCheck
	 * @param afterCheck
	 * @return
	 */
	public CopyOnWriteArrayList<CheckInOut> searchCheckInOut(LocalDateTime beforeCheck, LocalDateTime afterCheck);
}
