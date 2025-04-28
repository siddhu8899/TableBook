package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookingsByDate(String date) {
        return bookings.stream()
                .filter(booking -> booking.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }
}