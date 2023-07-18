# Event Ticket Booking Exercises

This Java project represents a simple ticket booking service and contains practice tasks on various topics.

## Domain

### User
#### Properties
- `Long id`
- `String name`
- `String email`
#### Relationships
- `UserAccount account`: The user's account (one-to-one relationship)

### UserAccount
#### Properties
- `Long id`
- `Double money`: The amount of money in the user's account

### Event
#### Properties
- `Long id`
- `String title`
- `Date date`: The event's date (format 'yyyy-MM-dd')
- `double ticketPrice`: The price of a ticket for the event
#### Relationships
- `List<Ticket> tickets`: A list of tickets for the event (one-to-many relationship)

### Ticket
#### Properties
- `Long id`
- `int place`: The seat number for the ticket
- `boolean cancelled`: Indicates whether the ticket has been cancelled
#### Relationships
- `Event event`: The event the ticket is for (one-to-one relationship)
- `User user`: The user who owns the ticket (one-to-one relationship)
- `Category category`: The ticket's category (one-to-one relationship)

### Category
#### Enumerations
- `STANDARD`: Standard ticket category
- `ADVANCED`: Advanced ticket category
- `PREMIUM`: Premium ticket category

## Exercises
- Unit tests exercise: To work on this exercise, run `git checkout unit-tests-exercise`
- Integration tests exercise: To work on this exercise, run `git checkout integration-tests-exercise`