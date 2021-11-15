module com.haziqfaiz.oopdsassignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.haziqfaiz.oopdsassignment2 to javafx.fxml;
    exports com.haziqfaiz.oopdsassignment2;
}