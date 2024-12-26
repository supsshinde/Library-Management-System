package org.Lms.clientApp;

import java.util.*;

import org.techhub.Model.BookModel;
import org.techhub.Model.CategoryModel;
import org.techhub.Service.BookService;
import org.techhub.Service.BookServiceImpl;
import org.techhub.Service.CategoryService;
import org.techhub.Service.CategoryServiceImpl;
import org.techhub.Service.UserService;
import org.techhub.Service.UserServiceImpl;
import org.techhub.Model.UserModel;

public class LibrayManagmentSystem
{
	public static void main(String[] args)
	{
		int ch, ch1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to our Library Management System");
		CategoryService categoryservice = new CategoryServiceImpl();
		CategoryModel model = new CategoryModel();

		BookService bookservice = new BookServiceImpl();
		BookModel model2 = new BookModel();

		UserService userservice = new UserServiceImpl();
		UserModel model3 = new UserModel();

		do {
			System.out.println("1.Admin login");
			System.out.println("2.User Login");
			System.out.println("Enter your choice:- ");
			ch = sc.nextInt();

			String username = "Admin";
			int password = 111;

			switch (ch) {
			case 1:
				System.out.println("Enter Admin login details:");
				System.out.println("Enter the User_name:- ");
				String user = sc.next();
				System.out.println("Enter the password:- ");
				int pass = sc.nextInt();
				if (pass == password && username.equals(user)) {
					System.out.println("Login is succesful...\n\n");

					do {
						System.out.println("1:Add categories of book in Library.");
						System.out.println("2:View All Catogary");
						System.out.println("3:Delete Category.");
						System.out.println("4:Serach Category");
						System.out.println("5:Update Category");

						System.out.println("6:Add Books");
						System.out.println("7:View Books.");
						System.out.println("8:Update Books records");
						System.out.println("9:Search Books.");
						System.out.println("10:Delete Books.");

						System.out.println("11:View Users.");
						System.out.println("12:Search user");
						System.out.println("13:Remove or delete user");
						System.out.println("14:Update user records");
						System.out.println("15:EXIT");
						ch1 = sc.nextInt();
						switch (ch1) {
						case 1:
							System.out.println("Enter category name to add in library");
							sc.nextLine();
							String Cname = sc.nextLine();
							model.setCname(Cname);
							boolean b = categoryservice.isCategoryPresent(Cname);
							if (b) {
								System.out.println("Category already present");
							} else {
								System.out.println("You want to add this Add category:");
								System.out.println("1:YES");
								System.out.println("2:NO");
								int choice = sc.nextInt();
								switch (choice) {
								case 1:
									boolean flag = categoryservice.isAddNewCategory(model);
									if (flag) {
										System.out.println("Category Added sucessfully");
									} else {
										System.out.println("Something went wrong..");
									}
									break;

								case 2:
									System.out.println("Thank u for response");
									break;

								default: {
									System.out.println("Invalid choice");
								}
								}
							}
							break;

						case 2:
							List<CategoryModel> list = categoryservice.getAllCategory();
							if (!list.isEmpty()) {
								for (CategoryModel s : list) {
									System.out.println(s.getCId() + "\t" + s.getCname());
								}
							} else {
								System.out.println("Data is not available");
							}
							break;

						case 3:
							System.out.println("Enter category name for delete:");
							sc.nextLine();
							String Cname1 = sc.nextLine();

							boolean b1 = categoryservice.deleteCategoryByName(Cname1);

							if (b1) {
								System.out.println("Category Deleted Successfully....");
							} else {
								System.out.println("Category Not Found");
							}
							break;

						case 4:
							System.out.println("Enter category name for search:");
							sc.nextLine();
							String SearchCategory = sc.nextLine();
							boolean b2 = categoryservice.searchCategoryByName(SearchCategory);
							if (b2) {
								System.out.println("Category Found");
							} else {
								System.out.println("Category Not Found");
							}
							break;

						case 5:
							List<CategoryModel> list1 = categoryservice.getAllCategory();
							if (!list1.isEmpty()) {
								for (CategoryModel s : list1) {
									System.out.println(s.getCId() + "\t" + s.getCname());
								}
							} else {
								System.out.println("Data is not available");
							}
							System.out.println("Enter present category name for update:");
							sc.nextLine();
							String presentCategory = sc.nextLine();
							System.out.println("Enter new category name for update:");
							String updateCategory = sc.nextLine();

							boolean b3 = categoryservice.updateCategoryByName(presentCategory, updateCategory);
							if (b3) {
								System.out.println("Category Updated");
							} else {
								System.out.println("Category Not Updated");
							}

							break;

						case 6:
							System.out.println("Enter category name where you want to add book");
							sc.nextLine();
							String CatName = sc.nextLine();
							boolean b5 = categoryservice.searchCategoryByName(CatName);
							int id = categoryservice.getCategoryIdByName(CatName);

							if (b5) {
								System.out.println("***** Category Found, please add books *****");

								System.out.println("Enter Book name:");
								String Bname = sc.nextLine();

								System.out.println("Enter book type:");
								String Btype = sc.nextLine();

								System.out.println("Enter Book Edition year:");
								int Editiontype = sc.nextInt();

								System.out.println("Enter Book price:");
								int Bprice = sc.nextInt();

								System.out.println("Enter Book Author name:");
								sc.nextLine();
								String Author = sc.nextLine();

								model2.setBname(Bname);
								model2.setBtype(Btype);
								model2.setEdyear(Editiontype);
								model2.setBprice(Bprice);
								model2.setAuthor(Author);
								model2.setCid(id);
								boolean b4 = bookservice.isAddNewBooks(model2);

								if (b4) {
									System.out.println("Book added successfully!");
								} else {
									System.out.println("Failed to add book.");
								}
							} else {
								System.out.println("Category not found.");
							}
							break;

						case 7:

							System.out.println("Following are the categories...");
							List<CategoryModel> list11 = categoryservice.getAllCategory();

							if (!list11.isEmpty()) {
								for (CategoryModel s : list11) {
									System.out.println(s.getCId() + "\t" + s.getCname());
								}
							} else {
								System.out.println("Categories not available --------->");
							}

							System.out.println("Enter category name to display the list:");
							sc.nextLine(); // Consume newline
							String cat_name = sc.nextLine();

							int categoryId = categoryservice.getCategoryIdByName(cat_name);

							List<BookModel> list3 = bookservice.getBookListByCategoryId(categoryId);

							if (!list3.isEmpty()) {
								System.out.println("------------------ Book List ------------------");
								System.out.printf("%-5s %-20s %-15s %-20s %-10s%n", "ID", "Name", "Type", "Author",
										"Year");
								System.out.println("------------------------------------------------------------");
								for (BookModel s : list3) {
									System.out.printf("%-5d %-20s %-15s %-20s %-10d%n", s.getBid(), s.getBname(),
											s.getBtype(), s.getAuthor(), s.getEdyear());
								}
							} else {
								System.out.println("Data is not available");
							}

							System.out.println("----------------------------------------------");

							break;
						case 8:

							List<BookModel> list4 = bookservice.getAllBooks();
							if (list4 != null && !list4.isEmpty()) {
								System.out.println("------------------ Book List ------------------");
								System.out.printf("%-5s %-20s %-15s %-20s %-10s%n", "ID", "Name", "Type", "Author",
										"Year");
								System.out.println("------------------------------------------------------------");
								for (BookModel s : list4) {
									System.out.printf("%-5d %-20s %-15s %-20s %-10d%n", s.getBid(), s.getBname(),
											s.getBtype(), s.getAuthor(), s.getEdyear());
								}
							} else {
								System.out.println("Data is not available");
							}

							System.out.println("Enter present Book name for update:");
							sc.nextLine();
							String presentBook = sc.nextLine();

							System.out.println("Enter New Book name:");
							String updateBook = sc.nextLine();

							System.out.println("Enter book type:");
							String type = sc.nextLine();

							System.out.println("Enter Book Edition year:");
							int Edition = sc.nextInt();

							System.out.println("Enter Book price:");
							int price = sc.nextInt();

							System.out.println("Enter Book Author name:");
							sc.nextLine();
							String author = sc.nextLine();

							boolean B1 = bookservice.updateBookByName(presentBook, updateBook, type, Edition, price,
									author);
							System.out.println(B1);

							if (B1) {
								System.out.println("Book Updated");
							} else {
								System.out.println("Book Not Updated");
							}
							System.out.println(
									"------------------------------------------------------------------------");
							break;

						case 9:
							System.out.println("Enter book name for search:");
							sc.nextLine();
							String SearchBook = sc.nextLine();
							boolean B3 = bookservice.searchBookByName(SearchBook);
							if (B3) {
								System.out.println("Book Found");
							} else {
								System.out.println("Book Not Found");
							}
							System.out.println(
									"------------------------------------------------------------------------");
							break;

						case 10:
							List<BookModel> list5 = bookservice.getAllBooks();
							if (list5 != null && !list5.isEmpty()) {
								System.out.println("------------------ Book List ------------------");
								System.out.printf("%-5s %-20s %-15s %-20s %-10s%n", "ID", "Name", "Type", "Author",
										"Year");
								System.out.println("------------------------------------------------------------");
								for (BookModel s : list5) {
									System.out.printf("%-5d %-20s %-15s %-20s %-10d%n", s.getBid(), s.getBname(),
											s.getBtype(), s.getAuthor(), s.getEdyear());
								}
							} else {
								System.out.println("Data is not available");
							}

							System.out.println("Enter book name for delete:");
							sc.nextLine();
							String DeleteBook = sc.nextLine();
							boolean B4 = bookservice.deleteBookByName(DeleteBook);
							if (B4) {
								System.out.println("Book Deleted sucessfully....");
							} else {
								System.out.println("error occured");
							}
							System.out.println(
									"------------------------------------------------------------------------");
							break;

						case 11:
							List<UserModel> list2 = userservice.ViewAllUser();
							if (!list2.isEmpty()) {
							    
							    System.out.println("------------------ User List ------------------");
							    System.out.printf("%-5s %-20s %-25s %-20s %-15s %-15s %-10s%n", 
							        "UID", "Name", "Email", "Address", "Phone", "Date", "Gender");
							    System.out.println("---------------------------------------------------------------------" +
							                       "--------------------------------");

		
							    for (UserModel s : list2) {
							        System.out.printf("%-5d %-20s %-25s %-20s %-15s %-15s %-10s%n", 
							            s.getUid(), 
							            s.getUname(), 
							            s.getUemail(), 
							            s.getUaddress(), 
							            s.getUphone(), 
							            s.getDate(), 
							            s.getGender());
							    }
							} else {
							    System.out.println("Users not available --------->");
							}

							break;

						case 12:

							break;

						case 13:

							break;

						case 14:

							break;

						case 15:
							break;

						default:
							System.out.println("Wrong choice");
						}
					} while (ch1 != 11);
				} else {
					System.out.println("Invalid Admin details ");

				}
				break;
			case 2:
				System.out.println("1: For New User == Register");
				System.out.println("2: For Existing User == Login");
				System.out.print("Enter your choice: ");
				int ch2 = sc.nextInt();

				switch (ch2) {

				case 1:
					System.out.println("WELCOME TO REGISTER PAGE");
					System.out.println("***********************************");

					System.out.println("Please enter your details to register:");

					// Collecting user details
					System.out.print("Enter your name: ");
					sc.nextLine(); // consume the newline left by nextInt() earlier
					String name = sc.nextLine();

					System.out.print("Enter your email: ");
					String email = sc.nextLine();

					System.out.print("Enter your password: ");
					String Userpassword = sc.nextLine();

					System.out.print("Enter your Mobile no: ");
					int phone = sc.nextInt();

					System.out.print("Enter your address: ");
					sc.nextLine(); // consume the newline
					String address = sc.nextLine();

					System.out.print("Enter your gender (Male/Female/Other): ");
					String gender = sc.nextLine();

					System.out.print("Enter your Aadhar no: ");
					long Aadhar = sc.nextLong();

					// Setting user details in the model
					model3.setUname(name);
					model3.setAdharNo(Aadhar);
					model3.setGender(gender);
					model3.setPassword(Userpassword);
					model3.setUemail(email);
					model3.setUphone(phone);
					model3.setUaddress(address);

					try {
						// Register user and check if successful
						boolean isAdded = userservice.isAddNewUser(model3);
						if (isAdded) {
							System.out.println("User added successfully!");
							System.out.println("Registration successful for user: " + name);

							// Display categories in the library
							System.out.println("Available Categories in the library:");
							List<CategoryModel> list11 = categoryservice.getAllCategory();

							if (!list11.isEmpty()) {
								for (CategoryModel s : list11) {
									System.out.println(s.getCId() + "\t" + s.getCname());
								}
							} else {
								System.out.println("Categories not available.");
							}

							// Asking for the category name
							System.out.println("Enter category name to display the list:");
							sc.nextLine(); // consume the newline
							String cat_name = sc.nextLine();

							int categoryId = categoryservice.getCategoryIdByName(cat_name);

							List<BookModel> list3 = bookservice.getBookListByCategoryId(categoryId);

							if (!list3.isEmpty()) {
								System.out.println("------------------ Book List ------------------");
								System.out.printf("%-5s %-20s %-15s %-20s %-10s%n", "ID", "Name", "Type", "Author",
										"Year");
								System.out.println("------------------------------------------------------------");
								for (BookModel s : list3) {
									System.out.printf("%-5d %-20s %-15s %-20s %-10d%n", s.getBid(), s.getBname(),
											s.getBtype(), s.getAuthor(), s.getEdyear());
								}
							} else {
								System.out.println("Data is not available.");
							}

							System.out.println("----------------------------------------------");
							int userId = userservice.getUserIdByName(name);

							System.out.print("Enter number of books to borrow: ");
							int numberOfBooks = sc.nextInt();

							List<Integer> bookIds = new ArrayList<Integer>();
							System.out.println("Enter the Book IDs:");

							for (int i = 0; i < numberOfBooks; i++) {
								int bookId = sc.nextInt();
								bookIds.add(bookId);

							}

							boolean isAdded1 = userservice.addBooksToUser(userId, bookIds);

							List<String> userBooks = userservice.getBooksByUser(userId);
							System.out.println("Books borrowed by user " + name + ": " + userBooks);
							System.out.println("***********THANK YOU ************");
						}
					} catch (Exception e) {
						System.out.println("An error occurred during registration: " + e.getMessage());
					}
					break;

				case 2:
					System.out.println("WELCOME TO LOGIN PAGE");
					System.out.println("***********************************");

					System.out.print("Enter your email: ");
					sc.nextLine();
					String loginEmail = sc.nextLine();

					System.out.print("Enter your password: ");
					String loginPassword = sc.nextLine();

					boolean loginSuccess = userservice.checkUserLogin(loginEmail, loginPassword);
					if (loginSuccess) {
						System.out.println("Login successful! Welcome back.");
					} else {
						System.out.println("Invalid credentials. Please try again.");
					}
					System.out.println("-----------------------------------------------------------------------");
					System.out.println();

					// Display categories in the library
					System.out.println("Available Categories in the library:");
					List<CategoryModel> list11 = categoryservice.getAllCategory();

					if (!list11.isEmpty()) {
						for (CategoryModel s : list11) {
							System.out.println(s.getCId() + "\t" + s.getCname());
						}
					} else {
						System.out.println("Categories not available.");
					}

					// Asking for the category name
					System.out.println("Enter category name to display the list:");
					sc.nextLine(); // consume the newline
					String cat_name = sc.nextLine();

					int categoryId = categoryservice.getCategoryIdByName(cat_name);

					List<BookModel> list3 = bookservice.getBookListByCategoryId(categoryId);

					if (!list3.isEmpty()) {
						System.out.println("------------------ Book List ------------------");
						System.out.printf("%-5s %-20s %-15s %-20s %-10s%n", "ID", "Name", "Type", "Author", "Year");
						System.out.println("------------------------------------------------------------");
						for (BookModel s : list3) {
							System.out.printf("%-5d %-20s %-15s %-20s %-10d%n", s.getBid(), s.getBname(), s.getBtype(),
									s.getAuthor(), s.getEdyear());
						}
					} else {
						System.out.println("Data is not available.");
					}

					System.out.println("----------------------------------------------");
					String USER = userservice.getUnameByEmail(loginEmail);
					int userId = userservice.getUserIdByName(USER);

					System.out.print("Enter number of books to borrow: ");
					int numberOfBooks = sc.nextInt();

					List<Integer> bookIds = new ArrayList<Integer>();
					System.out.println("Enter the Book IDs:");

					for (int i = 0; i < numberOfBooks; i++) {
						int bookId = sc.nextInt();
						bookIds.add(bookId);

					}

					boolean isAdded1 = userservice.addBooksToUser(userId, bookIds);

					List<String> userBooks = userservice.getBooksByUser(userId);
					System.out.println("Books borrowed by user " + USER + ": " + userBooks);

					boolean B6 = bookservice.deleteBorrowedBook(userBooks);
					System.out.println(B6 + "--------------");
					if (B6) {
						System.out.println("\n Available Books after Borrowing:");
						List<BookModel> availableBooks = bookservice.getAllBooks(); // Method to fetch available books
						if (!availableBooks.isEmpty()) {
							System.out.printf("%-5s %-20s %-15s %-20s %-10s%n", "ID", "Name", "Type", "Author", "Year");
							for (BookModel book : availableBooks) {
								System.out.printf("%-5d %-20s %-15s %-20s %-10d%n", book.getBid(), book.getBname(),
										book.getBtype(), book.getAuthor(), book.getEdyear());
							}
						} else {
							System.out.println("No books available.");
						}

					} else {
						System.out.println("No books available.");
					}

					System.out.println("*********** THANK YOU ************");
				}

				break;

			default:
				System.out.println("Invalid details..");
			}
		} while (ch > 0);
	}}
