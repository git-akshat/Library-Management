## Library Management System

#### The objective of this project is to learn Swing and jdbc.

### The Library Management system provides following functionalities

* Login
* Add a book
* Search a Book based on Book Title
* Search Books based on Category
* Search Books based on Author
* List All Books along with author information
* Issue Book to Student
* List Books issued to Student based on USN number 
* List books which are to be returned for current date

### Database Design

Book Table  | ------------------
----------- | ------------------
Book ISBN	| Primary key
Book Title	| Varchar
Category	| Varchar
No of Books	| int


Author Table	| ----------------------
------------ 	| ----------------------	 
Author Name	 	| Varchar
Author Mail Id	| Varchar
Book ISBN		| Foreign KEY, References Book



Student Table | --------------------
------------- | --------------------
USN			  | Varchar, Primary Key
Name		  | Varchar



Book ISSUE Table | --------------------------------
---------------	 | --------------------------------
Issue ID		 | Auto Increment, Primary Key
USN				 | Foreign Key, References Student
Issued Date		 | Date
Return Date		 | Date
Book ISBN		 | Foreign Key, References Book 



ADMIN Table		| --------------------
--------------- | --------------------
Admin Id		| Varchar, Primary key
Password		| 

### Screenshots

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/login1.png)
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/add_book.png)
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/search_book.png)
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/list_all_books.png)
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/issue_book.png)
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/issue_book_2.png)
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/list_issued_books.png)
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/book_to_return.png)
