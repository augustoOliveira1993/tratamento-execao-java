package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public long duration() {
		long diff = this.checkout.getTime() - this.checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			return "Reservation date for update must be future dates.";
		}
		if(!checkout.after(checkin)) {
			return "Check-out date must be after check-in.";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Room: ");
		sb.append(this.roomNumber);
		sb.append(", check-in: ");
		sb.append(sdf.format(checkin));
		sb.append(", check-out: ");
		sb.append(sdf.format(this.checkout));
		sb.append(", ");
		sb.append(this.duration());
		sb.append(" nights");
		return sb.toString();
	}
}
