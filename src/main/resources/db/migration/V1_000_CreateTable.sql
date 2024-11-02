-- Users table
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       surname VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       phone_number VARCHAR(20),
                       role VARCHAR(20) NOT NULL,
                       created_at TIMESTAMP,
                       profile_picture_url VARCHAR(255),
                       birthdate DATE,
                       is_approved BOOLEAN DEFAULT false
);

-- Events table
CREATE TABLE events (
                        event_id SERIAL PRIMARY KEY,
                        organizer_id INT REFERENCES users(user_id), -- Assuming organizers are also users
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        category VARCHAR(50),
                        location VARCHAR(255),
                        event_date TIMESTAMP,
                        status VARCHAR(20) NOT NULL,
                        created_at TIMESTAMP,
                        max_capacity INT,
                        min_age INT
);

-- Tickets table
CREATE TABLE tickets (
                         ticket_id SERIAL PRIMARY KEY,
                         event_id INT REFERENCES events(event_id),
                         ticket_type VARCHAR(50) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         quantity INT NOT NULL,
                         created_at TIMESTAMP
);

-- Reservations table
CREATE TABLE reservations (
                              reservation_id SERIAL PRIMARY KEY,
                              user_id INT REFERENCES users(user_id),
                              event_id INT REFERENCES events(event_id),
                              ticket_id INT REFERENCES tickets(ticket_id),
                              reservation_date TIMESTAMP,
                              status VARCHAR(20) NOT NULL
);

-- Payments table
CREATE TABLE payments (
                          payment_id SERIAL PRIMARY KEY,
                          reservation_id INT REFERENCES reservations(reservation_id),
                          user_id INT REFERENCES users(user_id),
                          amount DECIMAL(10, 2) NOT NULL,
                          payment_date TIMESTAMP,
                          payment_method VARCHAR(50),
                          status VARCHAR(20) NOT NULL
);

-- Notifications table
CREATE TABLE notifications (
                               notification_id SERIAL PRIMARY KEY,
                               user_id INT REFERENCES users(user_id),
                               message TEXT NOT NULL,
                               sent_at TIMESTAMP,
                               type VARCHAR(50)
);

-- Event Categories table
CREATE TABLE event_categories (
                                  category_id SERIAL PRIMARY KEY,
                                  name VARCHAR(255) NOT NULL,
                                  description TEXT
);

-- Discounts table
CREATE TABLE discounts (
                           discount_id SERIAL PRIMARY KEY,
                           event_id INT REFERENCES events(event_id),
                           ticket_id INT REFERENCES tickets(ticket_id),
                           discount_percentage DECIMAL(5, 2) NOT NULL,
                           start_date DATE NOT NULL,
                           end_date DATE NOT NULL
);
