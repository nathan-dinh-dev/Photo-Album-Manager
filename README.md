# Photo Album Manager

A **desktop-based photo album manager** built using **Java Swing**. This application allows users to manage their photo collections by adding, viewing, deleting, and navigating photos. It demonstrates the use of the **MVC pattern**, **Iterator pattern**, and **Strategy pattern** to organize the code efficiently.

## Requirements
- Java JDK 8+ installed.
- A photo collection on your local machine for testing.
  
## Features

- **Add Photos**: Select photos from your file system using a file chooser.
- **View Current Photo**: Display the currently selected photo with a preview.
- **Navigate Photos**: Use **Next** and **Previous** buttons to navigate through the photos.
- **Photo List with Thumbnails**: See all photos on the left, with thumbnail previews.
- **Sort Photos Dynamically**: Sort by **Name**, **Date Added**, or **File Size**.
- **Delete Photos**: Remove photos from the album by name.
- **User-Friendly Layout**: 
  - **List of photos** on the **left**.
  - **Current photo preview** on the **right**.
  - **Control buttons** at the **bottom**.

## Technologies Used

- **Java Swing**: For the graphical user interface (GUI).
- **Design Patterns**:
  - **MVC Pattern**: Separates the model, view, and controller to organize code logically.
  - **Iterator Pattern**: Manages the navigation of photos using `next()` and `previous()` methods.
  - **Strategy Pattern**: Allows dynamic sorting based on name, date, or size.

## Installation

1. **Clone the Repository**:
   ```
   git clone https://github.com/your-username/photo-album-manager.git
   cd photo-album-manager
   ```
   
2. **Compile the Code**:
Make sure you have Java JDK installed. Use the following command to compile:
   ```
   javac -d bin -sourcepath src src/*.java
   ```

3. **Run the Application**:
   ```
   java -cp bin PhotoAlbumApp
   ```

## How to Use

1. **Add Photos**:

   - Click the "**Add Photo**" button to open a file chooser.
   - Select a photo from your system. The photo will be added to the list on the left.

2. **Navigate Photos**:

   - Use the **Next** and **Previous** buttons to navigate between photos.
   - The current photo will be displayed on the right.

3. **Sort Photos**:

   - Choose a sorting option from the **Sort By** dropdown (Name, Date, or Size).
   - The photo list will update based on the selected sort order.

4. **Delete a Photo**:

   - Click the "**Delete Photo**" button and enter the name of the photo to delete.
