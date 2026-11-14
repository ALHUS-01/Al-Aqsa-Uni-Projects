// Husam Akram Hamad Braika - 1320237093
package husamakrambraika_1320237093;

import java.io.*;
import java.util.*;

public class Process {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // متغيرات لتتبع إحصائيات المبيعات
    private int totalBooksSold = 0;
    private double totalRevenue = 0.0;

    // ثوابت لتلوين النصوص في شاشة المخرجات لتسهيل القراءة
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";

    // يقوم بتحميل البيانات المحفوظة تلقائيا عند تشغيل البرنامج
    public Process() {
        loadData();
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println(YELLOW + "No books available in the library." + RESET);
            return;
        }
        System.out.println(CYAN + "--- Book List ---" + RESET);
        for (Book b : books) {
            System.out.println(b.toString());
        }
    }

    public void addBook() {
        System.out.print("Enter Book ID: ");
        String id = input.nextLine();

        for (Book b : books) {
            if (b.getBookId().equals(id)) {
                System.out.println(RED + "Error: A book with this ID already exists." + RESET);
                return; // الخروج من الدالة إذا كان الكتاب موجوداً
            }
        }

        // استقبال بيانات الكتاب الأساسية
        System.out.print("Enter Book Title: ");
        String title = input.nextLine();
        System.out.print("Enter Category: ");
        String category = input.nextLine();

        // استقبال بيانات المؤلف (تطبيق مفهوم التجميع - Aggregation)
        System.out.println(CYAN + "--- Enter Author Details ---" + RESET);
        System.out.print("Enter Author ID (National Identity): ");
        String authorId = input.nextLine();
        System.out.print("Enter Author Name: ");
        String authorName = input.nextLine();
        System.out.print("Enter Author Gender: ");
        String authorGender = input.nextLine();
        System.out.print("Enter Author Phone: ");
        String authorPhone = input.nextLine();
        System.out.print("Enter Author Address: ");
        String authorAddress = input.nextLine();
        System.out.print("Enter Number of Books Authored: ");
        int noOfBooks = Integer.parseInt(input.nextLine());
        System.out.print("Enter Author Email: ");
        String authorEmail = input.nextLine();
        System.out.print("Enter Author Workplace: ");
        String workplace = input.nextLine();

        // استقبال باقي بيانات الكتاب
        System.out.println(CYAN + "--- Enter Remaining Book Details ---" + RESET);
        System.out.print("Enter Publisher: ");
        String publisher = input.nextLine();
        System.out.print("Enter Edition Year: ");
        int year = Integer.parseInt(input.nextLine());
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(input.nextLine());
        System.out.print("Enter Quantity: ");
        int qty = Integer.parseInt(input.nextLine());

        // إنشاء كائن للمؤلف أولاً، ثم تمريره إلى كائن الكتاب
        Author author = new Author(authorId, authorName, authorGender, authorPhone, authorAddress, noOfBooks, authorEmail, workplace);
        Book newBook = new Book(id, title, category, author, publisher, year, price, qty);

        // إضافة الكتاب للقائمة
        books.add(newBook);
        System.out.println(GREEN + "Book added successfully." + RESET);
    }

    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = input.nextLine();

        // البحث عن الكتاب المطلوب حذفه
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(id)) {
                // شرط منطقي: لا يمكن حذف كتاب إذا كان هناك نسخ متوفرة منه
                if (books.get(i).getBookQuantity() > 0) {
                    System.out.println(RED + "Error: Cannot delete book. Quantity is greater than 0." + RESET);
                    return;
                }
                books.remove(i); // حذف الكتاب من القائمة
                System.out.println(GREEN + "Book deleted successfully." + RESET);
                return;
            }
        }
        System.out.println(YELLOW + "Book not found." + RESET);
    }

    public void editBookQuantity() {
        System.out.print("Enter Book ID to edit quantity: ");
        String id = input.nextLine();

        // البحث عن الكتاب
        for (Book b : books) {
            if (b.getBookId().equals(id)) {
                System.out.println(CYAN + "Book found: " + b.getBookName() + RESET);
                System.out.println("Current Quantity: " + b.getBookQuantity());

                System.out.print("Enter the new quantity: ");
                int newQty = Integer.parseInt(input.nextLine());

                // التأكد من أن الكمية المدخلة منطقية (ليست سالبة)
                if (newQty >= 0) {
                    b.setBookQuantity(newQty); // تحديث الكمية
                    System.out.println(GREEN + "Book quantity updated successfully! New Quantity: " + b.getBookQuantity() + RESET);
                } else {
                    System.out.println(RED + "Error: Quantity cannot be negative." + RESET);
                }
                return;
            }
        }
        System.out.println(YELLOW + "Book not found." + RESET);
    }

    public void searchBook() {
        System.out.println("Search by: 1. Title (Partial)  2. Author  3. Category");
        System.out.print("Choose option: ");
        String opt = input.nextLine();
        System.out.print("Enter search term: ");
        String term = input.nextLine().toLowerCase(); // تحويل النص لحروف صغيرة لتسهيل البحث
        boolean found = false;

        System.out.println(CYAN + "--- Search Results ---" + RESET);
        // المرور على جميع الكتب ومقارنة النص المدخل
        for (Book b : books) {
            boolean match = false;
            if (opt.equals("1") && b.getBookName().toLowerCase().contains(term)) {
                match = true;
            } else if (opt.equals("2") && b.getBookAuthor().getName().toLowerCase().contains(term)) {
                match = true;
            } else if (opt.equals("3") && b.getBookCategory().toLowerCase().contains(term)) {
                match = true;
            }

            // إذا تم العثور على تطابق، قم بطباعة بيانات الكتاب
            if (match) {
                System.out.println(b.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println(YELLOW + "No matching books found." + RESET);
        }
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println(YELLOW + "No students available." + RESET);
            return;
        }
        System.out.println(CYAN + "--- Student List ---" + RESET);
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    public void addStudent() {
        System.out.print("Enter Student ID: ");
        String studentId = input.nextLine();

        // التحقق من عدم تكرار الرقم الجامعي
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                System.out.println(RED + "Error: Student ID already exists." + RESET);
                return;
            }
        }

        // استقبال البيانات الشخصية للطالب (الموروثة من كلاس Person)
        System.out.println(CYAN + "--- Enter Personal Details ---" + RESET);
        System.out.print("Enter National Identity Number: ");
        String identityNumber = input.nextLine();
        System.out.print("Enter Full Name: ");
        String name = input.nextLine();
        System.out.print("Enter Gender: ");
        String gender = input.nextLine();
        System.out.print("Enter Phone: ");
        String phone = input.nextLine();
        System.out.print("Enter Address: ");
        String address = input.nextLine();

        // استقبال البيانات الأكاديمية والمالية للطالب
        System.out.println(CYAN + "--- Enter Academic Details ---" + RESET);
        System.out.print("Enter Specialization: ");
        String spec = input.nextLine();
        System.out.print("Enter Enrolled Date (e.g., 2026): ");
        String date = input.nextLine();
        System.out.print("Enter Budget: ");
        double budget = Double.parseDouble(input.nextLine());

        // إنشاء كائن الطالب وإضافته للقائمة
        Student newStudent = new Student(identityNumber, name, gender, phone, address, studentId, spec, date, budget);
        students.add(newStudent);
        System.out.println(GREEN + "Student added successfully." + RESET);
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = input.nextLine();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                students.remove(i);
                System.out.println(GREEN + "Student deleted successfully." + RESET);
                return;
            }
        }
        System.out.println(YELLOW + "Student not found." + RESET);
    }

    public void depositMoney() {
        System.out.print("Enter Student ID to recharge budget: ");
        String studentId = input.nextLine();
        Student student = null;

        // البحث عن الطالب
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                student = s;
                break;
            }
        }

        // التحقق من وجود الطالب
        if (student == null) {
            System.out.println(YELLOW + "Student not found." + RESET);
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(input.nextLine());

        // التأكد من أن قيمة الإيداع موجبة، ثم إضافتها للرصيد
        if (amount > 0) {
            student.setBudget(student.getBudget() + amount);
            System.out.println(GREEN + "Deposit successful! New budget: $" + student.getBudget() + RESET);
        } else {
            System.out.println(RED + "Invalid amount. Deposit failed." + RESET);
        }
    }

    public void buyBookMenu() {
        System.out.print("Enter Student ID: ");
        String studentId = input.nextLine();
        Student student = null;

        // إيجاد الطالب
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println(YELLOW + "Student not found." + RESET);
            return;
        }

        System.out.print("Enter Book ID to buy: ");
        String bookId = input.nextLine();
        Book book = null;

        // إيجاد الكتاب
        for (Book b : books) {
            if (b.getBookId().equals(bookId)) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println(YELLOW + "Book not found." + RESET);
            return;
        }

        // التحقق من وجود نسخ كافية، وأن رصيد الطالب يسمح بالشراء
        if (book.getBookQuantity() > 0 && student.getBudget() >= book.getBookPrice()) {
            // خصم المبلغ من رصيد الطالب
            student.setBudget(student.getBudget() - book.getBookPrice());
            // تقليل عدد النسخ المتوفرة من الكتاب
            book.setBookQuantity(book.getBookQuantity() - 1);

            // تحديث إحصائيات المبيعات
            totalBooksSold++;
            totalRevenue += book.getBookPrice();

            System.out.println(GREEN + "Transaction successful! Remaining budget: $" + student.getBudget() + RESET);
        } else {
            // في حال عدم توفر رصيد أو نسخ
            System.out.println(RED + "Transaction failed. Check stock or student budget." + RESET);
        }
    }

    public void printStatistics() {
        System.out.println(CYAN + "--- Library Statistics ---" + RESET);

        int totalStock = 0;
        // حساب إجمالي عدد النسخ المتوفرة لجميع الكتب
        for (Book b : books) {
            totalStock += b.getBookQuantity();
        }

        System.out.println("Total Registered Students: " + students.size());
        System.out.println("Total Unique Books: " + books.size());
        System.out.println("Total Copies in Stock: " + totalStock);
        System.out.println("Total Books Sold: " + totalBooksSold);
        System.out.println("Total Revenue from Sold Books: $" + totalRevenue);
        System.out.println(CYAN + "--------------------------" + RESET);
    }

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("LibraryData.dat"))) {
            oos.writeObject(books);        // حفظ قائمة الكتب
            oos.writeObject(students);     // حفظ قائمة الطلاب
            oos.writeInt(totalBooksSold);  // حفظ عدد الكتب المباعة
            oos.writeDouble(totalRevenue); // حفظ الرصيد العائد
            System.out.println(GREEN + "Data saved successfully." + RESET);
        } catch (IOException e) {
            System.out.println(RED + "Error saving data: " + e.getMessage() + RESET);
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("LibraryData.dat"))) {
            books = (ArrayList<Book>) ois.readObject();
            students = (ArrayList<Student>) ois.readObject();
            totalBooksSold = ois.readInt();
            totalRevenue = ois.readDouble();
        } catch (FileNotFoundException e) {
            // في حالة عدم وجود الملف (أول مرة يتم فيها تشغيل البرنامج)
            System.out.println(YELLOW + "No previous data found. Starting fresh." + RESET);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(RED + "Error loading data. Creating new system..." + RESET);
        }
    }
}
// Husam Akram Hamad Braika - 1320237093
