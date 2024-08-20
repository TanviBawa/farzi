module farzi {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.net.http;
	requires com.google.gson;
	
	opens application to javafx.graphics, javafx.fxml, com.google.gson;
}
