import io.muserver.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Booking;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        // Add some test bookings
        bookings.add(new Booking("Alice", 4, "2023-12-25", "18:00"));
        bookings.add(new Booking("Bob", 2, "2023-12-25", "20:00"));

        MuServer server = MuServerBuilder.httpServer()
                .withHttpPort(3000)
                .addHandler(Method.POST, "/bookings", (request, response, pathParams) -> {
                    try {
                        Booking booking = objectMapper.readValue(request.readBodyAsString(), Booking.class);
                        bookings.add(booking);
                        response.status(201); // 201 Created
                        response.write(objectMapper.writeValueAsString(booking));
                        logger.info("New booking created: {}", booking);
                    } catch (Exception e) {
                        response.status(400);
                        response.write("Invalid booking data: " + e.getMessage());
                        logger.error("Bad booking request", e);
                    }
                })
                .addHandler(Method.GET, "/bookings/{date}", (request, response, pathParams) -> {
                    String date = pathParams.get("date");
                    List<Booking> results = new ArrayList<>();
                    for (Booking b : bookings) {
                        if (b.getDate().equals(date)) results.add(b);
                    }
                    response.write(objectMapper.writeValueAsString(results));
                    logger.info("Returned {} bookings for date {}", results.size(), date);
                })
                .start();

        logger.info("Server started at {}", server.uri());
        System.out.println("Server started at " + server.uri());
    }
}