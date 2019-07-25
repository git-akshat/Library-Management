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
Password		| 

</br>
</br>


### Screenshots

1. Login Screen
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/login1.png)

</br>
</br>

2. Add new Book
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/add_book.png)

</br>
</br>

3.Search Book
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/search_book.png)

</br>
</br>

![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/list_all_books.png)

</br>
</br>

4. Issue Book - 1
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/issue_book.png)

</br>
</br>

5. Issue Book - 2
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/issue_book_2.png)

</br>
</br>

6. List Issued Books
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/list_issued_books.png)

</br>
</br>

7. List Books to be returned on current Date
![picture alt](https://github.com/git-akshat/Library-Management/blob/master/screenshots/book_to_return.png)
