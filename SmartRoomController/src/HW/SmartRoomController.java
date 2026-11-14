package HW;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SmartRoomController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // =====================================================================
        // 1. Top Header: (title & subtitle)
        // =====================================================================
        Label lbl_title = new Label();
        lbl_title.setText("Smart Room Controller");
        lbl_title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 34));
        lbl_title.setTextFill(Color.DARKBLUE);

        Label lbl_sub = new Label();
        lbl_sub.setText("Control your room settings easily");
        lbl_sub.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        lbl_sub.setTextFill(Color.NAVY);

        // Grouping titles in a VBox
        VBox vb_header = new VBox();
        vb_header.getChildren().addAll(lbl_title, lbl_sub);
        vb_header.setAlignment(Pos.CENTER);
        vb_header.setSpacing(5);
        vb_header.setPadding(new Insets(15, 0, 10, 0));

        // =====================================================================
        // 2. Room Preview: Left side (image & bulb/Circle)
        // =====================================================================
        Label lbl_preview = new Label("Room Preview");
        lbl_preview.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 22));
        lbl_preview.setTextFill(Color.NAVY);

        // Loading the room image
        Image image = new Image(getClass().getResourceAsStream("room.png"));
        ImageView iv = new ImageView(image);
        iv.setFitWidth(380);
        iv.setFitHeight(570);

        // Creating the bulb (Circle)
        Circle cr_bulb = new Circle(45, Color.GRAY);
        cr_bulb.setTranslateY(-120);

        // StackPane to display a simple room preview containing a light bulb
        StackPane sp_preview = new StackPane();
        sp_preview.getChildren().addAll(iv, cr_bulb, lbl_preview);
        sp_preview.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        StackPane.setAlignment(lbl_preview, Pos.TOP_CENTER);
        StackPane.setAlignment(iv, Pos.BOTTOM_CENTER);
        StackPane.setMargin(lbl_preview, new Insets(15, 0, 0, 15));
        StackPane.setMargin(iv, new Insets(50, 10, 10, 10));

        // =====================================================================
        // 3. Settings Area: Center/Right side for user inputs
        // =====================================================================
        // Sections background is Light Blue(ALICEBLUE)
        Background section_bg = new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY));

        // --- A. Room Information ---
        Label lbl_info = new Label("🏠 Room Information");
        lbl_info.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lbl_info.setTextFill(Color.NAVY);

        TextField tf_room = new TextField();
        tf_room.setPromptText("Room Name");
        tf_room.setFocusTraversable(false);
        tf_room.setFont(new Font("Arial", 14));

        TextField tf_temp = new TextField();
        tf_temp.setPromptText("Temperature (°C)");
        tf_temp.setFocusTraversable(false);
        tf_temp.setFont(new Font("Arial", 14));

        TextField tf_timer = new TextField();
        tf_timer.setPromptText("Timer (minutes)");
        tf_timer.setFocusTraversable(false);
        tf_timer.setFont(new Font("Arial", 14));

        VBox vb_inputs = new VBox(lbl_info, tf_room, tf_temp, tf_timer);
        vb_inputs.setSpacing(8);
        vb_inputs.setBackground(section_bg);
        vb_inputs.setPadding(new Insets(10));

        // --- B. Room Mode ---
        Label lbl_mode = new Label("✨ Room Mode");
        lbl_mode.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lbl_mode.setTextFill(Color.NAVY);

        RadioButton rbtn_study = new RadioButton("Study Mode 📖");
        rbtn_study.setTextFill(Color.DARKSLATEGRAY);
        rbtn_study.setFont(new Font("Arial", 14));

        RadioButton rbtn_relax = new RadioButton("Relax Mode ☕");
        rbtn_relax.setTextFill(Color.DARKSLATEGRAY);
        rbtn_relax.setFont(new Font("Arial", 14));

        RadioButton rbtn_sleep = new RadioButton("Sleep Mode 🌙");
        rbtn_sleep.setTextFill(Color.DARKSLATEGRAY);
        rbtn_sleep.setFont(new Font("Arial", 14));

        // Grouping radio buttons so only one can be selected at a time
        ToggleGroup group_mode = new ToggleGroup();
        rbtn_study.setToggleGroup(group_mode);
        rbtn_relax.setToggleGroup(group_mode);
        rbtn_sleep.setToggleGroup(group_mode);
        rbtn_study.setSelected(true); // Default selection

        VBox vb_mode = new VBox(lbl_mode, rbtn_study, rbtn_relax, rbtn_sleep);
        vb_mode.setSpacing(8);
        vb_mode.setBackground(section_bg);
        vb_mode.setPadding(new Insets(10));

        // --- C. Devices ---
        Label lbl_devices = new Label("🔌 Devices");
        lbl_devices.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lbl_devices.setTextFill(Color.NAVY);

        CheckBox cb_lights = new CheckBox("Lights 🔆");
        cb_lights.setTextFill(Color.DARKSLATEGRAY);
        cb_lights.setFont(new Font("Arial", 14));

        CheckBox cb_fan = new CheckBox("Fan 🌀");
        cb_fan.setTextFill(Color.DARKSLATEGRAY);
        cb_fan.setFont(new Font("Arial", 14));

        CheckBox cb_music = new CheckBox("Music 🎶");
        cb_music.setTextFill(Color.DARKSLATEGRAY);
        cb_music.setFont(new Font("Arial", 14));

        CheckBox cb_curtains = new CheckBox("Open Curtains 🌅");
        cb_curtains.setTextFill(Color.DARKSLATEGRAY);
        cb_curtains.setFont(new Font("Arial", 14));

        VBox vb_devices = new VBox(lbl_devices, cb_lights, cb_fan, cb_music, cb_curtains);
        vb_devices.setSpacing(8);
        vb_devices.setBackground(section_bg);
        vb_devices.setPadding(new Insets(10));

        // --- D. Action Buttons & Message Box ---
        Button btn_apply = new Button("✅ Apply Settings");
        btn_apply.setCursor(Cursor.HAND);
        btn_apply.setTooltip(new Tooltip("Apply your settings"));
        btn_apply.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
        btn_apply.setTextFill(Color.WHITE);
        btn_apply.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Button btn_reset = new Button("🔄 Reset");
        btn_reset.setCursor(Cursor.HAND);
        btn_reset.setTooltip(new Tooltip("Reset all fields"));
        btn_reset.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        btn_reset.setTextFill(Color.WHITE);
        btn_reset.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15));

        HBox hb_btns = new HBox(btn_apply, btn_reset);
        hb_btns.setSpacing(15);

        // Label to show success or error messages dynamically
        Label lbl_msg = new Label("");
        lbl_msg.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lbl_msg.setWrapText(true);
        lbl_msg.setMinHeight(80);
        lbl_msg.setAlignment(Pos.TOP_LEFT);

        // VBox (input fields & mode options & device controls)
        VBox vb_settings = new VBox(vb_inputs, vb_mode, vb_devices, hb_btns, lbl_msg);
        vb_settings.setSpacing(10);
        vb_settings.setPadding(new Insets(15));
        vb_settings.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        vb_settings.setPrefSize(420, 630);

        // HBox (room preview & settings area)
        HBox hb_center = new HBox(sp_preview, vb_settings);
        hb_center.setSpacing(30);
        hb_center.setAlignment(Pos.TOP_CENTER);
        hb_center.setFillHeight(false);

        // =====================================================================
        // 4. Main Root
        // =====================================================================
        // Root BorderPane holding the header at the top and the content in the center
        BorderPane root = new BorderPane();
        root.setTop(vb_header);
        root.setCenter(hb_center);
        root.setBackground(section_bg);

        // =====================================================================
        // 5. Actions, Events & Animations
        // =====================================================================
        boolean[] is_applied = {false}; // Array used to bypass lambda variable restrictions

        // A reusable block of code to update the success message dynamically
        Runnable update_msg = () -> {
            if (is_applied[0]) {
                String mode = "Study Mode";
                if (rbtn_relax.isSelected()) {
                    mode = "Relax Mode";
                }
                if (rbtn_sleep.isSelected()) {
                    mode = "Sleep Mode";
                }

                String devices = "";
                if (cb_lights.isSelected()) {
                    devices += "Lights, ";
                }
                if (cb_fan.isSelected()) {
                    devices += "Fan, ";
                }
                if (cb_music.isSelected()) {
                    devices += "Music, ";
                }
                if (cb_curtains.isSelected()) {
                    devices += "Open Curtains, ";
                }

                // Remove the last comma and space if devices are selected
                if (!devices.isEmpty()) {
                    devices = devices.substring(0, devices.length() - 2);
                } else {
                    devices = "None";
                }

                lbl_msg.setText("✅ Settings applied successfully!\n"
                        + "Room: " + tf_room.getText() + "\n"
                        + "Mode: " + mode + "\n"
                        + "Devices: " + devices + "\n"
                        + "Temperature: " + tf_temp.getText() + "°C | Timer: " + tf_timer.getText() + " minutes");
                lbl_msg.setTextFill(Color.GREEN); // Green text for success
            }
        };

        // Animation for the light bulb
        FillTransition ft_bulb = new FillTransition(Duration.seconds(1), cr_bulb);

        // Turn the light bulb on/off when checking the Lights box
        cb_lights.setOnAction(e -> {
            if (cb_lights.isSelected()) {
                ft_bulb.setFromValue(Color.GRAY);
                ft_bulb.setToValue(Color.YELLOW);
            } else {
                ft_bulb.setFromValue(Color.YELLOW);
                ft_bulb.setToValue(Color.GRAY);
            }
            ft_bulb.play();
        });

        // Apply settings button event handler
        btn_apply.setOnAction(e -> {
            // Check if any field is empty
            if (tf_room.getText().isEmpty() || tf_temp.getText().isEmpty() || tf_timer.getText().isEmpty()) {
                lbl_msg.setText("Please fill in all required fields.");
                lbl_msg.setTextFill(Color.RED); // Red text for errors
                is_applied[0] = false;
            } else {
                try {
                    // Try parsing the input to double to ensure numeric values
                    double temp = Double.parseDouble(tf_temp.getText());
                    double timer = Double.parseDouble(tf_timer.getText());

                    // Ensure numbers are positive
                    if (temp <= 0 || timer <= 0) {
                        lbl_msg.setText("Please enter valid temperature and timer values.\nTemperature and Timer must contain positive numeric values.");
                        lbl_msg.setTextFill(Color.RED);
                        is_applied[0] = false;
                    } else {
                        is_applied[0] = true;
                        update_msg.run(); // Call the update message logic
                    }
                } catch (Exception ex) {
                    // Catch block if parsing fails (e.g., user entered letters)
                    lbl_msg.setText("Please enter valid temperature and timer values.\nTemperature and Timer must contain positive numeric values.");
                    lbl_msg.setTextFill(Color.RED);
                    is_applied[0] = false;
                }
            }
        });

        // Reset button event handler to clear all inputs and return to default state
        btn_reset.setOnAction(e -> {
            is_applied[0] = false;
            tf_room.setText("");
            tf_temp.setText("");
            tf_timer.setText("");
            rbtn_study.setSelected(true); // Default mode
            cb_lights.setSelected(false);
            cb_fan.setSelected(false);
            cb_music.setSelected(false);
            cb_curtains.setSelected(false);
            lbl_msg.setText("");
            cr_bulb.setFill(Color.GRAY); // Turn off the light
        });

        // =====================================================================
        // 6. Scene & Stage
        // =====================================================================
        Scene s = new Scene(root, 1200, 780);
        stage.setScene(s);
        stage.setTitle("Smart Room Controller");
        stage.setResizable(false);
        stage.show();
    }
}
