## Library Management System

#### The objective of this project is to learn Swing and jdbc.

### The Library Management system provides following functionalities:

* Login
* Add a book
* Search a Book based on Book Title
* Search Books based on Category
* Search Books based on Author
* List All Books along with author information
* Issue Book to Student
* List Books issued to Student based on USN number 
* List books which are to be returned for current date

### Working

* A user can add book by providing the following information, title, ISBN (Book Number), category and Author information (Author Name and Phone Number).
* Book search can be based on book title, or category or Author, when a book is found, entire information has to be printed on the screen. Partial searches to be supported (for example, if user searches by ‘ja’, ‘Java Complete Reference’, ‘Head First Java’ books) should be displayed.
* A user can list all books present in the library and also the books issued to the students using their USN number.
* A book can be issued to a student by first selecting a book from list of books and then selecting the student from the list of partial or complete search result. Also the date of issue is saved while issuing and return date is calculated (i.e. 7 days from issue date).
* Also if the book is not in library, the user should be informed about the unavailability of the book.


### Database Design

Book Table  | -
----------- | ------------------
Book ISBN	| Primary key
Book Title	| Varchar
Category	| Varchar
No of Books	| int

</br>

Author Table	| -
------------ 	| ----------------------	 
Author Name	 	| Varchar
Author Mail Id	| Varchar
Book ISBN		| Foreign KEY, References Book

</br>

Student Table | -
------------- | --------------------
USN			  | Varchar, Primary Key
Name		  | Varchar

</br>

Book ISSUE Table | -
---------------	 | --------------------------------
Issue ID		 | Auto Increment, Primary Key
USN				 | Foreign Key, References Student
Issued Date		 | Date
Return Date		 | Date
Book ISBN		 | Foreign Key, References Book 

</br>

ADMIN Table		| -
--------------- | --------------------
Admin Id		| Varchar, Primary key
Password		| Varchar

</br>
</br>


### Screenshots

* Login Screen

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/login1.png)

</br>
</br>

* Add new Book

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/add_book.png)

</br>
</br>

* Search Book

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/search_book.png)

</br>
</br>

* List all Books

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/list_all_books.png)

</br>
</br>

* Issue Book-1

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/issue_book.png)

</br>
</br>

* Issue Book-2

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/issue_book_2.png)

</br>
</br>

* List Issued Books

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/list_issued_books.png)

</br>
</br>

* List Books to be returned on current Date

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/book_to_return.png)

</br>
</br>

### Tools and Technology used

*	Programming language → java 8
*	Netbeans IDE
*	MariaDB(MySqL) [database](https://github.com/git-akshat/Library-Management/blob/master/Database_Query/bookDB.txt) 

### Reference Link: 
[How to create a cardLayout with netbeans GUI Builder](https://stackoverflow.com/questions/21898425/how-to-use-cardlayout-with-netbeans-gui-builder)

### Demo
* Install MariaDB and follow the steps given in [this](https://github.com/git-akshat/Library-Management/blob/master/Database_Query/bookDB.txt) file.
* Now download this project and go to [dist folder](https://github.com/git-akshat/Library-Management/tree/master/dist)
* Double click on LibraryManagement.jar and here you go :)