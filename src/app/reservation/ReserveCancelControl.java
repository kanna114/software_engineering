/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.reservation;

import java.util.Date;

import app.AppException;
import app.ManagerFactory;
import domain.reservation.ReservationManager;
import domain.reservation.ReservationException;
import domain.room.RoomManager;
import domain.room.RoomException;

/**
 * Control class for Reserve Room
 * 
 */
public class ReserveCancelControl {

	public int cancelReservation(String resvnum) throws AppException {
		//Permitting only one night so that change amount of availableQty is always -1
		int availableQtyOfChange = -1;
		try {

			//Create reservation
			ReservationManager reservationManager = getReservationManager();
			int status = reservationManager.cancelReservation(resvnum);

			return 0;
		}
		catch (ReservationException e) {
			AppException exception = new AppException("Failed to cancel a reserve", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
	}


	private ReservationManager getReservationManager() {
		return ManagerFactory.getInstance().getReservationManager();
	}
}
