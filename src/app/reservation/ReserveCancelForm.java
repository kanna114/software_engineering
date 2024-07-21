/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.reservation;

import java.util.Date;

import app.AppException;

/**
 * Form class for Reserve Room
 * 
 */
public class ReserveCancelForm {

	private ReserveCancelControl reserveCancelHandler = new ReserveCancelControl();

	String resvnum;

	private ReserveCancelControl getReserveCancelHandler() {
		return reserveCancelHandler;
	}

	public int cancelReservation() throws AppException {
		ReserveCancelControl reserveCancelHandler = getReserveCancelHandler();
		return reserveCancelHandler.cancelReservation(resvnum);
	}



	public void setResvNum(String resv) {
		this.resvnum = resv;
	}

}
