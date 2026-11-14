# 📚 Smart Room Controller - JavaFX GUI

A graphical user interface (GUI) application developed in Java using the JavaFX framework. This project simulates a smart room control panel, allowing users to interactively manage room settings such as temperature, lighting, and operating modes.

## 🛠 Technologies Used
* **Programming Language:** Java
* **UI Framework:** JavaFX
* **IDE:** Visual Studio Code (Java Extension Pack & JavaFX support)

## ✨ System Features
* **Interactive UI:** Built using a well-structured combination of JavaFX layouts (`BorderPane`, `VBox`, `HBox`, `StackPane`) and UI controls (`Label`, `TextField`, `RadioButton`, `CheckBox`, `Button`). The layout is smartly divided into a visual room preview on the left and a control panel on the right.
* **Visual Feedback:** 
  * Features a room preview image (`room.png`) with an overlaying interactive light bulb.
  * Implements `FillTransition` animation to simulate the light bulb turning on/off seamlessly when the "Lights" checkbox is toggled.
* **Input Validation & Error Handling:** Ensures that the temperature and timer fields receive valid, positive numeric inputs. It provides dynamic user feedback via success (green) or error (red) messages.
* **State Management:** Includes functionality to apply customized settings (Mode, Devices, Temperature, Timer) and a "Reset" feature to clear all fields and restore default states instantly.

## 🚀 How to Run
To run this project locally:
1. Ensure you have **Java** and **JavaFX** configured in your environment.
2. Open the project in Visual Studio Code.
3. Make sure `room.png` is placed in the same directory/package as `SmartRoomController.java`.
4. Run the `SmartRoomController.java` file.

## 📂 Project Structure & Attachments
* `SmartRoomController.java`: The main JavaFX application source code containing the UI layout, event handlers, and animations.
* `room.png`: The background image used in the UI's room preview section.

---
**Developed by:** ALHUS