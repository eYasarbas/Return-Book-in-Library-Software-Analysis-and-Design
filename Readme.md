
# Use Case Return Book with Fines

- **Preconditions:** All books are issued. The member has the ability to pay the fine.
- **PostConditions:** The expired book is returned to the library.A borrower paid the fine because the book had expired.The library's records, returned books and punishments have been updated.

### Rules for the library system

| Rule Number | Rule |
|--------|------------------------------------------------------------------------------|
| Rule 1 | All books are available for checkout.|
| Rule 2 | A book can be checked out if it is available and has no holds.               |
| Rule 3 | A book can be renewed if there are no holds on it.                           |
| Rule 4 | If a book with a hold is returned, the appropriate member will be notified.  |
| Rule 5 | Holds can only be placed on books that are currently checked out.            |
| Rule 6 | The fine for a late book begins 10 days after the book is checked out:       |
|        | - Students will be charged 2 liras per day.                                  |
|        | - Teachers will be charged 3 liras per day.                                  |
|        | - If there is a hold on the book, the total fee will be doubled.              |

### Use Case Diagram

| Actions performed by the actor | Responses from the system                                                                                   |
|-------------------------------|-----------------------------------------------------------------------------------------------------------|
| 1. The member arrives at the return counter with a set of books and gives the clerk the books. |                                               |
| 2. The clerk issues a request to return books |  3. System asks for the member ID.                                                                           |
| 4. The clerk enters the member ID. | 5. The system searches for the member based on the entered ID. If the member is registered in the system, the system requests the book's ID. If the member is not registered, the system informs the person that they are not a member and terminates the process. |
| 6. The clerk enters a book ID. | 7. The system searches for the book based on the entered ID. If the book is registered in the system, the system calculates a fine according to rule 6 and displays the fine amount to the user. It then asks the user if they want to pay it. If the book is not registered, it informs the user and returns to step 6. |
| 8. The clerk says "Yes" or "No." | 9. If the user's response is "Yes," the payment is processed, the issue on the book is removed, and the transaction is added to the records. The system asks if there is another book. |
| 10. The clerk says "Yes" or "No." |                                                                                                           |

# Domin Model

![image](https://user-images.githubusercontent.com/65676107/220179111-54a32076-fd54-46e1-bd03-b8e095750e43.png)


It is sufficient to have five main classes in our system. The Library class is the most authoritative class, which can access other classes. The Memberlist and Catalog classes act as bridges to access and act on members and books, respectively. The Transaction class, on the other hand, can record all transactions made, allowing for data retention or possibly statistical processing in the future.

# Sequence Diagram

![image](https://user-images.githubusercontent.com/65676107/220179158-50124bfd-37a8-46e7-aed9-3f971f16b7ed.png)

**Controller:** The Library class serves as a controller in the system, separating the business and user interface layers. It coordinates all system operations and can be utilized in other usage scenarios as well. The class represents the entire library system.
**Creator:** The Member class applies the Creator pattern by creating a Transaction object when a fine is added. Since the Member class has a list of transactions to keep track of the transactions made by a member, it is appropriate for the Member class to be responsible for creating new Transaction objects
**Information Expert:**  The computeFine method is added to the Book class in accordance with the Information Expert pattern since the Book class has all the necessary information (such as the due date, acquisition date, and hold status) to compute the fine. This responsibility is therefore assigned to the Book class.
**High Cohesion:** Assigning the responsibility of computing the fine to the Book class and the responsibility of adding the fine to the Member class supports high cohesion. By doing this, we were able to delegate the appropriate operations to related classes and increase cohesion.
**Low Coupling:** The decision to assign the responsibility of computing the fine to the Book class also supports low coupling. If we had chosen a different class for this responsibility, it would create unnecessary coupling between the Book class and the other class.
